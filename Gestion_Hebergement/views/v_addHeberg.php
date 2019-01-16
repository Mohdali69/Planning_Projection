<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<?php require_once(PATH_VIEWS.'header.php');?>
<?php require_once(PATH_VIEWS.'menu.php') ?>
<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>


<div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
                        <h3>Ajouter un hebergement</h3>
                        <?php
                            if(isset($rep)){
                            echo '<div class="container alert alert-success">
                              Hebergement ajouté ! Identifiant : '.$id.'
                            </div>';
                            }
                            ?>
                    </div>
                    <div class="col-md-9 register-right">

                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">Merci de participer au festival !</h3>
                                <form class="" action="index.php?page=addHeberg" method="post">
                                <div class="row register-form">
                                    <div class="col-md-6">

                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Hotêl/villa..." value="" name="type" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Adresse" value="" name="adresse"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="number" class="form-control" placeholder="Numero" value="" name="numeroTel"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="number" class="form-control"  placeholder="Capacite" value="" name="capacite"/>
                                        </div>

                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Vos Services" value="" name="services"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="text"  name="nom" class="form-control" placeholder="Nom" value="" />
                                        </div>


                                        <input type="submit" class="btnRegister"  value="Valider"/>
                                    </div>

                                </div>
                              </form>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
<?php
require_once(PATH_VIEWS.'footer.php');
?>
