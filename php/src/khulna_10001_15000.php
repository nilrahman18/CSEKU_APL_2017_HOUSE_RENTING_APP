<?php

$user = "root";
$password = "99999999n";
$host = "127.0.0.1";
$db_name = "house_renting_app";

$con = mysqli_connect($host , $user , $password , $db_name);

$sql = "SELECT * FROM images INNER JOIN uploader_informations ON images.Image_ID = uploader_informations.ID INNER JOIN khulna ON images.Division = khulna.Division WHERE Price BETWEEN 10001 AND 15000";
$result = mysqli_query($con , $sql);

$Response = array();

if(mysqli_num_rows($result) > 0)
{
	while($row = mysqli_fetch_array($result))

	{		
		array_push($Response , array("ID"=>$row["ID"] , "Owner"=>$row["Name"] , "Division"=>$row["Division"] , "Address"=>$row["Address"] , "Description"=>$row["Description"] , "Price"=>$row["Price"] , "Contact"=>$row["Contact"] , "Name"=>$row["TEN"] , "URL"=>$row["URL"]));
	}
	
	echo json_encode(array("Server_Response"=>$Response));
}

?>