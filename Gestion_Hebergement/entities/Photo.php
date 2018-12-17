<?php
class Photo
{
private $identifiant; //identifiant du fichier ou code produit
private $name; //nom du fichier dans le dossier
private $desc; //description de la photo
private $cat; //categorie de la photo
private $marque;
private $prixmax; //prix maximum, prix à afficher si compte invité
private $prixmin;
private $codeHangar; //code emplacement produit dans le hangar
private $titre;
private $etat;
//Constructeur de la Class Photo
function __construct($id, $nom, $desc, $cat, $m, $pmx, $pmn,$c, $t, $e){
  $this->identifiant = $id;
  $this->name = $nom;
  $this->desc = $desc;
  $this->cat = $cat;
  $this->marque = $m;
  $this->prixmax = $pmx;
  $this->prixmin = $pmn;
  $this->codeHangar = $c;
  $this->titre = $t;
  $this->etat = $e;
}

public function getId(){
  return $this->identifiant;
}

public function getName(){
  return $this->name;
}

public function getDesc(){
  return $this->desc;
}

public function getCat(){
  return $this->cat;
}

public function getMarque(){
  return $this->marque;
}

public function getPrixmax(){
  return $this->prixmax;
}

public function getPrixmin(){
  return $this->prixmin;
}

public function getCodehangar(){
  return $this->codeHangar;
}

public function getTitre(){
  return $this->titre;
}

public function getEtat(){
  return $this->etat;
}

}

 ?>
