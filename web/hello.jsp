<%--
  Created by IntelliJ IDEA.
  User: qiutian
  Date: 16-8-30
  Time: 上午2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("GBK");
    String info = (String) request.getAttribute("info");
    String name = (String) request.getAttribute("name");
    String date = (String) request.getAttribute("date");
%>
<%=info%>

<br/>
<%=name%>
<%=date%>
</body>
</html>
