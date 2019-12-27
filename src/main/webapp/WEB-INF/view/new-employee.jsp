<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Create new Employee</h3>
        <form:form method='post' action='${pageContext.request.contextPath}/newEmployee' modelAttribute="employee">
            username: <form:input path="username"/><br/>
            password: <form:password path="password"/><br/>
            first name: <form:input path="firstName" /><br/>
            last name: <form:input path="lastName" /><br/>
            phone number: <form:input path="phone" /><br/>
            <input type="submit" value='submit'/>
        </form:form>
    </body>
</html>
