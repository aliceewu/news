<?php
header("content-Type: text/html; charset=Utf-8");
function upload($file, $file_path){
	$error = $file['error'];
	switch ($error) {
		case 0:
			$file_name = $file['name'];
   			$file_temp = $file['tmp_name'];
   			
			$upload_file = iconv("UTF-8", "GBK", $file_name);
			   //先转换名字为 GBK 编码
			$destination = $file_path."/".$upload_file;
	        move_uploaded_file($file_temp, $destination);

			return "文件上传成功!";
			break;

		case 1:
			return "上传附件超过了php.ini中upload_max_filesize选项限制的值";
			break;
		case 2:
			return "上传附件的大小超过了form表单MAX_FILE_SIZE选项指定的值";
			break;
		case 3:
			return "附件只有部分被上传";
			break;
		case 4:
			return "没有选择上传附件";
			break;
		
		default:
			# code...
			break;
	}
}

function download($file_dir, $file_name){
	 $filename = iconv('UTF-8','GBK',$file_name);
  	echo $filename;
  	echo $file_dir;
   if(!file_exists($file_dir.$filename)){
      exit("文件不存在或已删除");
   }else{
      
     $fp=fopen($file_dir.$filename,'r');//只读方式打开
        $filesize=filesize($file_dir.$filename);//文件大小

        //取得文件的扩展名
        $extension_name = extension_name($file_name);
        //根据扩展名获得文件的MIME类型
        $content_type = content_type($extension_name);

        //返回的文件(流形式)
        header("Content-type: application/octet-stream; $content_type");
        //按照字节大小返回
        header("Accept-Ranges: bytes");
        //返回文件大小
        header("Accept-Length: $filesize");
        //这里客户端的弹出对话框，对应的文件名
        header("Content-Disposition: attachment; filename=".$filename);
        //================重点====================
        ob_clean();
        flush();
        //=================重点===================
        //设置分流
        $buffer=1024;
        //来个文件字节计数器
        $count=0;
        while(!feof($fp)&&($filesize-$count>0)){
            $data=fread($fp,$buffer);
            $count+=$data;//计数
            echo $data;//传数据给浏览器端
        }

        fclose($fp);


   }
}

function extension_name($file_name){
  $extension = explode(".", $file_name);
  $key = count($extension) - 1;
  return $extension[$key];
}

function content_type($extension){
  $mime_types = array(
    'txt' => 'text/plain',
    'htm' => 'text/html',
    'html' => 'text/html',
    'php' => 'text/html',
    'css' => 'text/css',
    'js' => 'application/javascript',
    'xml' => 'application/xml',
    'swf' => 'application/x-shockware-flash',
    'flv' => 'video/x-flv',
    //images
    'png' => 'image/png',
    'jpe' => 'image/jpeg',
    'jpeg' => 'image/jpeg',
    'jpg' => 'image/jpeg',
    'gif' => 'image/gif',
    'bmp' => 'image/bmp',
    'ico' => 'image/vnd.miscrosoft.icon',
    //archives
    'zip' => 'application/zip',
    'rar' => 'application/x-rar-compressed',
    'exe' => 'application/x-msdownload',
    //audio/vide
    'mp3' => 'audio/mpeg',
    'qt' => 'video/quicktime',
    'mov' => 'video/quicktime',
    //adobe
    'pdf' => 'application/pdf',
    //ms office
    'doc' => 'application/msword',
    'rtf' => 'application/rtf',
    'xls' => 'application/vnd.ms-excel',
    'ppt' => 'application/vnd.ms-powerpoint'
  );
  if(array_key_exists($extension, $mime_types)){
    return $mime_types["$extension"];
  }else{
    return "application/octet-stream";
  }
}

?>