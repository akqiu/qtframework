package qt.mvc.action;

import qt.mvc.entity.ModelAndView;
import qt.mvc.entity.PageInfo;
import freemarker.template.TemplateException;
//import freemarker.template.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by qiutian on 16-9-8.
 */
public interface ActionManager {

    ModelAndView doProccessMethod(PageInfo info);

    void doResult(ModelAndView mv, HttpServletRequest req, HttpServletResponse resp, ServletContext context) throws ServletException, IOException, TemplateException;
}
