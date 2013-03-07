<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>


  <form name="insertformat" method="post" action="save">
   <table>
       <tr>
           <td>title</td>
           <td><input type="text" name="title"></td>
       </tr>
       <tr>
           <td>writer</td>
           <td><input type="text" name="writer"></td>
       </tr>
       <tr>
           <td>pw</td>
           <td><input type="text" name="pw"></td>
       </tr>
       <tr>
           <td>content</td>
           <td><textarea rows="5" name="content"></textarea></td>
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
        document.insertformat.submit();
    }
    function goUpdateForm() {
        location.href = "update";
    }
</script>