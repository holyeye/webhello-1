package myboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created with IntelliJ IDEA.
 * User: skplanet
 * Date: 13. 3. 15.
 * Time: 오전 11:12
 * To change this template use File | Settings | File Templates.
 */
public class BoardWrapperReq extends HttpServletRequestWrapper {

    public BoardWrapperReq(HttpServletRequest httpReq) {
        super(httpReq);
    }

    @Override
    public void setAttribute(String str, Object obj) {
        System.out.println("str : "+str+", obj : "+obj.toString());
        super.setAttribute(str, obj);
    }

    @Override
    public Object getAttribute(String str) {
        System.out.println("getAttribute str :" + str);
        return super.getAttribute(str);
    }

}
