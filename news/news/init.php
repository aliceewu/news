<?php

include_once("functions/database.php");

get_connection();

//添加新闻类别

$mysql = mysql_query("insert into category values(null, '娱乐')");


mysql_query("insert into category values(null, '财经')");

$password = md5(md5("admin"));

mysql_query("insert into users values(null, 'admin', '$password')");

close_connection();

echo "成功添加初始化数据";

?>