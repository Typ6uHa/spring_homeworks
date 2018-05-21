<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
<html>
<head>
    <title>Title</title>
</head>
<body>

<sf:form action="calculate" method="post" modelAttribute="operation">

    <sf:input path="digit"/>
    <sf:input path="mathAction" type="submit" value="+"/>
    <sf:input path="mathAction" type="submit" value="-"/>
    <sf:input path="mathAction" type="submit" value="/"/>
    <sf:input path="mathAction" type="submit" value="*"/>
    <sf:input path="mathAction" type="submit" value="="/>
    <br><sf:errors path="digit"/>

</sf:form>


${history}


</body>
</html>