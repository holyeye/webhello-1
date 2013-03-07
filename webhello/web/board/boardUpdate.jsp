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
      Board tmpBoard = (Board)request.getAttribute("boards");
  %>

  <form name="updateformat" method="post" action="updatesave">
      <input type="hidden" name="id" value="<%= request.getAttribute("tmpid") %>">
   <table>
       <tr>
           <td>title</td>
           <td><input type="text" name="title" value="<% out.write(tmpBoard.getTitle()); %>"></td>
       </tr>
       <tr>
           <td>writer</td>
           <td><input type="text" name="writer" value="<% out.write(tmpBoard.getWriter()); %>"></td>
       </tr>
       <tr>
           <td>pw</td>
           <td><input type="text" name="pw" value="<% out.write(tmpBoard.getPw()); %>"></td>
       </tr>
       <tr>
           <td>content</td>
           <td><textarea rows="5" name="content" ><% out.write(tmpBoard.getContent()); %></textarea></td>
       </tr>
   </table>
  </form>

  <input type="button" value="목록" onclick="goListForm()" />
  <input type="button" value="저장" onclick="goSaveForm()" />

  </body>
</html>

<script language="javascript">
    function goListForm() {
        location.href = "list";
    }
    function goSaveForm() {
        document.updateformat.submit();
    }
</script>
