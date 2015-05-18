<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<meta charset="UTF-8" />
	<title>Home</title>
</head>
<body>
<h1>
	<spring:message code="title" />
</h1>

<P>  <spring:message code="description" arguments="${serverTime}" /> </P>
</body>
</html>
