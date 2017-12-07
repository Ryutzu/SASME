package BD;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author Touchier
 */
public class cBase {
    String _Url, _Driver, _Usser, _Contra;
    Connection _Cont;
    Statement _Stat;
    ResultSet _Resul;
    BigInteger[] privada;
    BigInteger numN, numE;
    
    public cBase(){
        _Usser= "root";
        _Contra= "n0m3l0";
        resetBase();
        _Driver= "com.mysql.jdbc.Driver";
    }
    
    public void resetBase(){
        _Url= "jdbc:mysql://localhost/";
    }
    public void setBase(String base){
        resetBase();
        _Url+= base;
    }
    
    public void Conecta() throws Exception{
        Class.forName(_Driver).newInstance();
        _Cont= DriverManager.getConnection(_Url,_Usser,_Contra);
    }
    public void CreaTabla() throws SQLException{
        _Stat= _Cont.createStatement();
        _Stat.execute("CREATE DATABASE kk");
    }
    public void inserta(String clave, BigInteger d, BigInteger n) throws SQLException{
        _Stat= _Cont.createStatement();
        _Stat.execute("INSERT INTO claves VALUES(null,'"+ clave +"','"+ d +"','"+n+"')");
    }
    public void select() throws SQLException{
        _Stat= _Cont.createStatement();
        _Resul= _Stat.executeQuery("SELECT * FROM claves;");
        
        String clave= "";
        int i= 0;
        while(_Resul.next()){
           clave= _Resul.getString("privatekey");
           numN= new BigInteger(_Resul.getString("NumD"));
           numE= new BigInteger(_Resul.getString("NumN"));
           i++;
        }
        
        String[] clavePrivada= clave.split(" ");
        privada= new BigInteger[clavePrivada.length];
        
        for(int io= 0; io < clavePrivada.length; io++){
            privada[io]= new BigInteger(clavePrivada[io]);
        }
    }
    
    public BigInteger[] getPrivate(){
        return privada;
    }
    public BigInteger getNumN(){
        return this.numN;
    }
    public BigInteger getNumE(){
        return this.numE;
    }
}
