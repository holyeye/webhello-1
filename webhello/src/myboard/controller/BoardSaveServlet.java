package myboard.controller;

import myboard.entity.Board;
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
public class BoardSaveServlet extends HttpServlet{

    BoardRepository boardRepository = BoardMemoryRepository.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String writer = request.getParameter("writer");
        String content = request.getParameter("content");
        String pw = request.getParameter("pw");


        //1. model에서 데이터 저장
        //boardRepository.addBoard(new Board(title,writer,pw,content));
        Board board = new Board();
        board.setTitle(title);
        board.setWriter(writer);
        board.setContent(content);
        board.setPw(pw);
        boardRepository.addBoard(board);
        //boards.add(new Board( title,writer,pw,content));

        //2. jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/board/boardSave.jsp");
        view.forward(request, response);
    }
}
