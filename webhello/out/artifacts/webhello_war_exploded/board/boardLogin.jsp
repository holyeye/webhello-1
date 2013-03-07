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
      String id = (String)request.getAttribute("id");
      String chk = (String)request.getAttribute("ischk");
  %>

  <form name="Loginformat" method="post" action="loginok">
   <table>
       <tr>
           <td>ID</td>
           <td><input type="text" name="userId" value="<% out.write(id); %>"></td>
       </tr>
       <tr>
           <td>Password</td>
           <td><input type="password" name="userPw"></td>
       </tr>
       <tr>
           <td colspan="2"><input type="checkbox" name="isSave" <% out.write(chk);%> ></td>
       </tr>
   </table>
  </form>

  <input type="button" value="로그인" onclick="goLoginForm()" />
  </body>
</html>

<script language="javascript">

    function goLoginForm() {
        document.Loginformat.submit();
    }
</script>