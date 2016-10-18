package qt.mvc.resolver;

import qt.mvc.constant.ConstantClass;
import qt.mvc.entity.PageInfo;
//import qt.mvc.properties.QTProperties;
import org.apache.log4j.Logger;
import qt.mvc.entity.ViewTypeEnum;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by qiutian on 16-9-2.
 */
public class PageInfoResolver {

    private static Logger logger = Logger.getLogger(PageInfoResolver.class);

    @SuppressWarnings("unchecked")
    public static PageInfo doProcess(HttpServletRequest req){
        //加路由规则
        //Router
        PageInfo info = new PageInfo();
        String uri = req.getRequestURI();
        String[] paths = uri.split("/");
        info.setContentType(PageInfoResolver.getMIMEContent(req)+";charset=UTF-8");
        info.setViewType(ViewTypeEnum.getEnum(ConstantClass.CONFIG.getViewType()));
        int len =paths.length;
        if (paths.length>2){
            info.setControllerName(paths[len-2]);
            info.setActionName(paths[len-1]);

                Map<String, String[]> params = req.getParameterMap();

            for (String key : params.keySet()) {
                String[] values = params.get(key);
                for (int i = 0; i < values.length; i++) {
                    String value = values[i];
                    info.getparams().put(key,value);
                    //System.out.println("post:["+key+"] = "+value);
                }
            }
        //test
        try{

            if (req.getContentType() != null && req.getContentType().equals("application/json; charset=UTF-8")) {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (ServletInputStream) req.getInputStream(), "utf-8"));
                StringBuffer sb = new StringBuffer("");
                String temp;
                while ((temp = br.readLine()) != null) {
                    sb.append(temp);
                }
                br.close();
                String acceptjson = sb.toString();
                info.getparams().put(ConstantClass.POST_JSON,acceptjson);
                //System.out.println("acceptjson: = " + acceptjson);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //response.getWriter().write(MyReadFile.read("/post/publishfailure"));
        }
        logger.info("ControllerName="+info.getControllerName()+"  ActionName="+info.getActionName()+"Params Size="+info.getparams().size());
        }
        //paths.
        //logger.info("uri="+uri);
        //logger.debug("uri="+uri);
        return info;
    }

    public static boolean isResourcePage(HttpServletRequest req) {
        //加路由规则
        //Router
        //PageInfo info = new PageInfo();
        boolean bl = false;
        String uri = req.getRequestURI();
        int indexof = uri.lastIndexOf(".");
        String path = uri.substring(0,uri.indexOf("/",1)+1);
        if (path.equals(ConstantClass.CONFIG.getResourcesViewPath()))
        {
            return true;
        }

        if (indexof>0) {
            String tag = uri.substring(indexof+1);

            String sourceStr = ConstantClass.CONFIG.getResourcesFilter();
            String[] sourceStrArray = sourceStr.split("\\|");
            for (String sourceTag : sourceStrArray) {
                if (tag.equals(sourceTag))
                    return true;
            }

            return bl;
        }
        return bl;
    }

    public static String getMIMEContent(HttpServletRequest req){
        String uri = req.getRequestURI();
        String contentType = "text/html";
        int indexof = uri.lastIndexOf(".");
        if (indexof>0) {
            String tag = uri.substring(indexof+1);

            if (ConstantClass.CONFIG.getContentType().containsKey(tag))
                contentType = ConstantClass.CONFIG.getContentType().get(tag);
        }
        return contentType;
    }

    public static boolean isTextType(HttpServletRequest req) {
        String uri = req.getRequestURI();
        int indexof = uri.lastIndexOf(".");
        if (indexof>0) {
            String tag = uri.substring(indexof+1);
            if (tag.equals("html")  || tag.equals("css") || tag.equals("xml") || tag.equals("js") || tag.equals("map"))
                return true;
        }
        return false;
    }
}
