<?php
class Film
{
private $identifiant;
private $titre;
private $duree;
private $realisateur;
private $pays;
private $competition;
private $nbProjections;
private $lendemain;

//Constructeur de la Class Film
function __construct($id, $title, $duree, $realisateur, $p, $comp, $nbP){
  $this->identifiant = $id;
  $this->titre = $title;
  $this->duree = $duree;
  $this->realisateur = $realisateur;
  $this->pays = $p;
  $this->competition = $comp;
  $this->nbProjections = $nbP;
  $this->lendemain = false;
}

public function getId(){
  return $this->identifiant;
}

public function getTitre(){
  return $this->titre;
}

public function getDuree(){
  return $this->duree;
}

public function getRealisateur(){
  return $this->realisateur;
}

public function getPays(){
  return $this->pays;
}

public function getCompetition(){
  return $this->competition;
}

public function getNbProjections(){
  return $this->nbProjections;
}

public function getLendemain(){
  return $this->lendemain;
}

public function setLendemain($ld){
  $this->lendemain = $ld;
}

}

 ?>
