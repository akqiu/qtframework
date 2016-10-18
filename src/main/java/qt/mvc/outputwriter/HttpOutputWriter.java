package qt.mvc.outputwriter;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import qt.mvc.common.ServletGzipUtil;
import qt.mvc.constant.ConstantClass;
import qt.mvc.entity.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by qiutian on 2016/9/28.
 */
public class HttpOutputWriter {

    public void JSPWriter(ModelAndView mv, HttpServletRequest req, HttpServletResponse resp, ServletContext context) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //Map<String, Object> dataModel = new HashMap<String, Object>();
        if ( mv.getParams() != null) {
            Iterator entries = ((HashMap)mv.getParams()).entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                String key = (String) entry.getKey();
                Object val = entry.getValue();
                req.setAttribute(key,val);
            }
        }
        RequestDispatcher dispather = req.getRequestDispatcher(ConstantClass.CONFIG.getViewPath() + mv.getForwardPage()+".jsp");
        //req.setAttribute("param2", "servlet");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String str=sdf.format(date);
        //生成属性
        req.setAttribute("LastUpdated", str);
        dispather.forward(req,resp);
    }

    public void FreemarkerWriter( ModelAndView mv, HttpServletRequest req, HttpServletResponse resp, ServletContext context ) throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setServletContextForTemplateLoading(context, null);
        cfg.setDefaultEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Template t = cfg.getTemplate(ConstantClass.CONFIG.getViewPath() + mv.getForwardPage()+".ftl");

        //File file = new File(path);
        //file.lastModified();

        Map<String, Object> dataModel = new HashMap<String, Object>();
        if ( mv.getParams() != null) {
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
        PrintWriter out = //ServletGzipUtil.createGzipPw(req,resp);
        resp.getWriter();

        try {
            t.process(dataModel, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    public void VelocityWriter( ModelAndView mv, HttpServletRequest req, HttpServletResponse resp, ServletContext context ) throws IOException {
        String path = req.getSession().getServletContext().getRealPath("");
        // 创建引擎
        VelocityEngine ve = new VelocityEngine();
        System.out.println("PATH="+path);
        // 设置模板加载路径，这里设置的是class下
        //ve.setProperty(Velocity.RESOURCE_LOADER, path);

        Properties properties = new Properties();

        //将当前路径设置到VelocityEngine 中
        properties.setProperty(ve.FILE_RESOURCE_LOADER_PATH, path);
        properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");

        ve.setProperty(ve.FILE_RESOURCE_LOADER_PATH,path);
        //ve.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        resp.setContentType("text/html;charset=UTF-8");
        //try {
            // 进行初始化操作
            ve.init();
            // 加载模板，设定模板编码
            org.apache.velocity.Template t = ve.getTemplate("/view/"+mv.getForwardPage()+".vm", "UTF-8");
            // 设置初始化数据
            VelocityContext vlcontext = new VelocityContext();
            /*
            context.put("name", "张三");

            String[] hobbyArray={"吃饭","喝水","洗澡"};
            context.put("hobby", "爱好");
            context.put("hobbyArray", hobbyArray);
            */
            if ( mv.getParams() != null) {
                Iterator entries = ((HashMap)mv.getParams()).entrySet().iterator();
                while (entries.hasNext()) {
                    Map.Entry entry = (Map.Entry) entries.next();
                    String key = (String) entry.getKey();
                    Object val = entry.getValue();
                    vlcontext.put(key,val);
                    //dataModel.put(key,val);
                }
            }

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String str=sdf.format(date);
            //生成属性
            vlcontext.put("LastUpdated", str);

            // 设置输出
            StringWriter writer = new StringWriter();
            // 将环境数据转化输出
            t.merge(vlcontext, writer);
            PrintWriter pw=resp.getWriter();
            pw.println(writer.toString());
            pw.flush();
            pw.close();
            //return writer.toString();

        //} catch (Exception e) {
        //    throw new RuntimeException("模版转化错误!");
        //}
    }
}
