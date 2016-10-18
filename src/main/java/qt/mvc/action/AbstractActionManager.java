package qt.mvc.action;

import qt.mvc.annotation.Inject;
import qt.mvc.common.BeanFactory;
import qt.mvc.clazzload.MVCClassManager;
import qt.mvc.clazzload.ReflectTool;
import qt.mvc.constant.ConstantClass;
import qt.mvc.entity.Model;
import qt.mvc.entity.ModelAndView;
import qt.mvc.entity.PageInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import freemarker.template.TemplateException;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import qt.mvc.outputwriter.HttpOutputWriter;

/**
 * Created by qiutian on 16-9-8.
 */
public abstract class AbstractActionManager implements ActionManager{

    private final static Logger logger = Logger.getLogger(AbstractActionManager.class);

    private final static MVCClassManager classManager ;

    //@Resource
    private HttpOutputWriter writer = new HttpOutputWriter();

    static {
        classManager = new MVCClassManager();
    }


    //@Override
    public ModelAndView doProccessMethod(PageInfo info) {
        ModelAndView mv = new ModelAndView();
        Class<?> controller;
        //Method actionMethod;
        Object instance;

        Object params = null;
        try {

            controller = classManager.getClassList().get(ConstantClass.CONFIG.getScannerPath() + "." + info.getControllerName());
            if (controller == null)
                return null;

            instance = controller.newInstance();
            //初始化类中属性
            InitProperties(controller,instance);

            logger.debug("action = "+info.getActionName());
            Method[] methods = controller.getDeclaredMethods();
            for (Method method : methods)
                if (method.getName().equals(info.getActionName())) {
                    Class<?> retclazz = method.getReturnType();
                    List<Object> paramsObj = new ArrayList<Object>();
                    Model model = null;
                    logger.debug("ReturnType = "+retclazz.getName());
                    //获取方法的参数对象 Get类型
                    Class<?>[] clazzes = method.getParameterTypes();
                    for (Class<?> class1 : clazzes) {

                        if (class1.equals(Model.class)) {
                            model = (Model) class1.newInstance();
                            paramsObj.add(model);
                        }
                        else {
                            params = class1.newInstance();
                            if (info.getparams().containsKey(ConstantClass.POST_JSON)){
                                ObjectMapper mapper = new ObjectMapper();
                                params = mapper.readValue(info.getparams().get(ConstantClass.POST_JSON), class1);
                            }

                            else
                                params = ReflectTool.Fill(class1, params, info.getparams());
                            paramsObj.add(params);
                        }
                    }
                    //Object[] paramsList = {params,model};
                    Object returnObj = null;
                    if (model == null)
                        returnObj = method.invoke(instance, params);
                    else{

                        returnObj = method.invoke(instance,paramsObj.toArray());
                    }
                    //returnObj = method.invoke(instance,new Object[]{params, model});

                    if (retclazz.getName().equals(ConstantClass.ModelAndView)){
                        mv = (ModelAndView) returnObj;
                    }
                    else if (retclazz.getName().equals(ConstantClass.STRING)){
                        String forward = (String)returnObj;
                        mv = new ModelAndView(forward,model.getMap());

                    }
                    else{
                        ObjectMapper mapper = new ObjectMapper();

                        //输出结果：{"name":"小民","age":20,"birthday":844099200000,"email":"xiaomin@sina.com"}
                        String json = mapper.writeValueAsString(returnObj);
                        System.out.println(json);
                        mv.setForwardPage("qt_json");
                        mv.setParams(json);
                    }
                    if (model != null)
                        logger.debug("Model Size:"+model.size());
                }
            logger.debug("Build Controller["+ info.getControllerName()+"]:"+controller.toString());
            //获取该类中的所有方法


        } catch (InstantiationException e) {
            logger.error(e);
        } catch (IllegalAccessException e) {
            logger.error(e);
        } catch (InvocationTargetException e) {
            logger.error(e);
        } catch (JsonProcessingException e) {
            //e.printStackTrace();
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
            //e.printStackTrace();
        }
        return mv;
    }

    //@Override
    public void doResult(ModelAndView mv, HttpServletRequest req, HttpServletResponse resp,ServletContext context ) throws ServletException, IOException, TemplateException {
        if (mv == null || mv.getForwardPage() == null) {
            req.getRequestDispatcher("/"+ConstantClass.CanNotFoundPage).forward(req, resp);
            return;
        }

        //Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        //cfg.setServletContextForTemplateLoading(context, null);
        //cfg.setDefaultEncoding("UTF-8");
        //System.out.println("DefaultEncoding="+cfg.getDefaultEncoding());
        //解决中文乱码问题
        //resp.setContentType("text/html;charset=UTF-8");

        //Template t = cfg.getTemplate(ConstantClass.CONFIG.getViewPath() + mv.getForwardPage()+".ftl");
        Map<String, Object> dataModel = new HashMap<String, Object>();
        //json格式输出
        if (mv.getForwardPage().equals("qt_json")){
            resp.setContentType("application/json; charset=UTF-8");
            PrintWriter pw=resp.getWriter();
            pw.println(mv.getParams());
            pw.flush();
            pw.close();
            return;
        }
        switch (ConstantClass.CONFIG.getViewType()){
            case 0:
                writer.JSPWriter(mv,req,resp,context);
                break;
            case 1:
                writer.FreemarkerWriter(mv,req,resp,context);
                break;
            case 2:
                writer.VelocityWriter(mv,req,resp,context);
                break;
        }

/*
        else if ( mv.getParams() != null) {


            Iterator entries = ((HashMap)mv.getParams()).entrySet().iterator();

            while (entries.hasNext()) {

                Map.Entry entry = (Map.Entry) entries.next();
                String key = (String) entry.getKey();
                Object val = entry.getValue();
                dataModel.put(key,val);
            }

        }


        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String str=sdf.format(date);
        //生成属性
        dataModel.put("LastUpdated", str);
        //自定义跳转
        PrintWriter out = resp.getWriter();

        try {

            t.process(dataModel, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
*/
        //PrintWriter out = response.getWriter();
    }

    private void InitProperties(Class<?> clazz,Object newInstance) throws IllegalAccessException, InstantiationException {
        Field[] f = clazz.getDeclaredFields();
        for(Field field : f){
            field.setAccessible(true);
            //System.out.println("[===========]"+field.getName()+":"+field.get(newInstance));
            Inject myAnnotation = field.getAnnotation(Inject.class);
            if (myAnnotation != null){
                String clazzName = "";
                if (myAnnotation.name().length()>0) {
                    clazzName = myAnnotation.name();
                }
                else {
                    clazzName = field.getName();
                }
                field.set(newInstance,BeanFactory.Create(clazzName));
                //System.out.println("Inject :" + clazzName);
            }

        }
    }
}
