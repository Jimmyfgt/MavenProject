
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript">
    function showImg(thisimg) {
       document.getElementById("img_old").style.display="none";
       var file = thisimg.files[0];
       if(window.FileReader) {
          var fr = new FileReader();
          var showimg = document.getElementById('showimg');
          fr.onloadend = function(e) {
          showimg.src = e.target.result;
       };
       fr.readAsDataURL(file);
       showimg.style.display = 'block';
       }
    }
    </script>
    <title>修改商品</title>
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
<body vLink="#006666" link="#003366" bgColor="#E0F0F8" >
<h3 align="center">Produce Update List</h3>
<form action="${pageContext.request.contextPath}/toupdate" method="post" enctype="multipart/form-data">
      <input type="hidden" name="id" value="${product.id }" />
      <table width="50%" border="1"  align="center" cellpadding="0" cellspacing="0">
         <tr>
            <td>商品名称</td>
           <td><input type="text" name="productName" value="${product.productName }" required="required"/></td>
         </tr>
         <tr>
            <td>商品描述</td>
             <td><textarea rows="3" cols="30" name="productDecribe" required="required">${product.productDecribe }</textarea></td>
         </tr>
         <tr>
            <td>商品库存</td>
            <td><input type="text" name="productNum" placeholder="请输入整数"  onkeyup="this.value=this.value.replace(/\D/g,'')"
                value="${product.productNum }" /></td>
         </tr>
         <tr>
            <td>商品图片</td>
            <td><c:if test="${product.productImg!=null }">
                  <img id="img_old" src="/img/${product.productImg }" width="100" height="100" />
                </c:if>
                <img id="showimg" src="" style="display:none;" width="100" height="100"/>
               <input type="file" name="img"  multiple="true"  onchange="showImg(this)"/>
            </td>
         </tr>

      </table>
    <h1 align="center"><input type="submit" value="提交" align="center"/></h1>
   </form>
</body>
</html>