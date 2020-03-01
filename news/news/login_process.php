<?php

session_start();
include_once("functions/database.php");

$name = $_POST["name"];
$password = md5($_POST["password"]);

if($_POST["checknum"] != $_SESSION["checknum"]){
	header("Location:index.php?login_message=checknum_error");
	return;
}

// if(isset($_COOKIE["password"])){
// 	$first_password = $_COOKIE["password"];
// }else{
// 	$first_password = md5($_POST["password"]);
// }

if(empty($_POST["expire"])){
	setcookie("name", $name, time()-1);
	setcookie("password", $password, time()-1);
}


$sql = "select * from users where name='$name' and password = '$password'";

get_connection();

$result_set = mysql_query($sql);

if(mysql_num_rows($result_set) > 0){
	if(isset($_POST["expire"])){
		$expire = time() + intval($_POST["expire"]);
		setcookie("name", $name, $expire);
		setcookie("password", $password, $expire);
	}
	$admin = mysql_fetch_array($result_set);
	$_SESSION['user_id'] = $admin['user_id'];
	$_SESSION['name'] = $admin['name'];
	header("Location:index.php?login_message=password_right");
}else{
	header("Location:index.php?login_message=password_error");
}
close_connection();


?>
