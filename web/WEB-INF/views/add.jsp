<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function showImg(thisimg) {
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
<title>添加商品</title>
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
<body  vLink="#006666" link="#003366" bgColor="#E0F0F8" >
   <form  action="${pageContext.request.contextPath}/toadd"
      method="post" enctype="multipart/form-data" >
      <h3 align="center">add Products Information</h3>
      <table width="50%" border="1" align="center" cellpadding="0" cellspacing="0">
         <tr>
            <td>商品名称</td>
            <td><input type="text" name="productName" required="required" /></td>
         </tr>
         <tr>
            <td>商品描述</td>
            <td><textarea rows="3" cols="30" name="productDecribe" ></textarea></td>
         </tr>
         <tr>
            <td>商品库存</td>
            <td><input type="text" name="productNum" placeholder="请输入整数" onkeyup="this.value=this.value.replace(/\D/g,'')" /></td>
         </tr>
         <tr>
            <td>商品图片</td>
            <td><img id="showimg" src="" style="display:none;" width="100" height="100"/>
               <input type="file" name="img"  onchange="showImg(this)"/>
                </td>
         </tr>
      </table>
     <h1 align="center"> <input  type="submit" value="提交"> <input type="reset"
                                                                       value="重置"> </h1>
   </form>
</body>
</html>