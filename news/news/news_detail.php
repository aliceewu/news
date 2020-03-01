<?php
header('Content-type:text/html;charset=utf-8');
include_once("functions/database.php");

$news_id = $_GET["news_id"];

$sql_news_update = "update news set clicked=clicked+1 where news_id=$news_id";
$sql_news_detail = "select * from news where news_id=$news_id";
$sql_review_query = "select * from review where news_id=$news_id and state='已审核'";

get_connection();

mysql_query($sql_news_detail);

$result_news = mysql_query($sql_news_detail);

$result_review = mysql_query($sql_review_query);

//取出结果集中新闻条数
$count_news = mysql_num_rows($result_news);
//取出结果集中该新闻"已审核"的评论条数
$count_reviews = mysql_num_rows($result_review);

if($count_news == 0){
	echo "该新闻不存在或已被删除!";
	exit;
}

//根据新闻信息中的user_id查询对应的用户信息
$news = mysql_fetch_array($result_news);
$user_id = $news["user_id"];
$sql_user = "select * from users where user_id=$user_id";
$result_user = mysql_query($sql_user);
$user = mysql_fetch_array($result_user);
//根据新闻信息中的category_id查询对应的新闻类别信息
$category_id = $news["category_id"];
$sql_category = "select * from category where category_id=$category_id";
$result_category = mysql_query($sql_category);
$category = mysql_fetch_array($result_category);
close_connection();

mysql_free_result($result_user);
mysql_free_result($result_category);
mysql_free_result($result_news);
mysql_free_result($result_review);

$title = $news['title'];
$content = $news['content'];
if(isset($_GET['keyword'])){
	$keyword = $_GET["keyword"];
	$replacement = "<b><i>".$keyword."<b><i>";
	$title = str_replace($keyword, $replacement, $title);
	$content = str_replace($keyword, $replacement, $content);
}

// htmlspecialchars()
?>

<h3 class="text-center"><?php echo $title?></h3>
<p class="text-center">作者：<?php echo $user['name'];?> 类别：<?php echo $category['name'];?> 发布时间：<?php echo $news['publish_time'];?> 点击次数：<?php echo $news['clicked'];?></p>
<div style="padding: 15px;">
	<?php echo html_entity_decode($content, ENT_QUOTES)?>
</div>
<p>附件-<a href="download.php?attachment=<?php echo urlencode($news['attachment']);?>"><?php echo $news['attachment'];?></a></p>

<div>
  	<h4>发表评论</h4>
</div>
<form action="review_save.php" method="post">
	<textarea name="content" class="form-control" rows="3"></textarea> <br>
	<input type="hidden" name="news_id" value="<?php echo $news['news_id'];?>">
	<input type="submit" name="评论" class="btn btn-default" value="评论">
</form>
<br>

<?php

// if($count_reviews > 0){
// 	echo "<a href = 'index.php?url=review_news_list.php&news_id=".$news['news_id']."'>共有".$count_reviews."条评论</a></br/>";
// }else{
// 	echo "该新闻暂无评论!<br/>";
// }

$news_id = $news['news_id'];
$sql = "select * from review where news_id=$news_id and state='已审核' order by review_id desc";

get_connection();

$result_set = mysql_query($sql);

close_connection();
echo '<div class="well">';
while($row = mysql_fetch_array($result_set))
{
	echo '<p>[ '.$row["publish_time"].' ] [ '.$row["ip"].' ]：'.$row["content"].'</p>';
}
echo "</div>";
?>

<hr>

