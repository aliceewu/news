<?php

include_once("functions/database.php");
include_once("functions/is_login.php");
if(!session_id()){
	session_start();
}
$category_id = $_GET["category_id"];

get_connection();

mysql_query("delete from review where news_id in (select news_id from news where category_id=$category_id)");

mysql_query("delete from news where category_id=$category_id");

mysql_query("delete from category where category_id=$category_id");
close_connection();

$message = "分类及相关信息删除成功！";

header("Location:index.php?url=category_list.php&message=$message");

?>