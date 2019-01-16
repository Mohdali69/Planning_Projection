<?php


if(isset($erreur)){
  choixAlert($erreur);
}
require_once(PATH_ENTITY.'UtilisateurDAO.php');
$UDAO = new UtilisateurDAO();
$data = $UDAO->getUser();
//Recuperer la classe Metier et MetierDAO
if(isset($_POST['email'])){
  if(isset($_POST['pwd'])){
    foreach($data as $dat){
      if($_POST['email'] == $dat->getLogin()){
        if($_POST['pwd']==$dat->getPass()){
          $page='accueil';
          $_SESSION['type']=$dat->getType();
          $_SESSION['id_compte']=$dat->getLogin();
          $_SESSION['aut']='true';
          $_SESSION['num']= 0;
          $_SESSION['nbPage']=1;
          $_SESSION['current_id']=$dat->getIdentifiant();
        }
        else{
          $err = 'Mauvais mot de passe';
        }
      }
      else{
        $err = 'Mauvais Identifiant';
      }
    }

}
}

if($page == 'accueil'){
  require_once(PATH_CONTROLLERS.$page.'.php');
}
else{  require_once(PATH_VIEWS.$page.'.php');}
