package qt.mvc.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by qiutian on 16-9-15.
 */
public class QTMVCFilter implements Filter{
    @Override
    public void destroy() {
        //System.out.println("EncodeFilter destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        /*
        String encodeCoding = params.get("EncodeCoding");
        request.setCharacterEncoding(encodeCoding);
        response.setCharacterEncoding(encodeCoding);
        chain.doFilter(request, response);
        System.out.println("EncodeFilter doFilter");
        */
    }

    @Override
    public void init(FilterConfig cfg) throws ServletException {

        //System.out.println("EncodeFilter init");
    }
}
