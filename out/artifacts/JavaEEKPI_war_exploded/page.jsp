<%--
  Created by IntelliJ IDEA.
  User: aliubivyi
  Date: 17.04.17
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <caption>TABLE OF WORDS</caption>

        <th>ID</th>
        <th>WORD</th>
        <th>MEANING</th>


<c:forEach var="item" items="${sessionScope.list}" varStatus="myIndex">
    <tr>
        <td>${item.idMeaning}</td>
        <td>${item.word}</td>
        <td>${item.meaning}</td>
    </tr>
</c:forEach>
</table>




<form action="/do-something" method="post" class="inlineBlock">
    <input type="hidden" name="command" value="updateOrCreate"><br>
    WORD:    <input type="text" name="WORD" ><br>
    MEANING: <input type="text" name="MEANING" ><br>
    <button type="" class="">
        ADD_OR_CHANGE
    </button>
</form>

<br>
<br>
<br>
<form action="/do-something" method="post" class="inlineBlock">
    <input type="hidden" name="command" value="deleteWord"><br>
    WORD :   <input type="text" name="WORD" ><br>
    <button type="" class="">
        DELETE_WORD
    </button>
</form>

<%--${sessionScope}<br><br>--%>

</body>
</html>
