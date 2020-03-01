<?php

$database_connection = null;

function get_connection(){
	$hostname = "10.18.57.16";
	$database = "H_ZB1018144";
	$username = "H_ZB1018144";
	$password = "961125";
	global $database_connection;
	$database_connection = @mysql_connect($hostname, $username, $password) or die(mysql_error());
	mysql_query("set names 'utf8'");
	mysql_select_db($database, $database_connection) or die(mysql_error());

	
	}
	function close_connection(){
		global $database_connection;
		if($database_connection){
			mysql_close($database_connection) or die(mysql_error());
		}
}

?>