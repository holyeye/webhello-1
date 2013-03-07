package hello;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;

/**
 * User: HolyEyE
 * Date: 13. 2. 22. Time: 오후 4:37
 */
public class HelloServlet extends HttpServlet{


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        Date date = new Date();
        String name = request.getParameter("name");

        //1000만줄

        String result = date.toString() + name;

        ResultModel model = new ResultModel();
        int calculate = model.calculate(100, 200);

        request.setAttribute("result", result);
        request.setAttribute("calculate", calculate);

        RequestDispatcher view = request.getRequestDispatcher("boardList.jsp");
        view.forward(request, response);

    }
}
