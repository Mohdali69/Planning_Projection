<?php
require_once(PATH_ENTITY.'UtilisateurDAO.php');
$page = 'infoscompte';
$UDAO = new UtilisateurDAO();
$users = $UDAO->getUser();
foreach ($users as $user) {
  if($user->getLogin() == $_SESSION['id_compte']){
    $utilisateur = $user;
  }
}
if(isset($_POST['opsswd'])){
  if(sha1($_POST['opsswd']) == $utilisateur->getPass()){
  if(isset($_POST['npsswd']) and isset($_POST['cpsswd'])){
    if($_POST['npsswd'] == $_POST['cpsswd']){
      $rep = $UDAO->changeMdp($utilisateur->getLogin(), sha1($_POST['npsswd']));

    }
    else{
      $erreur = 'Veuillez confirmer votre nouveau mot de passe.';
    }
  }else{
    $erreur = 'Veuillez confirmer votre nouveau mot de passe.';
  }
}else{
  $erreur = 'Veuillez entrer votre ancien mot de passe.';
}
}

require_once(PATH_VIEWS.$page.'.php');
