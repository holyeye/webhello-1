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

   <table>
       <tr>
           <td>title</td>
           <td><% out.write(tmpBoard.getTitle()); %></td>
       </tr>
       <tr>
           <td>writer</td>
           <td><% out.write(tmpBoard.getWriter()); %></td>
       </tr>
       <tr>
           <td>pw</td>
           <td><% out.write(tmpBoard.getPw()); %></td>
       </tr>
       <tr>
           <td>content</td>
           <td><% out.write(tmpBoard.getContent()); %></td>
       </tr>
   </table>

  <input type="button" value="목록" onclick="goListForm()" />
  <input type="button" value="삭제" onclick="goDelForm(<%=tmpBoard.getId()%>)" />
  <input type="button" value="수정" onclick="goUpdateForm(<%=tmpBoard.getId()%>)" />
  </body>
</html>

<script language="javascript">
    function goListForm() {
        location.href = "list";
    }
    function goDelForm(key) {
        var nextpage = "del?id=" + key;
        location.href = nextpage;
    }
    function goUpdateForm(key) {
        var nextpage = "update?id=" + key;
        location.href = nextpage;
    }
</script>