<?php
header("content-Type: text/html; charset=Utf-8");
include_once("functions/file_system.php");
include_once("functions/is_login.php");
if(!session_id()){
	session_start();
}
if(!is_login()){
	echo "请您登录系统后,再访问该页面!";
	return;
}
if(empty($_POST)){
	// 上传的文件超过了php.ini中post_max_size选项限制的值
	$message = "没有上传文件";
}else{
	$user_id = $_SESSION["user_id"];
	$category_id = $_POST["category_id"];
	$title = $_POST["title"];
	$content = htmlspecialchars(addslashes($_POST["content"]));
	$currentDate = date("Y-m-d H:i:s");
	$clicked = 0;
	$file_name = $_FILES['news_file']['name'];
	echo $file_name;

	$message = upload($_FILES['news_file'],"uploads");
	$sql = "insert into news values(null, $user_id, $category_id, '$title', '$content', '$currentDate', $clicked, '$file_name')";
	echo $message;
	if($message == "文件上传成功!" || $message == "没有选择上传附件!")
	{
		include_once("functions/database.php");
		get_connection();
		mysql_query($sql);
		close_connection();
	}
}
$message = urlencode($message);
header("Location:index.php?url=news_list.php&message=$message");

?>