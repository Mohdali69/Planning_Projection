<?php
unset($_SESSION['aut']);
unset($_SESSION['type']);
session_destroy();
$page = 'connexion';
require_once(PATH_VIEWS.$page.'.php');
