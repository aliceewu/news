
<?php
header('Content-type:text/html;charset=utf-8');
include_once("functions/database.php");
$news_id = $_GET["news_id"];
$sql = "select * from review where news_id=$news_id and state='已审核' order by review_id desc";

get_connection();

$result_set = mysql_query($sql);

close_connection();

echo "<div class='page-header'> <h4>评论如下：</h4> </div>";

while($row = mysql_fetch_array($result_set))
{
	echo "评论内容:".$row["content"]."<br/>";
	echo "评论日期:".$row["publish_time"]."<br/>";
	/*删除显示IP地址*/
	echo "评论IP地址:".$row["ip"]."<hr/>";
}

?>
