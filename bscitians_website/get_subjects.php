<?php
	require('include/dbconnect.php');
	if(isset($_GET) && !empty($_GET))
	{

		if(isset($_GET['sem_id']) && !empty($_GET['sem_id']))
		{
			$sem_id = sanitize($_GET['sem_id']);
                        if(isset($_GET['practicals']) && !empty($_GET['practicals']) && $_GET['practicals'] == "yes")
                        {
                             $query = 'select s.subject_id , s.description , s.name , s.image_path , s.pdf_link , s.semester_id , se.description as "Semester" from subject s JOIN semester se on s.semester_id = se.semester_id where s.semester_id = '.$sem_id.' AND s.practicals = 1 ';
                        }else{ 
			    $query = 'select s.subject_id , s.description , s.name , s.image_path , s.semester_id , se.description as "Semester" from subject s JOIN semester se on s.semester_id = se.semester_id where s.semester_id = '.$sem_id;
			}
                        $result = mysqli_query($con, $query);
			$subjects = array();
			$count = 0;
			while($row = mysqli_fetch_assoc($result))
			{
				/*echo "<br/><b>";
				print_r($row);
				echo "<br/></b>";*/
				$subjects[$count]["subject_id"] = $row["subject_id"]; //Might be useful
				$subjects[$count]["name"] = $row["name"];
				$subjects[$count]["description"] = $row["description"];
				$subjects[$count]["image_path"] = $row["image_path"];
				$subjects[$count]["semester_id"] = $row["semester_id"];
				$subjects[$count]["semester"] = $row["Semester"];
                                if(isset($row["pdf_link"])) $subjects[$count]["pdf_link"] = $row["pdf_link"];
				$count++;
			}
			
			echo json_encode($subjects,JSON_UNESCAPED_SLASHES);
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