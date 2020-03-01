<?php
header("content-Type: text/html; charset=Utf-8");
include_once("functions/is_login.php");

if(!session_id()){
	session_start();
}
if(!is_login())
{
	echo "请您登陆后,在访问该页面";
	return;
}
if(!is_admin()){
    echo "请管理员登录,管理分类 ";
    return;
}

?>

<form class="form-inline" method="post" enctype="multipart/form-data" action="category_save.php" >
    <div class="form-group">
        <label>分类:</label>
        <input type="text" name="category" required class="form-control" placeholder="请输入分类">
    </div>
    <input type="submit" class="btn btn-primary" name="" value="添加">
    <input type="reset" class="btn btn-default"  value="重置" name="">
</form>
