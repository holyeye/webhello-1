package myboard.controller;

import com.sun.corba.se.impl.logging.ORBUtilSystemException;
import myboard.entity.Board;
import myboard.repository.BoardDatabaseRepository;
import myboard.repository.BoardMemoryRepository;
import myboard.repository.BoardRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * User: HolyEyE
 * Date: 13. 2. 22. Time: 오후 4:37
 */
public class BoardDelServlet extends HttpServlet{

    BoardRepository boardRepository = BoardDatabaseRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tmpid = request.getParameter("id");

        //System.out.println("DEL : tmpid = " + tmpid);
        boardRepository.delBoard(Integer.parseInt(tmpid));


        //3. jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/board/boardDel.jsp");
        view.forward(request, response);
    }
}
