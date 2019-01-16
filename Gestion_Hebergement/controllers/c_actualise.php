<?php

if(isset($erreur)){
  choixAlert($erreur);
}

require_once(PATH_ENTITY.'HebergementDAO.php');
require_once(PATH_ENTITY.'Hebergement.php');

$HDAO = new HebergementDAO();
if(isset($_POST['pr'])){
  if(isset($_POST['idHeber'])){
    
    $rep = $HDAO->actualisePR($_POST['pr'],$_POST['idHeber']);
  }
}
$Tab = $HDAO->getHebergement();

foreach($Tab as $heb){
  if($heb->getGerant() == $_SESSION['current_id']){
    $HebTab[]=$heb;
  }
}



$page='actualise';
//appel de la vue
require_once(PATH_VIEWS.$page.'.php');
?>
