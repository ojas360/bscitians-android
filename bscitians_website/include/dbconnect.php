<?php

	$host = 'localhost';
	$username = 'root';
	$password = '';
	$db_name = 'bscitians';
	$con = mysqli_connect($host, $username, $password, $db_name);
	if(!$con)
	{
		die(mysqli_error($con).'<br/>Error in Connection');
	}
?>