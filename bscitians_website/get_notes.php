<?php
	require('include/dbconnect.php');
	if(isset($_GET) && !empty($_GET))
	{

		if(isset($_GET['subject_id']) && !empty($_GET['subject_id']))
		{
			$subject_id = sanitize($_GET['subject_id']);
			$query = 'select n.notes_id , n.name , n.link , n.subject_id ,s.name as "subject" from notes n JOIN subject s on s.subject_id = n.subject_id where n.subject_id = '.$subject_id;
			$result = mysqli_query($con, $query);
			$notes = array();
			$count = 0;
			while($row = mysqli_fetch_assoc($result))
			{
				$notes[$count]["notes_id"] = $row["notes_id"]; //Might be useful
				$notes[$count]["name"] = $row["name"];
				$notes[$count]["link"] = $row["link"];
				$notes[$count]["subject_id"] = $row["subject_id"];
				$notes[$count]["subject"] = $row["subject"];
				$count++;	
			}
			
			echo json_encode($notes,JSON_UNESCAPED_SLASHES);
		}
		else 
		{
			die("Atleast You Tried!! Appreciate ur Efforts Though!");
		}
	} 
	else 
	{
		die("Atleast You Tried!! Appreciate ur Efforts Though!");
	}

	function sanitize($data)
	{
	   $data = trim($data);
	   $data = stripslashes($data);
	   $data = htmlspecialchars($data);
	   return $data;
	}
?>