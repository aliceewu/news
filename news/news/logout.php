<?php

session_start();
session_unset();

if(isset($_COOKIE[session_name()])){
	setcookie(session_name(), session_id(), time() - 10);
}
session_destroy();
header("Location:index.php");

?>