/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;
import BD.cDatos;
import Cifrados.DesEncrypter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidaAcceso extends HttpServlet {
    int tipo = 0;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidarAcceso</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidarAcceso at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String key = "51eac6b471a284d3341d8c0c63d0f1a286262a18"; //llave del servicio
            DesEncrypter sec = new DesEncrypter(key);
            String ID = request.getParameter("ID");
            String ID2 = request.getParameter("ID2");
            System.out.println(ID2);
            ID2 = ID2.replace("/plus/","+");
            ID2 = ID2.replace(" ","");
            String TOKEN = sec.decrypt(ID2);
            String rutaCon = "http://localhost:8084/SASME";
            if(ValTicket(TOKEN, request.getRemoteAddr(), ID)){
                HttpSession ses = request.getSession();
                ses.setAttribute("ID",ID);
                if(tipo==1){
                    ses.setAttribute("Tipo","Jefe_Area");
                    response.sendRedirect(rutaCon+"/consultarDoc.jsp");
                }else if(tipo==2){
                    ses.setAttribute("Tipo","Doctor");
                    response.sendRedirect(rutaCon+"/consulta.jsp");
                }
            }else{
                response.sendRedirect(rutaCon);
            }
        } catch (Exception ex) {
            Logger.getLogger(ValidaAcceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    protected boolean ValTicket(String tickCl,String Adress,String IDU){
        cDatos bd = new cDatos();
        String[] dats = tickCl.split("&");
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        boolean val = false;
        String usr = dats[0];
        String ip=dats[1];
        String ser = dats[2];
        String TS = dats[3];
        int diferencia = ts.compareTo(Timestamp.valueOf(TS));
        int lifeT = Integer.parseInt(dats[4]);
        
        try{
            bd.conectar();
            if(usr.equals(IDU)){
                ResultSet rs = bd.consulta("select IDjefe from Jefe_Area where USUARIO ='"+IDU+"'");
                ResultSet rs2 = bd.consulta("select IDdoctor from Doctores where USUARIO ='"+IDU+"'");
                if(rs.next()){
                    if(ser.equals("Serviker")&&Adress.equals(ip)&&diferencia<=lifeT){
                        tipo=1;
                        val=true;
                    }
                }else if(rs2.next()){
                    if(ser.equals("Serviker")&&Adress.equals(ip)&&diferencia<=lifeT){
                        tipo=2;
                        val=true;
                    }
                }
            }
            bd.cierraConexion();
        }catch(Exception xD){
            System.out.println(xD.getMessage());
        }
        return val;
    }
}
