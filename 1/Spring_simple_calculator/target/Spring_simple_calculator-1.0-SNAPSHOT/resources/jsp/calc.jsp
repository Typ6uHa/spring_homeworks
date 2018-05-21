<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="calculate" method="post">
    <input type="text" name="number"/>
    <input type="submit" name="mathaction" value="+">
    <input type="submit" name="mathaction" value="-">
    <input type="submit" name="mathaction" value="/">
    <input type="submit" name="mathaction" value="*">
    <input type="submit" name="mathaction" value="=">
<form>
<br>
${history}



</body>
</html>