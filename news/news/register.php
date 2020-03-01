<?php
header("content-Type: text/html; charset=Utf-8");
include_once("functions/database.php");

$username = $_POST["username"];
$password = md5($_POST["password"]);

$sql = "insert into users values(null,'$username','$password')";
get_connection();
mysql_query($sql);
close_connection();
header("Location:index.php");
