<?php
header('Content-type:text/html;charset=utf-8');
include_once("functions/database.php");

$sql = "select * from review order by review_id desc";

get_connection();

$result_set = mysql_query($sql);

close_connection();

echo "系统所有评论信息如下:<br/>";

while($row = mysql_fetch_array($result_set)){
	echo "评论内容:".$row["content"]."<br/>";
	echo "日期:".$row["publish_time"]."&nbsp;&nbsp;";
	echo "IP地址:".$row["ip"]."&nbsp;&nbsp;";
	echo "状态:".$row["state"]."<br/>";
	echo "&nbsp;&nbsp;&nbsp;";
	if($row["state"] == "未审核"){
		echo "<a href = 'review_verify.php?review_id=".$row["review_id"]."'>审核</a>";
	}
	echo "<hr/>";
}

?>