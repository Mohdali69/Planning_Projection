<?PHP
require_once(PATH_MODELS.'DAO.php');
require_once(PATH_ENTITY.'Utilisateur.php');
class UtilisateurDAO extends DAO{

  public function getUser(){
    $requete = "Select * from UTILISATEUR;";
    $data = $this->queryAll($requete);
    print_r($data);
    $i = 0;
    foreach ($data as $user) {
      $Users[$i] = new Utilisateur($user[0], $user[2], $user[3], $user[4], $user[1]);
      $i +=1;
    }
    return ($Users);
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
