<?php
class Utilisateur
{
private $login;
private $type;
private $pass;
private $identifiant;

//Constructeur de la Class Utilisateur
function __construct($log, $type, $pass, $num_user){
  $this->login = $log;
  $this->type = $type;
  $this->pass = $pass;
  $this->identifiant = $num_user;
}

public function getLogin(){
  return $this->login;
}

public function getType(){
  return $this->type;
}

public function getIdentifiant(){
  return $this->identifiant;
}

public function getPass(){
  return $this->pass;
}
}

 ?>
