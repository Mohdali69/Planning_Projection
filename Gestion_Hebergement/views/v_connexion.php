<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!-- Include the above in your HEAD tag ---------->

<!-- All the files that are required -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<?php

//  En tête de page
?>
<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>

<!--  Début de la page -->


<?php
if(isset($err)){
  echo '<div class="container text-center alert alert-danger">'.$err.'</div>';
}?>



<!-- LOGIN FORM -->
<div class="text-center" style="padding:50px 0">
	<div class="logo">Connexion</div>
	<!-- Main Form -->
	<div class="login-form-1">
		<form id="login-form" class="text-left" method="POST" action="index.php?page=connexion">
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
					<div class="form-group">
						<label for="email" class="sr-only">Username</label>
						<input type="text" class="form-control" id="email" name="email" placeholder="username">
					</div>
					<div class="form-group">
						<label for="pwd" class="sr-only">Password</label>
						<input type="password" class="form-control" id="pwd" name="pwd" placeholder="password">
					</div>
					<div class="form-group login-group-checkbox">
						<input type="checkbox" id="lg_remember" name="lg_remember">
						<label for="lg_remember">remember</label>
					</div>
				</div>
				<button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
			</div>

		</form>
	</div>
	<!-- end:Main Form -->
</div>

<?php
if(isset($_SESSION['autorisation'])){
if($_SESSION['autorisation']=='true'){
  $page='accueil';
}
}


?>
<?php
require_once(PATH_VIEWS.'footer.php');
?>
