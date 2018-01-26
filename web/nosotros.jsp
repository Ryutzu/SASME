<%-- 
    Document   : nosotros
    Created on : Dec 7, 2017, 8:18:39 AM
    Author     : Sonia
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1" session="true"%>
<%
    HttpSession ses = request.getSession();
    request.setAttribute("nom", ses.getAttribute("nombre"));

%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
        <title>Doctor</title>

        <!-- Add to homescreen for Chrome on Android -->
        <meta name="mobile-web-app-capable" content="yes">
        <link rel="icon" sizes="192x192" href="images/android-desktop.png">

        <!-- Add to homescreen for Safari on iOS -->
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-title" content="Material Design Lite">
        <link rel="apple-touch-icon-precomposed" href="images/ios-desktop.png">

        <!-- Tile icon for Win8 (144x144 + tile color) -->
        <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
        <meta name="msapplication-TileColor" content="#3372DF">

        <link rel="shortcut icon" href="images/favicon.png">

        <!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
        <!--
        <link rel="canonical" href="http://www.example.com/">
        -->

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.cyan-light_blue.min.css">
        <link rel="stylesheet" href="styles.css">
        <style>
            #view-source {
                position: fixed;
                display: block;
                right: 0;
                bottom: 0;
                margin-right: 40px;
                margin-bottom: 40px;
                z-index: 900;
            }

            .demo-card-wide.mdl-card.oaxaca {
                width: 232px;
                position: absolute;
                left: 10%;
                top: 20%;
                
            }
            .demo-card-wide > .mdl-card__title.oaxaca2  {
                color: #d9006e;
                height: 150px;
                background: url('images/oaxaca.jpg') center / cover;
            }
            
            .demo-card-wide.mdl-card.angel {
                width: 232px;
                position: absolute;
                left: 50%;
                top: 20%;
                
            }
            .demo-card-wide > .mdl-card__title.angel2  {
                color: #d9006e;
                height: 150px;
                background: url('images/reynaldo.jpg') center / cover;
            }
            
            .demo-card-wide.mdl-card.madrigal {
                width: 232px;
                position: absolute;
                left: 10%;
                top: 70%;
                
            }
            .demo-card-wide > .mdl-card__title.madrigal2  {
                color: #d9006e;
                height: 200px;
                background: url('images/mad.jpg') center / cover;
            }
            
            .demo-card-wide.mdl-card.elimm {
                width: 232px;
                position: absolute;
                left: 50%;
                top: 70%;
                
            }
            .demo-card-wide > .mdl-card__title.elimm2  {
                color: #d9006e;
                height: 150px;
                background: url('images/elimm.jpg') center / cover;
            }

            .demo-card-wide > .mdl-card__menu {
                color: #fff;
            }
        </style>
        <script>

        </script>
    </head>
    <body>
        <div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
            <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
                <div class="mdl-layout__header-row">
                    <span class="mdl-layout-title">Perfil</span>
                    <div class="mdl-layout-spacer"></div>
                    <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="hdrbtn">
                        <i class="material-icons">more_vert</i>
                    </button>
                    <ul class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right" for="hdrbtn">
                        <li class="mdl-menu__item" href="nosotros.jsp">Nosotros</li>
                        <li class="mdl-menu__item">Nuestra Pagina</li>
                    </ul>
                </div>
            </header>
            <div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
                <header class="demo-drawer-header">
                    <div class="demo-avatar-dropdown">
                        <span><%request.getAttribute("nom");%></span>
                        <div class="mdl-layout-spacer"></div>
                    </div>
                </header>
                <nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800">
                    <a class="mdl-navigation__link" href="consulta.jsp">Consulta</a>
                    <a class="mdl-navigation__link" href="agregarDoc.jsp">Agregar Doctor</a>
                    <a class="mdl-navigation__link" href="agregarPac.jsp">Agregar Paciente</a>
                    <a class="mdl-navigation__link" href="bitacora.jsp">bitacora</a>
                    <a class="mdl-navigation__link" href="">salir</a>
                    <div class="mdl-layout-spacer"></div>

                </nav>
            </div>
            <main class="mdl-layout__content mdl-color--grey-100 ">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp oaxaca">
                    <div class="mdl-card__title oaxaca2 ">
                    </div>
                    <div class="mdl-card__supporting-text">
                        Un bato....
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                            David Oaxaca Perez
                        </a>
                    </div>
                </div>
                <div class="demo-card-wide mdl-card mdl-shadow--2dp angel">
                    <div class="mdl-card__title angel2 ">
                    </div>
                    <div class="mdl-card__supporting-text">
                        Otro bato....
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                            Angel Flores Lopez 
                        </a>
                    </div>
                </div>
                <div class="demo-card-wide mdl-card mdl-shadow--2dp madrigal">
                    <div class="mdl-card__title madrigal2 ">
                    </div>
                    <div class="mdl-card__supporting-text">
                        Un tercer bato....
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                            David Madrigal Buendia
                        </a>
                    </div>
                </div>
                <div class="demo-card-wide mdl-card mdl-shadow--2dp elimm">
                    <div class="mdl-card__title elimm2 ">
                    </div>
                    <div class="mdl-card__supporting-text">
                        Un ultimo bato....
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                            Elimm Corona Lucas
                        </a>
                    </div>
                </div>
            </main>
        </div>
        <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    </body>
</html>
