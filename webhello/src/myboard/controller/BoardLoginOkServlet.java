package myboard.controller;

import myboard.entity.Board;
import myboard.repository.BoardDatabaseRepository;
import myboard.repository.BoardMemoryRepository;
import myboard.repository.BoardRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

/**
 * User: HolyEyE
 * Date: 13. 2. 22. Time: 오후 4:37
 */
public class BoardLoginOkServlet extends HttpServlet{

    BoardRepository boardRepository = BoardDatabaseRepository.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        String isSave = request.getParameter("isSave");

        System.out.println("userid : "+userId+" userPw : " + userPw + " isSave : " + isSave);

        if (isSave != null) {
            System.out.println("isSave OK");
            Cookie cookie = new Cookie("userId", userId);
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
        } else {
            System.out.println("isSave OFF");
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userId") == true) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }

        if ( userId.equals((String)"test") == true && userPw.equals((String)"1234") == true ) {
            HttpSession session = request.getSession();
            session.setAttribute("isLogin",true);

            ServletContext context = getServletContext();

            int nuc;
            if (context.getAttribute("nowUserCnt") == null) {
                System.out.println("null");
                nuc = 0;
                context.setAttribute("nowUserCnt", nuc);
            } else {
                nuc = (Integer)context.getAttribute("nowUserCnt");
                context.setAttribute("nowUserCnt", ++nuc);
            }

            response.sendRedirect("/board/list");
            return;
        }


        //2. jsp찾아서 이동
        response.sendRedirect("/board/login");
        return;
    }
}
