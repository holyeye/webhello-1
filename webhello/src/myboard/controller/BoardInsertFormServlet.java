package myboard.controller;

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

/**
 * User: HolyEyE
 * Date: 13. 2. 22. Time: 오후 4:37
 */
public class BoardInsertFormServlet extends HttpServlet{

    BoardRepository boardRepository = BoardDatabaseRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/board/boardInsert.jsp");
        view.forward(request, response);
    }
}
