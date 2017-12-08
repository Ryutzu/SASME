

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrando...</title>
    </head>
    <%
        String ID = request.getParameter("ID");
        String TOKEN = request.getParameter("token");
        if(ID!=null&&TOKEN!=null){
    %>
    <body>
        <form id="llevar" method="POST" action="ValidaAcceso">
            <input type="hidden" value="<%=ID%>" name="ID">
            <input type="hidden" value="<%=TOKEN%>" name="ID2">
        </form>
        <script>
        var go = document.getElementById('llevar');
        go.submit();
        </script>
    </body>
    <%
        }else{
            response.sendRedirect("http://192.168.9.138:8084/SASME");
        }
    %>
</html>
