<?php
class Reservation
{
private $typepers;
private $date;
private $num_VIP;
private $num_Hebergement;

//Constructeur de la Class Utilisateur
function __construct($date, $type, $nV, $nh){
  $this->typepers = $type;
  $this->date = $date;
  $this->num_VIP = $nV;
  $this->num_Hebergement = $nh;
}

public function getTypePers(){
  return $this->typepers;
}

public function getDate(){
  return $this->date;
}

public function getNumVIP(){
  return $this->num_VIP;
}

public function getNumHebergement(){
  return $this->num_Hebergement;
}
}

 ?>
