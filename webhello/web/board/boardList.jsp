<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
   <%
       //out.write(session.getAttribute("isLogin"));
       if (session.getAttribute("isLogin") == null) {
           response.sendRedirect("/board/login");
       }
   %>

   <table>
       <tr>
           <td colspan="3">
               <%
                   int nuc = (Integer)request.getAttribute("nowUserCnt");
                   out.write("현재 방문자 수 : "+nuc);
               %>
           </td>
       </tr>
       <tr>
           <td>title</td>
           <td>writer</td>
           <td>pw</td>
       </tr>
  <%

      List<Board> boards = (List<Board>) request.getAttribute("boards");

      for (Board board : boards) {
           out.write("<tr>\n");
           out.write("<td><a href=\"detail?id="+board.getId()+"\">"+board.getTitle()+"</a></td>\n");
           out.write("<td>"+board.getWriter()+"</td>\n");
           out.write("<td>"+board.getPw()+"</td>\n");
           out.write("<tr>\n");
      }


  %>
   </table>

   <input type="button" value="등록" onclick="goSaveForm()" />
   <input type="button" value="로그아웃" onclick="goLogoutForm()" />
  </body>
</html>

<script language="javascript">
    function goSaveForm() {
        location.href = "insert";
    }
    function goLogoutForm() {
        location.href = "logout";
    }
</script>