<?php

function is_login(){
	if(isset($_SESSION["user_id"])){
		return TRUE;
	}else{
		return FALSE;
	}
}

function is_admin(){
	if(isset($_SESSION['name'])){
		if($_SESSION['name']=="admin"){
			return TRUE;
		}else{
			return FALSE;
		}
	}else{
		return FALSE;
	}		
}
?>

