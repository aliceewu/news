<?php
header("content-Type: text/html; charset=Utf-8");
include_once("functions/database.php");

if(isset($_GET["message"])){
	echo $_GET["message"]."<br/>";
}

$search_sql = "select * from news order by news_id desc";

$keyword = "";

if(isset($_GET["keyword"])){
	$keyword = $_GET["keyword"];
	$search_sql = "select * from news where title like '%$keyword%' or content like '%$keyword%' order by news_id desc";
}

?>

<form action = "news_list.php" method="get">
	请输入关键字:
	<input type="text" name="keyword" value="<?php echo $keyword?>">
	<input type="submit" name="搜索">
</form>
<br/>
<table>
<?php

get_connection();

$page_size = 5;

if(isset($_GET["page_current"])){
	$page_current = $_GET["page_current"];
}else{
	$page_current = 1;
}

$start = ($page_current - 1) * $page_size;

$search_sql = "select * from news order by news_id desc limit $start, $page_size";

if(isset($_GET["keyword"])){
	$keyword = $_GET["keyword"];
	$search_sql = "select * from news where title like '%$keyword%' or content like '%$keyword%' order by news_id desc limit $start,$page_size";
}

$result_set = mysql_query($search_sql);

close_connection();

if(mysql_num_rows($result_set) == 0){
	exit("暂无记录!");
}

while($row = mysql_fetch_array($result_set)){
?>

<tr>
	<td>
		<a href = "news_detail.php?news_id=<?php echo $row['news_id']?>"><?php echo $row['title']?></a>
	</td>
	<td>
		<a href = "news_edit.php?news_id=<?php echo $row['news_id']?>">编辑</a>
	</td>
	<td>
		<a href = "news_delete.php?news_id=<?php echo $row['news_id']?>">删除</a> 
	</td>
</tr>
<?php
}

?>
</table>