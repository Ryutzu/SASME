package BD;

import Doctor.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Touchier
 */
public class cConectaBD {
    String _Url, _Driver, _Usser, _Contra;
    Connection _Cont;
    
    public cConectaBD(){
        Inizializa();
    }
    public cConectaBD(String base){
        Inizializa();
        setBase(base);
    }
    
    public void Inizializa(){
        _Usser= "root";
        _Contra= "n0m3l0";
        _Driver= "com.mysql.jdbc.Driver";
        resetBase();
    }
    
    public void resetBase(){
        _Url= "jdbc:mysql://localhost/";
    }
    public void setBase(String base){
        resetBase();
        _Url+= base;
    }
    
    public Connection Conecta(){
        try{
            Class.forName(_Driver).newInstance();
            _Cont= DriverManager.getConnection(_Url,_Usser,_Contra);
        }catch(Exception e){
            System.out.println("Error al conectar a la Base de Datos");
        }
        return (this._Cont);
    }
    
    public Connection cierra(Connection cont){
        try{
            cont.close(); 
        }catch(SQLException e){
            System.out.println("Error al cerrar la conexión");
        }
        return cont;
    }
    public void cierra(){
        try{
            _Cont.close();
        }catch(SQLException e){
            System.out.println("Error al cerrar la conexión");
        }
    }
}
