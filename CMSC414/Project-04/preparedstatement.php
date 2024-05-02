<?php
function checkpassword($username, $password){ 
  $db1 = new mysqli("localhost", "apache", "apache", "sql_phpbb_db");
  
  if (mysqli_connect_errno()){
     printf("Connection Error: %s\n", mysqli_connect_error());
     return 0;
  }

  if (!$username) {
     return 0;
  }

  if (!$password) {
     return 0;
  }

  $query = "SELECT user_id, username, user_password FROM phpbb_users WHERE username = '$username' AND user_password = 'md5($password)'";

  if ($stmt = $db1->prepare($query)){
     $stmt->bind_param("si", $username, sha1($password));
     $stmt->execute();
     $stmt->bind_result($bind_id, $bind_name, $bind_password);
     $chk = $stmt->fetch();

     if ($bind_id != "") {
     	$getroles = new roles();
	$now = time();

	$_SESSION['user_id'] = $bind_id;
	$_SESSION['username'] = $bind_name;
	$_SESSION['password'] = $bind_password;
	$_SESSION['userpermissions'] = $getroles->getUserRole($bind_id);

	$user_id = $_SESSION['user_id'];
	$sesh = session_id();

	$stmt->close();
	$db1->close();

	return 1;
     } else {
       	$stmt->close();
	$db1->close();

        return 0;
     }
  }

  return 1;
}
?>
