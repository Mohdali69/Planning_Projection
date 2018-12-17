<?php

if(isset($erreur)){
  choixAlert($erreur);
}
require_once(PATH_ENTITY.'Photo.php');
require_once(PATH_ENTITY.'PhotoDAO.php');
//Creation d'un compteur pour l'incrementation
$title = 'Tous les produits';
$count = 0;
//Objet Classe Metier DAO
$UDAO = new PhotoDAO();
//$categorie Tableau 2D avec toutes les Categorie
$categorie = $UDAO->getCat();
//$table Tableau 2D avec toutes les Photos (Classe Metier Photo)
$limite = 31;
if(isset($_POST['val']) and $_POST['val'] == "next"){
  $_SESSION['num'] += $limite;
  $_SESSION['nbPage']+=1;
}
if(isset($_POST['val']) and $_POST['val'] == "prev" and $_SESSION['num'] >= $limite){
  $_SESSION['num'] -= $limite;
  $_SESSION['nbPage']-=1;
}
$table = $UDAO->getUser();
$tab=null;
if($table!=null){
if(isset($choix) && $choix!='Toutes'){//Si il y a un choix de Categorie alors on effectue ceci ²sinon Affichage de Toutes les Photos²
foreach($table as $t){//Affichage des Photos en fct de la Categorie
  if($t->getCat() == $choix){
    $tab[$count] = $t;
    $count = $count +1;

  }
}
foreach($categorie as $cate){//Affichage du Titre en fct du choix et de la categorie
  if ($cate[0] == $choix){
    $title = $cate[1];
  }
}
}
else{
  foreach($table as $t){
    $tab[$count]= $t;
    $count = $count+1;
  }
  $title = 'Tous les produits';
}
}

$_SESSION['nbProd'] = $count;
$page='accueil';
//appel de la vue
require_once(PATH_VIEWS.$page.'.php');
?>
