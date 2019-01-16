<?php


 ?>
 <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
 <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
 <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <!------ Include the above in your HEAD tag ---------->

 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <?php

 //  En tête de page
 ?>
 <?php require_once(PATH_VIEWS.'header.php');?>
<?php require_once(PATH_VIEWS.'menu.php') ?>
 <!--  Zone message d'alerte -->
 <?php require_once(PATH_VIEWS.'alert.php');?>

 <!--  Début de la page -->

 <div class="container">

   <div class="card">
    <div class="box">
        <div class="img">
            <img src="https://image.ibb.co/jw55Ex/def_face.jpg">
        </div>


                  <form class="" action="index.php?page=infoscompte" method="post">

                    <label>Mot de passe</label>
                    <div class="form-group ">
                            <input type="password" class="form-control" placeholder="Mot de passe" name="opsswd">
                        </div>
                       <label>Nouveau</label>
                        <div class="form-group ">
                            <input type="password" class="form-control" placeholder="Nouveau" name="npsswd">
                        </div>
                       <label>Confirmation </label>
                        <div class="form-group ">
                            <input type="password" class="form-control" placeholder="Confirmation" name="cpsswd">
                        </div>
                        <input type="submit" class="btn btn-info btn-circle " style="float:right;"><i class="glyphicon glyphicon-ok"></i></button>
                        </form>
                        <?php
                        if(isset($rep) ){
                          echo '<div class="alert alert-success">
                          <span class="glyphicon glyphicon-ok"></span> Mot de passe mis à jour. </div>
                          ';
                        }
                        else if(isset($erreur)){
                          echo '<div class="alert alert-danger">
                          <span class="glyphicon glyphicon-remove"></span> '.$erreur.'</div>
                          ';
                        }
                         ?>

        <span>
            <ul>
                <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                <li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
                <li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
                <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
            </ul>
        </span>
    </div>
</div>
  </div>
 <?php
 require_once(PATH_VIEWS.'footer.php');
