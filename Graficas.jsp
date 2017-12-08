<%-- 
    Document   : Graficas
    Created on : 7/12/2017, 07:31:08 AM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1" session="true"%>
<%@page import="java.sql.ResultSet,Consultas.cConsulta"%>
<%
    HttpSession ses = request.getSession();
    String usuario = "" + ses.getAttribute("ID");
        String Tipo = ""+ses.getAttribute("Tipo");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
    <script src="js/Chart.min.js" type="text/javascript"></script>
    <script src="js/Chart.js" type="text/javascript"></script>
    <title>Estadisticas</title>

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
    </style>
    
    <%
        int Ene = 0;
        int Fe = 0;
        int Ma = 0;
        int Ab = 0;
        int May = 0;
        int Jun = 0;
        int Jul = 0;
        int Ago = 0;
        int Oct = 0;
        int Nov = 0;
        int Dic = 0;
        cConsulta consultas = new cConsulta();
        
        String [] Paciente = consultas.Fechas();
        
        for(int i = 0; i < Paciente.length; i++){
            if (Paciente[i].equals("Enero")) {
                        Ene++;
                    } else {
                        if (Paciente[i].equals("Febrero")) {
                            Fe++;
                        } else {
                            if (Paciente[i].equals("Marzo")) {
                                Ma++;
                            } else {
                                if (Paciente[i].equals("Abril")) {
                                    Ab++;
                                } else {
                                    if (Paciente[i].equals("Mayo")) {
                                        May++;
                                    } else {
                                        if (Paciente[i].equals("Junio")) {
                                            Jun++;
                                        } else {
                                            if (Paciente[i].equals("Julio")) {
                                                Jul++;
                                            } else {
                                                if (Paciente[i].equals("Agosto")) {
                                                    Ago++;
                                                } else {
                                                    if (Paciente[i].equals("Octubre")) {
                                                        Oct++;
                                                    } else {
                                                        if (Paciente[i].equals("Noviembre")) {
                                                            Nov++;
                                                        } else {
                                                            if (Paciente[i].equals("Diciembre")) {
                                                                Dic++;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            
        
    %>
    
  </head>
  <body>
    <div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
      <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
        <div class="mdl-layout__header-row">
          <span class="mdl-layout-title">Estadisticas</span>
          <div class="mdl-layout-spacer"></div>
          <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="hdrbtn">
            <i class="material-icons">more_vert</i>
          </button>
          <ul class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right" for="hdrbtn">
            <li class="mdl-menu__item">Nosotros</li>
            <li class="mdl-menu__item">Nuestra Pagina</li>
          </ul>
        </div>
      </header>
      <div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
        <header class="demo-drawer-header">
          <div class="demo-avatar-dropdown">
            <span><%out.print("<a>"+usuario+"</a>");%></span>
            <div class="mdl-layout-spacer"></div>
          </div>
        </header>
        <nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800">
            <%
                if(Tipo.equals("Jefe_Area")){
                    
            %>   
                <a class="mdl-navigation__link" href="consultarDoc.jsp">Doctores</a>
                <a class="mdl-navigation__link" href="">Bit�coras</a>
            <%        
                }else if(Tipo.equals("Doctor")){
            %>
                <a class="mdl-navigation__link" href="consulta.jsp">Consulta M�dica</a>
                <a class="mdl-navigation__link" href="consultaExp.jsp">Expedientes</a>
                <a class="mdl-navigation__link" href="">Bit�coras</a>
            <%
                }
            %>
          <a class="mdl-navigation__link" href="Graficas.jsp">Estadisticas</a>
          <a class="mdl-navigation__link" href="CerrarSesion.jsp">salir</a>
          <div class="mdl-layout-spacer"></div>
        </nav>
      </div>
      <main class="mdl-layout__content mdl-color--grey-100">
        <canvas id='canvas' width="500" height="200"></canvas>
        <script>
            var ctx2 = document.getElementById("canvas").getContext('2d');
            var myChart2 = new Chart(ctx2, {
                type: 'bar',
                data: {
                    labels: ["Enero","Febrero","Marzo","Abril","Mayo","Julio","Junio","Agosto","Octubre","Noviembre","Diciembre"],
                    datasets: [{
                        label: 'Usuarios atendidos',
                        backgroundColor: "rgba(42, 226, 27, 0.4)",
                        borderColor: "rgba(60, 205, 133, 1)",
                        highlightFill: "#1864f2",
                        highlightStroke: "#ffffff",
                        borderWidth: 1,
                        data: [<%=Ene%>, <%=Fe%>, <%=Ma%>, <%=Ab%>, <%=May%>, <%=Jun%>, <%=Jul%>, <%=Ago%>, <%=Oct%>, <%=Nov%>, <%=Dic%>]
                    }]
                }
                
            });
        </script>
      </main>
    </div>
    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
  </body>
</html>