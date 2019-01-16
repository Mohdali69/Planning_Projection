<?PHP
require_once(PATH_MODELS.'DAO.php');
require_once(PATH_ENTITY.'Utilisateur.php');
class UtilisateurDAO extends DAO{

  public function getUser(){
    $requete = "Select * from Utilisateur";
    $data = $this->queryAll($requete);

    $i = 0;

    foreach ($data as $user) {
      $Users[$i] = new Utilisateur($user[0], $user[2], $user[1], $user[3]);
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
    $requete = "Update Utilisateur set password=? where user=?";
    $rep = $this->queryAll($requete, array($pass , $log));
    return ($rep);
  }
}
