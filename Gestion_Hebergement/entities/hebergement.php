<?php
class Hebergement
{
private $identifiant;
private $type;
private $adresse;
private $numero;
private $capacite;
private $services;
private $places_restantes;
private $nom;
private $gerant;


function __construct($id, $type, $adresse, $numero, $c, $serv, $pr,$nom, $gerant){
  $this->identifiant = $id;
  $this->type = $type;
  $this->adresse = $adresse;
  $this->numero = $numero;
  $this->capacite = $c;
  $this->services = $serv;
  $this->places_restante = $pr;
  $this->nom = $nom;
  $this->gerant = $gerant;
}

public function getId(){
  return $this->identifiant;
}

public function getType(){
  return $this->type;
}

public function getAdresse(){
  return $this->adresse;
}

public function getNumero(){
  return $this->numero;
}

public function getCapacite(){
  return $this->capacite;
}

public function getServices(){
  return $this->services;
}

public function getPlacesRestantes(){
  return $this->places_restante;
}

public function getNom(){
  return $this->nom;
}

public function getGerant(){
  return $this->gerant;
}


}

 ?>
