<?php

include_once("functions/database.php");
include_once("functions/is_login.php");
if(!session_id()){
	session_start();
}

$news_id = $_GET["news_id"];

get_connection();

mysql_query("delete from review where news_id=$news_id");

mysql_query("delete from news where news_id=$news_id");

close_connection();

$message = "新闻及相关评论信息删除成功！";

header("Location:index.php?url=news_list.php&message=$message");

?>