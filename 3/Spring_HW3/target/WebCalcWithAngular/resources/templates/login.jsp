<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<c:url value="/login/process" var="logIn" />
<form action="${logIn}" method="post">
    <c:if test="${param.error}" >
        <h2>Invalid email or password</h2>
    </c:if>
    <label for="loginEmail">Email: </label>
        <input id="loginEmail" type="text" class="form-control" placeholder="type your email" name="email">
    <label for="loginPassword">Password: </label>
        <input id="loginPassword" type="password" class="form-control" placeholder="****, hehe" name="password">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
</form>

<h2>Isn't registered yet? Here U go:</h2>
<c:url value="/registration" var="register" />
<form action="${register}">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button class="btn btn-sm btn-danger btn-block" type="submit">Register</button>
</form>