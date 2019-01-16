<?php

?>

<div id="menu">
	<img src="./assets/images/logo.png" alt="logo du festival" id="logo">
	<ul class="nav">
		<a href="index.php?page=accueil"><li class="hm">
			<img class="icon" src="./assets/images/plus.png" alt="">
			<span>Accueil</span>
		</li></a>
		<?php if(isset($_SESSION['aut']) and $_SESSION['type'] == 'gerant' ){
          echo   '<a href="index.php?page=addHeberg"><li class="fb">
						<img class="icon" src="./assets/images/plus.png" alt="">
						<span>Ajouter un Hebergement</span>
					</li></a>';}
        ?>
		<?php if(isset($_SESSION['aut']) and $_SESSION['type'] == 'gerant' ){
		          echo   '<a href="index.php?page=actualise"><li class="gp">
								<img class="icon" src="./assets/images/plus.png" alt="">
								<span>Actualiser nombre places</span>
							</li></a>';}
		        ?>

		<a href="index.php?page=infoscompte"><li class="tw">
			<img class="icon" src="./assets/images/plus.png" alt="">
			<span>Mon Compte</span>
		</li></a>
		<a href="index.php?page=deconnexion"><li class="cl">
			<img class="icon" src="./assets/images/plus.png" alt="">
			<span>Deconnexion</span>
		</li></a>
	</ul>
</div>
<script type="text/javascript">
$(function(){
	$(window).scroll(
	function () {//Au scroll dans la fenetre on déclenche la fonction
	if ($(this).scrollTop() > 187) { //si on a défini de plus de 187 px du haut vers le bas
	$('#menu').addClass("fixgauche"); //on ajoute la classe "fixgauche" à <div id="gauche">
	} else {
	$('#menu').removeClass("fixgauche");//sinon on retire la classe "fixgauche" à <div id="gauche">
						}
					}
				);
			});
</script>
<hr>
<hr>

<section class="container-fluid">
