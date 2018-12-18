<?php


const DEBUG = true; // production : false; dev : true

// Accès base de données
const BD_HOST = 'iutdoua-oracle.univ-lyon1.fr';
const BD_HOST_PORT = 1521;
const BD_SERVICE_NAME = 'orcl';
const BD_DBNAME = 'p1700102';
const BD_USER = 'p1700102';
const BD_PWD = '294150';
const BD_CONNECT = 'oci:dbname=(DESCRIPTION =
(ADDRESS_LIST =
	(ADDRESS =
		(PROTOCOL = TCP)
		(Host = '.BD_HOST.')
		(Port = '.BD_HOST_PORT.'))
)
(CONNECT_DATA =
	(SERVICE_NAME = '.BD_SERVICE_NAME.')
)
)';

// Langue du site
const LANG ='FR-fr';

// Paramètres du site : nom de l'auteur ou des auteurs
const AUTEUR = 'Kara Redwan';

//dossiers racines du site
define('PATH_CONTROLLERS','./controllers/c_');
define('PATH_ENTITY','./entities/');
define('PATH_ASSETS','./assets/');
define('PATH_LIB','./lib/');
define('PATH_MODELS','./models/');
define('PATH_VIEWS','./views/v_');
define('PATH_TEXTES','./languages/');

//sous dossiers
define('PATH_CSS', PATH_ASSETS.'css/');
define('PATH_IMAGES', PATH_ASSETS.'images/');
define('PATH_SCRIPTS', PATH_ASSETS.'scripts/');
//define("PATH_GALERIE",'galerie/');
//define('PATH_LOG','log/');

//fichiers
//define('LOG_BDD','logbdd.txt');
define('PATH_LOGO', PATH_IMAGES.'logo.png');
define('PATH_MENU', PATH_VIEWS.'menu.php');
