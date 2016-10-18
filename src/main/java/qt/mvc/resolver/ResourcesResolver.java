package qt.mvc.resolver;

import qt.mvc.common.ServletGzipUtil;
import qt.mvc.constant.ConstantClass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by qiutian on 16-9-15.
 */
public class ResourcesResolver {

    public void doOutputResource(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //if (path.equals(ConstantClass.CONFIG.getResourcesViewPath()))


        long ldate = req.getDateHeader("If-Modified-Since");

        int indexof = req.getRequestURI()
                .indexOf(ConstantClass.CONFIG.getResourcesViewPath());
        String path= "";
        if (indexof>-1)
            path = req.getRequestURI().substring(indexof+ConstantClass.CONFIG.getResourcesViewPath().length());
        else
            path = req.getRequestURI();
        String absolutePath = req.getSession()
                .getServletContext()
                .getRealPath(ConstantClass.CONFIG.getResourcesSourcePath() + path);
        //默认走ResourcesPath
        File file =new File(absolutePath);
        if(!file.exists()){
            absolutePath = req.getSession()
                    .getServletContext()
                    .getRealPath(ConstantClass.CONFIG.getViewPath() + path);
            file = new File(absolutePath);

        }

        long modified = file.lastModified();
        //file.

        if (modified ==ldate)
        {
            resp.setStatus(304);
            return;
        }

        //logger.debug("Path:"+fileUrl);
        boolean isTextType = PageInfoResolver.isTextType(req);
        System.out.println("RequestURI:"+req.getRequestURI());
        System.out.println("Path:"+absolutePath +" TextType:"+isTextType);

        InputStream reader = null;
        OutputStream out = null;
        //resp.
        resp.addDateHeader("Last-Modified",modified);
        resp.setContentType(PageInfoResolver.getMIMEContent(req));
        if (isTextType)
            resp.setCharacterEncoding("UTF-8");
        //resp.setHeader();
        byte[] bytes = new byte[1024];
        int len = 0;
        try {
            // 读取文件
            reader = new FileInputStream(absolutePath);
            // 写入浏览器的输出流
            out = ServletGzipUtil.createGzipStream(req,resp); //resp.getOutputStream();

            while ((len = reader.read(bytes)) > 0) {
                out.write(bytes, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (out != null)
                out.close();
        }


    }
}
