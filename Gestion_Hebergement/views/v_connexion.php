<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Include the above in your HEAD tag ---------->

<!-- All the files that are required -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<?php

//  En tête de page
?>
<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>

<!--  Début de la page -->


<?php
if(isset($err)){
  echo '<div class="container text-center alert alert-danger">'.$err.'</div>';
}?>




?>
    <section class="login-block">
        <div class="container">
    	<div class="row">
    		<div class="col-md-4 login-sec">
    		    <h2 class="text-center">Connexion</h2>
          		    <form class="login-form" method="post" action="index.php?page=connexion">
                              <div class="form-group">
                                <label for="exampleInputEmail1" class="text-uppercase">Identifiant</label>
                                <input type="text" class="form-control" placeholder="" id="email" name="email">

                              </div>
                              <div class="form-group">
                                <label for="exampleInputPassword1" class="text-uppercase">Password</label>
                                <input type="password" class="form-control" placeholder="" name="pwd" id="pwd">
                              </div>


                                <div class="form-check">
                                <label class="form-check-label">
                                  <input type="checkbox" class="form-check-input">
                                  <small>Se souvenir de moi</small>
                                </label>
                                <button type="submit" class="btn btn-login float-right">Valider</button>
                              </div>

          </form>
    <div class="copy-text">Redwan Kara/Mohamed-Ali Beldjilali <i class="fa fa-link"></i> <a href="https://iutdoua-web.univ-lyon1.fr/~p1700102/Vitrine/index.php?page=accueil">RedwanKara.com</a> | <a href="https://mohamedalib.pb.design">Mohamed-Ali Beldjilali</a></div>
    		</div>
    		<div class="col-md-8 banner-sec">
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                     <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                      </ol>
                <div class="carousel-inner" role="listbox">
        <div class="carousel-item active">
          <img class="d-block img-fluid" src="./assets/images/background_movie.png" alt="Courts-métrages">
          <div class="carousel-caption d-none d-md-block">
            <div class="banner-text">
                <h2>Courts-métrages</h2>

            </div>
      </div>
        </div>
        <div class="carousel-item">
          <img class="d-block img-fluid" src="./assets/images/movieLM.png" alt="Longs-métrages">
          <div class="carousel-caption d-none d-md-block">
            <div class="banner-text">
                <h2>Longs-métrages</h2>

            </div>
        </div>
        </div>
        <div class="carousel-item">
          <img class="d-block img-fluid" src="./assets/images/UCR.jpg" alt="Un Certain Regard">
          <div class="carousel-caption d-none d-md-block">
            <div class="banner-text">
                <h2>Un Certain Regard</h2>

            </div>
        </div>
      </div>
                </div>

    		</div>
    	</div>
    </div>
    </section>


<?php
if(isset($_SESSION['autorisation'])){
if($_SESSION['autorisation']=='true'){
  $page='accueil';
}
}


?>
<?php
require_once(PATH_VIEWS.'footer.php');
?>
