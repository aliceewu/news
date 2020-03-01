<?php

include_once("functions/file_system.php");

$file_name = $_GET["attachment"];

download("uploads/", "$file_name");

?>