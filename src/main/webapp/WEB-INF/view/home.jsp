<%-- 
    Document   : home
    Created on : 26 Δεκ 2019, 11:26:29 μμ
    Author     : poime
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Hello!</h2><br/>
        <c:if test="${message != null}">
            <p>
                ${message}
            </p>
        </c:if>
        <a href="${pageContext.request.contextPath}/newClient">Create Client</a><br/><br/>
        <a href="${pageContext.request.contextPath}/newEmployee">Create Employee</a><br/><br/>
        <a href="${pageContext.request.contextPath}/newAdmin">Create Admin</a><br/><br/>
    </body>
</html>
