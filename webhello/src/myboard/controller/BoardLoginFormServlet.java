package myboard.controller;

import myboard.repository.BoardDatabaseRepository;
import myboard.repository.BoardMemoryRepository;
import myboard.repository.BoardRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: HolyEyE
 * Date: 13. 2. 22. Time: 오후 4:37
 */
public class BoardLoginFormServlet extends HttpServlet{

    BoardRepository boardRepository = BoardDatabaseRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tmpid = "";
        String ischk = "";

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId") == true) {
                tmpid = cookie.getValue();
                ischk = ischk.concat("checked");
                System.out.println("ischk : " + ischk);
            }
        }

        request.setAttribute("id", tmpid);
        request.setAttribute("ischk", ischk);


        //1. jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/board/boardLogin.jsp");
        view.forward(request, response);
    }
}
