<?php
@session_start();
include_once("functions/is_login.php");

if(isset($_GET["login_message"])){
	if($_GET["login_message"] == "checknum_error"){
		echo "验证码错误，重新登录!<br/>";
	}
	else if($_GET["login_message"] == "password_error"){
		echo "密码错误，重新登录!<br/>";
	}else if($_GET["login_message"] == "password_right"){
		echo "登录成功! ";
	}
}

if(is_login()){
	echo "欢迎".$_SESSION['name']."访问系统! ";
	echo "<a href='logout.php'> 注销 </a>";
	return;
}

$name = "";
if(isset($_COOKIE["name"])){
	$name = $_COOKIE["name"];
}

$password = "";

if(isset($_COOKIE["password"])){
	$password = $_COOKIE["password"];
}

?>
<form action = "login_process.php" method="post">
	<div class="form-group">
		<label for="exampleInputName2">用户名：</label>
		<input type="text" name="name" class="form-control" placeholder="请输入用户名">
	</div>
	<div class="form-group">
		<label for="exampleInputEmail2">密码：</label>
		<input type="password" name="password" class="form-control" placeholder="请输入密码">
	</div>
	<div class="form-group">
		<label for="exampleInputEmail2">验证码：</label>
		<input type="text" name="checknum" class="form-control" placeholder="请输入验证码">
	</div>
	<?php
		$checknum = "";
		$checknum .= mt_rand(0, 9);
		$checknum .= mt_rand(0, 9);
		$checknum .= mt_rand(0, 9);
		$checknum .= mt_rand(0, 9);
		$_SESSION['checknum'] = $checknum;
		echo $checknum;
	?>
	<input type="checkbox" name="expire" value="3600" checked/>Cookie保存一个小时
	<br/>
	<br/>
	<p align="center"><input type="submit" class="btn btn-default" value="登录"/><p>
</form>
