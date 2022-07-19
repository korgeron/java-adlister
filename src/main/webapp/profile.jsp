<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome ${loggedIn}</h1>

        <form action="/profile" method="POST">
            <button type="submit" name="logout">LOGOUT!</button>
        </form>
    </div>

</body>
</html>
