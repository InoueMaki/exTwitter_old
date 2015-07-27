<%@page contentType="text/html; charset=UTF-8" %>

<html>
<link rel="stylesheet" type="text/css" href="style.css">

<head>
<title>テスト</title>
</head>
<body>

<jsp:include page="header.jsp" />
<div id="a">

<div id="label">Twitter</div>

<form action="test">
	<center>
		つぶやき入力してね<br><br>
		<textarea cols="40" rows="6" name="val1" style="resize:none" maxlength="140"></textarea>
		<!-- 
			<input type="text"style="width:300px;height:150px;" size="7" name="val1" maxlength="140"><br><br>
		-->
		<input type="submit" value="ツイート">
	</center>
</form>
</div>
</body>
</html>