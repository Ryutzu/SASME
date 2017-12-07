/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sonia
 */
public class nConsulta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        
       cConsulta con = new cConsulta();
        String nombrePaciente = "Crush";
        String usuarioDoctor = "DMB_Doc";
        String nombreDoctor = "David Madrigal Buendia";
        String tipoConsulta = "normal";        
        String cedulaProfesional = "pppppppppppxxxxx";        
        String nssPaciente = "0123456789";
        
        float peso = Float.parseFloat(request.getParameter("peso"));
        float talla = Float.parseFloat(request.getParameter("talla"));
        float perimetro = Float.parseFloat(request.getParameter("abdominal"));
        float temp = Float.parseFloat(request.getParameter("temperatura"));
        float tension = Float.parseFloat(request.getParameter("arterial"));
        String grupoSan = request.getParameter("sangre");
        String rh = request.getParameter("rh");
        String agudezaVisual = request.getParameter("vista");
        String observaciones = request.getParameter("observaciones");
        String onico = request.getParameter("onicomicosis");
        boolean onicomicosis = true;
        int fc = Integer.parseInt(request.getParameter("fc"));
        int fr = Integer.parseInt(request.getParameter("fr"));
        int pulso = Integer.parseInt(request.getParameter("pulso"));
        
        if (onico.equalsIgnoreCase("no")){
            onicomicosis = false;
        }
        else{
            onicomicosis = true;
        }
        
//        Conectamos a la base
        con.insertaConsultaDatosBasicos(nombreDoctor, usuarioDoctor, nombrePaciente, nssPaciente, cedulaProfesional);
//        
        con.insertaConsultaDatosProfundos(peso, talla, perimetro, fc, fr, temp, tension, pulso,
                                          grupoSan, rh, agudezaVisual, observaciones, onicomicosis);

response.sendRedirect("consulta.jsp");
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


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs

   

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
  
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
