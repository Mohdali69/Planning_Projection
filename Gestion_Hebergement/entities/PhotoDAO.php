<?PHP
require_once(PATH_MODELS.'DAO.php');
require_once(PATH_ENTITY.'Photo.php');
class PhotoDAO extends DAO{
  public function getUser(){
    $requete = 'Select * from Photo ';
    $donneeUser = $this->queryAll($requete);
    $i = 0;//compteur pour remplir le tableau d'objet
    if(empty($donneeUser) ){
      $PhotoTab = null;
    }else{
    foreach($donneeUser as $data){//pour chaque ligne du tab a 2D

      $PhotoTab[$i]= new Photo($data[0], $data[1], $data[2], $data[3], $data[4], $data[5], $data[6], $data[7], $data[8], $data[9]);//on créé un objet dans ce tableau
      $i++;
    }
  }
    return ($PhotoTab);
  }
  public function getCat(){
    $requete = 'Select * from Categorie';
    $donneeUser = $this->queryAll($requete);
    return($donneeUser);
  }

  public function delProduct($num){
    $requete = 'Delete from Photo where photoId = ?';
    $rep = $this->queryRow($requete, $num);
    return($rep);
  }


  public function addProduct($id, $nom, $descr, $catID, $marque, $prixmax, $prixmin, $codeHangar, $titre, $etat){
    $requete = 'insert into Photo values(?,?,?,?,?,?,?,?,?,?)';
    $rep = $this->queryRow($requete, array($id, $nom, $descr, $catID, $marque, $prixmax, $prixmin, $codeHangar, $titre, $etat));
    return $rep;
  }
  public function getNom($id){
    $requete = 'Select nomFich from Photo where photoId = ?';
    $rep = $this->queryAll($requete, array($id));
    return $rep;
  }

  public function addVente($i, $t, $p, $v,$e, $d){
    $requete = 'Insert into Vente values(?,?,?,?,?,?)';
    $rep = $this->queryRow($requete, array($i,$t,$p,$v,$e,$d));
    return $rep;
  }

  public function getVente(){
    $requete = 'Select * from Vente';
    $rep = $this->queryAll($requete);
    return $rep;
  }

  public function getTable(){
    $requete = 'SELECT * FROM `table`';
    $data = $this->queryAll($requete);
    return($data);
  }

  public function modifyPicture($nom, $id){
    $requete = 'Update Photo set nomFich=? where photoId=?';
    $rep = $this->queryRow($requete, array($nom, $id));
    return($rep);
  }
}
?>
