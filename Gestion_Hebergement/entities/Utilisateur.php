<?php
class Utilisateur
{
private $login; //identifiant du fichier ou code produit
private $type; //nom du fichier dans le dossier
private $mail; //description de la photo
private $date; //categorie de la photo
private $pass;

//Constructeur de la Class Photo
function __construct($log, $type, $mail, $date, $pass){
  $this->login = $log;
  $this->type = $type;
  $this->mail = $mail;
  $this->date = $date;
  $this->pass = $pass;
}

public function getLogin(){
  return $this->login;
}

public function getType(){
  return $this->type;
}

public function getMail(){
  return $this->mail;
}

public function getDate(){
  return $this->date;
}

public function getPass(){
  return $this->pass;
}
}

 ?>
