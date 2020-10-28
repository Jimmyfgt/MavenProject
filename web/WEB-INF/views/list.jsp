<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示产品</title>
    <style type="text/css">
        #rig {
            width: 100px;
            height: 100px;
            /* background: red ; */
            position: absolute;
            top: 10px;
            right: 1px;
        }
    </style>
    <div id="rig">
        <a href="/list">返回主界面</a>
    </div>
</head>
<body vLink="#006666" link="#003366" bgColor="#E0F0F8" style="text-align:center;">
<h3 align="center">Produce List Show</h3>
<h3 align="center"><a href="add">新增商品</a></h3>
<form action="${pageContext.request.contextPath }/find" method="post" align="center">
    <input type="text" name="productName" placeholder="商品名称">

        <input type="submit" value="模糊查询">

</form>
<table border="1" width="50%" align="center" cellspacing="0">
    <caption >商品信息表</caption>
    <tr align="center">
        <td>商品名称</td>
        <td>商品描述</td>
        <td>商品库存</td>
        <td>商品图片</td>
        <td>用户操作</td>
    </tr>
    <c:forEach items="${pageInfo.list }" var="product">
        <tr>
            <td>${product.productName }</td>
            <td>${product.productDecribe }</td>
            <td>${product.productNum }</td >
            <td align="center"><img alt="图片加载失败" src="/img/${product.productImg}" width="100px" height="100px"/></td>
            <td>
                <a href="${pageContext.request.contextPath }/update?id=${product.id }">修改</a>
                <a href="${pageContext.request.contextPath }/delete?id=${product.id }"
                   onclick="return(confirm('確定刪除${product.productName}所有数据?'))">删除</a>
            </td>

        </tr>

    </c:forEach>

</table>

<table border="0" align="center">
    <tr>
        <div>
            共${pageInfo.total}条数据 第${pageInfo.pageNum}页 共${pageInfo.pages}页
            <a
                    <c:if test="${pageInfo.pageNum > 1 }">
                         href="list?pages=1"
                    </c:if>>首页</a>
            <a
                    <c:if test="${pageInfo.pageNum>1 }">
                        href="list?page=${pageInfo.pageNum - 1 }"
                    </c:if>>上一页</a>
            <a
                    <c:if test="${pageInfo.pageNum != pageInfo.pages }">
                        href="list?page=${pageInfo.pageNum + 1 }"
                    </c:if>>下一页</a>
            <a
                    <c:if test="${pageInfo.pageNum < pageInfo.pages }">
                        href="list?page=${pageInfo.pages }"
                     </c:if>>尾页</a>
            <form name="f1" method="POST" action="list">
                转到第:<input type="text" name="page" size="8">页<input
                    type="submit" value="GO" name="${pageInfo.pageNum}">
            </form>
        </div>
    </tr>
</table>
</body>
</html>
