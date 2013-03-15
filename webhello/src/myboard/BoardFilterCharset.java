package myboard;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: skplanet
 * Date: 13. 3. 15.
 * Time: 오전 10:51
 * To change this template use File | Settings | File Templates.
 */
public class BoardFilterCharset implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws  ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        httpReq.setCharacterEncoding("utf-8");

        chain.doFilter(req, resp);
    }

    public void destroy(){

    }
}
