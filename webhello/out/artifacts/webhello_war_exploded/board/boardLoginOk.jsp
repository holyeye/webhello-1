<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <%
          //HttpSession session = request.getSession();

          if (session.getAttribute("isLogin") == null) {
              response.sendRedirect("/board/login");
          } else {
              response.sendRedirect("/board/list");
          }
      %>
    <title></title>
  </head>
  <body>

  </body>
</html>