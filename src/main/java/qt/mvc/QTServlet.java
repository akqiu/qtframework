package qt.mvc;


import qt.mvc.action.ActionManager;

import qt.mvc.common.BeanFactory;
import qt.mvc.entity.ModelAndView;
import qt.mvc.entity.PageInfo;
import qt.mvc.resolver.ResourcesResolver;
import qt.mvc.translator.HttpParamsTranslator;
import qt.mvc.resolver.PageInfoResolver;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.apache.log4j.Logger;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Created by qiutian on 16-8-30.
 */
public class QTServlet extends HttpServlet{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final static Logger logger = Logger.getLogger(QTServlet.class);

    private HttpParamsTranslator httpParamsTranslator = null;

    private  ActionManager classManager ;

    private ResourcesResolver resourcesResolver;

    private Configuration cfg = null;

    //调用父类的构造方法
    public QTServlet(){
        super();
    }

    //重写父类的doGet()方法
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        if (!PageInfoResolver.isResourcePage(req)){
            //System.out.println("RequestURI="+req.getRequestURI());
            PageInfo info = PageInfoResolver.doProcess(req);
            ModelAndView result = classManager.doProccessMethod(info);
            try {
                classManager.doResult(result,req,resp,this.getServletContext());
            } catch (TemplateException e) {
                e.printStackTrace();
            }

        }
        else{
            try {
                resourcesResolver.doOutputResource(req, resp);
            }
            catch (IOException e){
                //logger.error(e);
                resp.setStatus(404);

                //req.getRequestDispatcher("/"+ ConstantClass.CanNotFoundPage).forward(req, resp);
            }
        }
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req,resp);

    }

    @Override
    public void init() throws ServletException {


        httpParamsTranslator = (HttpParamsTranslator)BeanFactory.Create("httpParamsTranslator");

        classManager = (ActionManager)BeanFactory.Create("classManager");

        resourcesResolver =(ResourcesResolver)BeanFactory.Create("resourcesResolver");
    }
}
