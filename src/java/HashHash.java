/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Cifrados.Rsa;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

/**
 *
 * @author Alumno
 */
@WebServlet(urlPatterns = {"/HashHash"})
public class HashHash extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String Texto = request.getParameter("Texto");
        Rsa cCifra= new Rsa(Texto);
        String certi= cCifra.getPrivada();
        
        String unido= Texto + "" + certi;
        String nombre= "kheso";
                
        Document documento = new Document(PageSize.LETTER, 35, 30, 50, 50);
        try{
            //FileOutputStream fileOutput = new FileOutputStream("C:\\Users\\david\\Desktop\\ "+ nombre +".pdf");
            FileOutputStream fileOutput = new FileOutputStream("E:\\"+ nombre +".pdf");
            PdfWriter.getInstance(documento, fileOutput);

            documento.open();

            Image imagen;
            imagen = Image.getInstance(getClass().getResource("cecyt9.jpg"));
            imagen.scaleAbsolute(60f, 80f);

            Image imagenB;
            imagenB = Image.getInstance(getClass().getResource("ipn.jpg"));
            imagenB.scaleAbsolute(60f, 80f);
            
            Font fuenteContenido = FontFactory.getFont(FontFactory.HELVETICA.toString(), 12, Font.NORMAL, BaseColor.BLACK);
            Font Titulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD.toString(), 14, Font.UNDERLINE, BaseColor.DARK_GRAY);
            Font subTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD.toString(), 15, Font.NORMAL, BaseColor.DARK_GRAY);
            Font ipn = FontFactory.getFont(FontFactory.HELVETICA_BOLD.toString(), 14, Font.NORMAL, BaseColor.DARK_GRAY);
            Font cecyt = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE.toString(), 14, Font.NORMAL, BaseColor.DARK_GRAY);
            
            PdfPTable table = new PdfPTable(6);

            Paragraph para = new Paragraph();
            para.add(new Phrase("INSTITUTO POLITÉCNICO NACIONAL", ipn));
            
            para.add(new Phrase("\nCENTRO DE ESTUDIOS CIENTÍFICOS Y TECNOLÓGICOS N° 9", cecyt));
            para.add(new Phrase("\n\"JUAN DE DIOS BÁTIZ\"", cecyt));
            
            PdfPCell cell = new PdfPCell(imagen);
            PdfPCell cell3 = new PdfPCell(para);
            PdfPCell cell4 = new PdfPCell();
            PdfPCell cell2 = new PdfPCell(imagenB);

            cell.setBorderColor(BaseColor.WHITE);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            
            cell2.setBorderColor(BaseColor.WHITE);
            cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell3.setBorderColor(BaseColor.WHITE);
            cell3.setVerticalAlignment(Element.ALIGN_TOP);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setColspan(4);
            
            cell4.setBorderColor(BaseColor.WHITE);

            //cell2.addElement(new Phrase("Servicio Medico", fuenteContenido));
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell);
            table.addCell(cell);
            table.addCell(cell);
            table.addCell(cell);
            
            

            documento.add(table);

            Paragraph parrafo = new Paragraph();
            parrafo.add(new Phrase("Servicio Medico", Titulo));
            parrafo.add(new Phrase(Chunk.NEWLINE));
            parrafo.add(new Phrase(Chunk.NEWLINE));
            documento.add(parrafo);
            
            Paragraph parrafo3 = new Paragraph();
            parrafo3.add(new Phrase("Texto: ",subTitulo));
            parrafo3.add(new Phrase(Chunk.NEWLINE));
            parrafo3.add(new Phrase(Texto,fuenteContenido));
            documento.add(parrafo3);
            
            Paragraph parrafo4 = new Paragraph();
            parrafo4.add(new Phrase("Certificado: ",subTitulo));
            parrafo4.add(new Phrase(Chunk.NEWLINE));
            parrafo4.add(new Phrase(certi,fuenteContenido));
            documento.add(parrafo4);
            //Cerramos el documento
            documento.close();
            //Y lo abrimos para el usuario
//            File archivo = new File("reporteMaleta" + this._codBoleto + ".pdf");
//            Desktop.getDesktop().open(archivo);
        }catch(Exception e){
            System.out.println("Error");
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HashHash </title>");   
            out.println("<script type='text/javascript' src='https://code.jquery.com/jquery-1.11.3.min.js'></script>");
            out.println("<script src=\"jspdf.min.js\"></script>");
            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> cifra:"+ certi +" </h1>");
            out.println("<h1> "+ Texto +" </h1>");
            /*out.println("<script>var doc = new jsPDF();");
            out.println("doc.setFontSize(16);");
            out.println("doc.text(10, 10, \""+ Texto +"\");");
            out.println("doc.text(10, 50, \""+ certi +"\");");
            out.println("doc.save('kheso.pdf');");
            */
            out.println("<script> alert('Guardado');");
            out.println("location.href='/Servicio2/principal.jsp';</script>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception xxxD){
            
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

}
