<?php

if(isset($erreur)){
  choixAlert($erreur);
}

require_once(PATH_ENTITY.'HebergementDAO.php');
require_once(PATH_ENTITY.'Hebergement.php');

$HDAO = new HebergementDAO();
if(isset($_POST['type']) and $_POST['type']!=''){
  if(isset($_POST['adresse']) and $_POST['adresse']!=''){
    if(isset($_POST['numeroTel']) and $_POST['numeroTel']!=''){
      if(isset($_POST['capacite']) and $_POST['capacite']!=''){
        if(isset($_POST['services']) and $_POST['services']!=''){
          if(isset($_POST['nom']) and $_POST['nom']!=''){
            $id = rand();
            $placesRestantes=$_POST['capacite'];

            $rep = $HDAO->addHebergement($id,$_POST['type'],$_POST['adresse'],$_POST['numeroTel'],$_POST['capacite'],$_POST['services'],$placesRestantes,$_POST['nom'], $_SESSION['current_id']);
          }
        }
      }
    }
  }
}


$page='addHeberg';
//appel de la vue
require_once(PATH_VIEWS.$page.'.php');
?>
