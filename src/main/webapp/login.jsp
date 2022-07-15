<%@ page import="java.util.Arrays" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kjorgeron0819
  Date: 7/13/22
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--TODO: CONDITION TO CHECK IF USERNAME = ADMIN AND PASSWORD = PASSWORD--%>
<% if(request.getParameter("user") != null && request.getParameter("pass") != null) {
    if (request.getParameter("user").equalsIgnoreCase("admin") && request.getParameter("pass").equalsIgnoreCase("password")) {
        response.sendRedirect("profile.jsp");
    } else {
        response.sendRedirect("login.jsp");
    }
}%>

<html>
<head>
    <title>Login Form</title>
    <%@ include file="partials/head.jsp"%>
</head>
<body>
<%--TODO: THIS INCLUDES THE NAV FILE FROM PARTIALS DIRECTORY--%>
<%@ include file="partials/nav.jsp" %>

<%--TODO: CREATING FORM FOR USERNAME / PASSWORD--%>
<form action="login.jsp" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="user"/>
    <label for="password">Password:</label>
    <input type="password" id="password" name="pass"/>
    <button type="submit">Submit</button>
</form>

<%--TODO:(test/learning) LOOKING AT USING C:--%>
<%--<% request.setAttribute("numbers" ,new int[] {1, 2, 3, 4, 5});%>--%>
<%--<c:forEach var="num" items="${numbers}">--%>
<%--<c:if test="${param.user == null}">--%>
<%--    <c:if test="${num <= 3}">--%>
<%--        <div>${num}</div>--%>
<%--    </c:if>--%>

<%--    <c:if test="${num > 3}">--%>
<%--        <div> ${num * 10} </div>--%>
<%--    </c:if>--%>
<%-- </c:if>--%>
<%--</c:forEach>--%>

</body>
</html>
