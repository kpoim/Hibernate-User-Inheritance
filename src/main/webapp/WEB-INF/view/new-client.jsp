<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Create new Client</h3>
        <form:form method="post" action='${pageContext.request.contextPath}/newClient' modelAttribute="client">
            username: <form:input path="username"/><br/>
            password: <form:password path="password"/><br/>
            client id: <form:input path="clientId" type="number"/><br/>
            <input type="submit" value='submit'/>
        </form:form>
    </body>
</html>
