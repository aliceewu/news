<?php
header("content-Type: text/html; charset=Utf-8");
include_once("functions/database.php");
$category = $_POST["category"];
if(!empty($category)){
	$sql = "insert into category values(null,'$category')";
	get_connection();
	mysql_query($sql);
	close_connection();
	header("Location:index.php?url=category_list.php");
}else{
	echo "插入的数据不能为空，请重新输入";
}
?>