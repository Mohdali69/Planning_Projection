<?php

if(isset($erreur)){
  choixAlert($erreur);
}

require_once(PATH_ENTITY.'HebergementDAO.php');
require_once(PATH_ENTITY.'Hebergement.php');

$HDAO = new HebergementDAO();

$HebTab = $HDAO->getHebergement();


$page='accueil';
//appel de la vue
require_once(PATH_VIEWS.$page.'.php');
?>
