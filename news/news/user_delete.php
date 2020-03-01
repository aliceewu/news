<?php

include_once("functions/database.php");
include_once("functions/is_login.php");
if(!session_id()){
    session_start();
}
$userId = $_GET["user_id"];

get_connection();

mysql_query("delete from users where user_id=$userId");
close_connection();

$message = "用户信息删除成功！";

header("Location:index.php?url=user_list.php&message=$message");

?>
