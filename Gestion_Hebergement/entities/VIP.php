<?php
class VIP
{
private $identifiant;
private $nom;
private $prenom;
private $adresse;
private $fonction;


//Constructeur de la Class VIP
function __construct($id, $nom, $prenom, $adresse, $f){
  $this->identifiant = $id;
  $this->nom = $nom;
  $this->prenom = $prenom;
  $this->adresse = $adresse;
  $this->fonction = $f;

}

public function getId(){
  return $this->identifiant;
}

public function getNom(){
  return $this->nom;
}

public function getPrenom(){
  return $this->prenom;
}

public function getAdresse(){
  return $this->adresse;
}

public function getFonction(){
  return $this->fonction;
}


}

 ?>
