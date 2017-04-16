<?php
$user = "root";
$password = "99999999n";
$host = "127.0.0.1";
$db_name = "house_renting_app";

$con = mysqli_connect($host , $user , $password , $db_name);

$User_Division = "";
if(isset($_POST["Division"])){
$User_Division = $_POST["Division"];
}
$ten = $_POST["TEN"];
$hinh = $_POST["HINH"];
$path = "uploads/$ten.jpg";
$url = "http://192.168.0.103/$path";
$qr = "INSERT INTO images VALUES(null,'$User_Division','$ten','$url')";
if(mysqli_query($con,$qr)){
  file_put_contents($path,base64_decode($hinh));
}else{
  echo "Error!";
}
?>