

<?php

//  En tête de page
?>
<?php require_once(PATH_VIEWS.'header.php');?>
<?php require_once(PATH_VIEWS.'menu.php') ?>
<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>


<!--  Début de la page -->

<div class="container">
  <h1 id="title">Vos Hebergements </h1>
  <?php
      if(isset($rep)){
      echo '<div class="container alert alert-success">
        Places restantes mises à jour !
      </div>';
      }
      ?>
  <div id="" class="row view-group">
    <?php foreach($HebTab as $heber){
        echo        '
                            <div class="item col-xs-4 col-lg-4">
                                <div class="thumbnail ">
                                    <div class="img-event">
                                        <img class="group list-group-image img-fluid" src="./assets/images/hotel.png" alt="" />
                                    </div>
                                    <div class="caption card-body">
                                        <h4 class="group card-title inner list-group-item-heading">
                                            '.$heber->getNom().'</h4>
                                        <p class="group inner list-group-item-text">
                                            <strong>Type : </strong> '.$heber->getType().' <strong>Adresse :</strong> '.$heber->getAdresse().' <strong>Numero :</strong> '.$heber->getNumero().'
                                             <strong>Capacité :</strong> '.$heber->getCapacite().' <strong>Services :</strong> '.$heber->getServices().'</p>
                                             <p><strong> Places restantes : </strong>'.$heber->getPlacesRestantes().' </p>
                                             <form class="form-inline" method="post" action="index.php?page=actualise">
                                               <label class="sr-only" for="inlineFormInput">Actualiser les places restantes</label>
                                               <input type="hidden" name="idHeber" value="'.$heber->getId().'">
                                               <input type="number" max="'.$heber->getCapacite().'" class="form-control mb-2 mr-sm-2 mb-sm-0" id="inlineFormInput" name="pr"placeholder="">
                                               <button type="submit" class="btn btn-primary">Valider</button>
                                             </form>
                                    </div>
                                </div>
                            </div>
                        ';
      }
            ?>
            </div>
</div>

<?php
require_once(PATH_VIEWS.'footer.php');
 ?>
<!--  Fin de la page -->

<!--  Pied de page -->
