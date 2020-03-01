<?php
header("content-Type: text/html; charset=Utf-8");
include_once("functions/database.php");
include_once("functions/page.php");
include_once("functions/is_login.php");
if(!session_id()){
	session_start();
}
if(!is_admin()){
	echo "请管理员登录,管理评论";
	return;
}
$sql = "select * from review";

get_connection();

$result_news = mysql_query($sql);

$total_records = mysql_num_rows($result_news);

$page_size = 3;

if(isset($_GET["page_current"])){
	$page_current = $_GET["page_current"];
}else{
	$page_current = 1;
}

$start = ($page_current - 1) * $page_size;

$result_sql = "select * from review order by review_id desc limit $start, $page_size";

$result_set = mysql_query($result_sql);

close_connection();

echo "<table class='table table-bordered' style='margin: 10px 0;'> <thead> <tr> <th>评论内容</th> <th>日期</th> <th>ip地址</th> <th>状态</th> <th>操作</th> <th>操作</th> </tr> </thead><tbody>";

while($row = mysql_fetch_array($result_set)){
	echo "<tr><td>".$row["content"]."</td>";
	echo "<td>".$row["publish_time"]."</td>";
	echo "<td>".$row["ip"]."</td>";
	echo "<td>".$row["state"]."</td>";
	if (is_admin()) {
		echo "<td><a href = 'review_delete.php?review_id=".$row["review_id"]."'>删除</a></td>";
	} else {
		echo "<td>/</td>";
	}

	if($row["state"] == "未审核" && is_admin()){
		echo "<td><a href = 'review_verify.php?review_id=".$row["review_id"]."'>审核</a></td>";
	} else {
		echo "<td>/</td>";
	}
	echo "</tr>";
}
echo "</tbody></table>";

$url = "index.php?url=review_list.php";
page($total_records, $page_size, $page_current, $url, "");

?>
