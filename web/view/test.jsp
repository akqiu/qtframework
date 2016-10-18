
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("GBK");
    String name = (String) request.getAttribute("Name");
    String status = (String) request.getAttribute("Status");
    String date = (String) request.getAttribute("LastUpdated");
%>
人员:<%=name%>

<br/>
身份:<%=status%>
<br/>
<%=date%>
</body>
</html>
