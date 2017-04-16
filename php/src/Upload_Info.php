<?php
$User_Name = "";
$User_Division = "";
$User_Address = "";
$User_Description = "";
$User_Price = "";
$User_Contact = "";

if(isset($_POST["Name"])){
$User_Name = $_POST["Name"];
}
if(isset($_POST["Division"])){
$User_Division = $_POST["Division"];
}
if(isset($_POST["Address"])){
$User_Address = $_POST["Address"];
}
if(isset($_POST["Description"])){
$User_Description = $_POST["Description"];
}
if(isset($_POST["Price"])){
$User_Price = $_POST["Price"];
}
if(isset($_POST["Contact"])){
$User_Contact = $_POST["Contact"];
}

$user = "root";
$password = "99999999n";
$host = "127.0.0.1";
$db_name = "house_renting_app";

$con = mysqli_connect($host , $user , $password , $db_name);

$sql = "insert into uploader_informations values (null , '".$User_Name."' , '".$User_Division."' , '".$User_Address."' , '".$User_Description."' , '".$User_Price."' , '".$User_Contact."');";

if(mysqli_multi_query($con , $sql))
{
	echo "Data Insertion Success";
}
else
{
	echo "Data Insertion Failed";
}

mysqli_close($con);

?>