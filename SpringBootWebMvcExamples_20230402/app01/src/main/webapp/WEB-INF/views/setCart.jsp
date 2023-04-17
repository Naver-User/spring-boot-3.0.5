<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>

<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>setCart</title>
</head>
<body>
    
    <h1>/WEB-INF/jsp/setCart.jsp</h1>

    <hr>

	1. Cart in the session scope: ${sessionScope['scopedTarget.createCartBean']} <br>
	2. Cart in the request scope: ${requestScope['scopedTarget.createCartBean']} <br>
	3. Cart in the application scope: ${applicationScope['scopedTarget.createCartBean']}

</body>
</html>