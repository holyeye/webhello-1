<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
   <table>
       <tr>
           <td colspan="3">
               현재 방문자 수 : ${nowUserCnt}

           </td>
       </tr>
       <tr>
           <td>title</td>
           <td>writer</td>
           <td>pw</td>
       </tr>

       <c:forEach var="board" items="${boards}">
           <tr>
               <td><a href="detail?id=${board.id}">${board.title}</a></td>
               <td>${board.writer}</td>
               <td>${board.pw}</td>
           </tr>
       </c:forEach>
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