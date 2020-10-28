<%@ page language="java" contentType="text/html; charset=UTF-8" isErrorPage="true"
         pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>error</title>
    <script type="text/javascript">

        window.open("任意写", "newwindow", "height=100, width=400, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
    </SCRIPT>
</head>
<body>
<%
    Object message = request.getAttribute("mess age");
    if (message != null && !"".equals(message)) {
        exception.printStackTrace();

%>
<script type="text/javascript">
    exception.printStackTrace();
    alert("<%=request.getAttribute("message")%>");
    window.location = "list";//提示完直接跳到list页面，这里list是一个servlet类，我用了映射，不映射则要写这个类名的绝对路径
</script>
<%} %>

</body>

</html>