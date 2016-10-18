
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("GBK");
    String json = (String) request.getAttribute("json");
%>
<%=json%>

