<?php
	header("content-Type: text/html; charset=Utf-8");
	include_once("functions/database.php");
	include_once("functions/page.php");
	include_once("functions/is_login.php");

	if(!session_id())
	{
		session_start();
	}
	if(isset($_GET["message"])){
		echo $_GET["message"]."<br/>";
	}

	$search_sql = "select * from category order by category_id desc";


	get_connection();

	$result_news = mysql_query($search_sql);

	$total_records = mysql_num_rows($result_news);

	$page_size = 3;

	if(isset($_GET["page_current"])){
		$page_current = $_GET["page_current"];
	}else{
		$page_current = 1;
	}

	$start = ($page_current - 1) * $page_size;

	$search_sql = "select * from category order by category_id desc limit $start, $page_size";



	$result_set = mysql_query($search_sql);

	close_connection();

	if(mysql_num_rows($result_set) == 0){
		exit("暂无记录!");
	}
?>

	<table class="table table-bordered">
		<thead>
			<tr>
				<th>新闻分类</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>

			<?php
				$html = '';
				while($row = mysql_fetch_array($result_set)){
					$html .= '<tr> <td>'.$row['name'].'</td>';
					if (is_admin()) {
						$html .= '<td> <a href = "index.php?url=category_delete.php&category_id='.$row['category_id'].'" onclick="return confirm(\'确定删吗?\');">删除</a> </td>';
					} else {
						$html .= '<td>/</td>';
					}
					$html .= '</tr>';
				}
				echo $html;
			?>

		</tbody>
	</table>

<?php
$url = "index.php?url=category_list.php";
page($total_records, $page_size, $page_current, $url, "");
?>