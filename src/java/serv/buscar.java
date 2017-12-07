/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sonia
 */
public class buscar {
    String nombreD = "";
    String nombreP = "";

    
    
    
    public buscar (){
        
    }
    
    public String buscarDoctor(String usr, String psw) throws SQLException{
        BD.cDatos base = new BD.cDatos();
        
        ResultSet rs;
        
        base.conectar();
        rs = base.consulta("SELECT * FROM Doctores where Contraseña ;");
        return null;
    }
    
    
}
