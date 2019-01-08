<?PHP
require_once(PATH_MODELS.'DAO.php');
require_once(PATH_ENTITY.'Hebergement.php');
class HebergementDAO extends DAO{

  public function getHebergement(){
    $requete = "Select * from Hebergement";
    $data = $this->queryAll($requete);
    $i = 0;//compteur pour remplir le tableau d'objet
    if(empty($data) ){
      $HebTab = null;
    }else{
    foreach($data as $dat){//pour chaque ligne du tab a 2D

      $HebTab[]= new Hebergement($dat[0], $dat[1], $dat[2], $dat[3], $dat[4], $dat[5], $dat[6], $dat[7]);//on créé un objet dans ce tableau
      $i++;
    }
  }
    return ($HebTab);
  }

  public function addUser($log, $mot, $type, $mail, $date){
    $requete = "Insert into Utilisateur values(?,?,?,?,?)";
    $rep = $this->queryAll($requete, array($log, $mot, $type, $mail, $date));
    return ($rep);
  }
  public function changeMdp($log, $pass){
    $requete = "Update Utilisateur set mot=? where login = ?";
    $rep = $this->queryAll($requete, array($pass , $log));
    return ($rep);
  }
}
