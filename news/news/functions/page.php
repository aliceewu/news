<?php

  function page($total_records,$page_size,$page_current,$url,$keyword)
  {
  	$total_pages = ceil($total_records/$page_size);
  	$page_previous = ($page_current<=1)?1:$page_current-1;
  	$page_next = ($page_current>=$total_pages)?$total_pages:$page_current+1;
    $page_next = ($page_next==1)?1:$page_next;
    $page_start = ($page_current-5>0)?$page_current-5:0;
    $page_end = ($page_start+10<$total_pages)?$page_start+10:$total_pages;
    $page_start = $page_end-10;
    if($page_start < 0) $page_start = 0;
    $parse_url = parse_url($url);
    if(empty($parse_url["query"])){
        $url = $url.'?';
    }else{
        $url = $url.'&';
    }
    if(empty($keyword))
    {
    	$navigator = "<nav><ul class='pagination'><li><a href=".$url."page_current=$page_previous>上一页</a></li>";
    	for($i = $page_start;$i<$page_end;$i++)
    	{
    		$j = $i +1;
    		$navigator.="<li><a href = '".$url."page_current=$j'>$j</a></li>"."&nbsp;";
    	}
    	$navigator.="<li><a href=".$url."page_current=$page_next>下一页</a></li>";
        $navigator .= "</ul></nav>";
    	$navigator.="<br/>共".$total_records."条记录,共".$total_pages."页,当前是第".$page_current."页";

    }else
    {
    	$keyword = $_GET['keyword'];
    	$navigator = "<nav><ul class='pagination'><li><a href=".$url."keyword=$keyword&page_current=$page_previous>上一页</a></li>";
    	for($i = $page_start;$i<$page_end;$i++)
    	{
    		$j = $i +1;
    		$navigator.="<li><a href'".$url."keyword=$keyword&page_current=$j'>$j</a></li>";
    	}
    	$navigator.="<li><a href=".$url."keyword=$keyword&page_current=$page_next>下一页</a></li>";
        $navigator .= "</ul></nav>";
    	$navigator.="<br/>共".$total_records."条记录,共".$total_pages."页,当前是第".$page_current."页";
    }

    echo $navigator;
  }
 ?>
