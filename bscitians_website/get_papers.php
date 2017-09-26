<?php
	require('include/dbconnect.php');
	if(isset($_GET) && !empty($_GET))
	{

		if(isset($_GET['subject_id']) && !empty($_GET['subject_id']))
		{
			$subject_id = sanitize($_GET['subject_id']);
			$query = 'select p.paper_id , p.name , p.link  , p.subject_id , s.name as "subject" from paper p JOIN subject s on p.subject_id = s.subject_id  where p.subject_id = '.$subject_id;
			$result = mysqli_query($con, $query);
			$papers = array();
			$count = 0;
			while($row = mysqli_fetch_assoc($result))
			{
				$papers[$count]["paper_id"] = $row["paper_id"]; //Might be useful
				$papers[$count]["name"] = $row["name"];
				$papers[$count]["link"] = $row["link"];
				$papers[$count]["subject"] = $row["subject"];
				$count++;	
			}
			
			echo json_encode($papers,JSON_UNESCAPED_SLASHES);
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