<?php

if(isset($erreur)){
  choixAlert($erreur);
}
require_once(PATH_ENTITY.'UtilisateurDAO.php');

$UDAO = new UtilisateurDAO();



$page='about';
//appel de la vue
require_once(PATH_VIEWS.$page.'.php');
?>
