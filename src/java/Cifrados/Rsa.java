
package Cifrados;

import java.math.BigInteger;
import BD.cBase;
/**
 *
 * @author Touchier
 */
public class Rsa {
    String msj, clavePrivada;
    public Rsa(String xd) {
        clavePrivada= "";
        msj= "";
        cCifra cifra= new cCifra(4);
        cifra.GeneraClaves();
        BigInteger[] big= cifra.Encripta(xd);
        for(int i= 0; i < big.length; i++){
            if((i+1) != big.length){
                clavePrivada+= big[i] + " "; 
            }else{
                clavePrivada+= big[i]; 
            }
        }
        System.out.println("");
        
        cBase base= new cBase();
        base.setBase("claves");
        
        try{
            base.Conecta();
            base.inserta(clavePrivada, cifra.getD(), cifra.getN());
        }catch(Exception e){
            System.out.println(e);
            
            System.out.println(cifra.getD());
            System.out.println(cifra.getN());
            System.out.println(clavePrivada);
        }
        try{
            base.select();
            msj= cifra.Desencriptar(base.getPrivate(), base.getNumE(), base.getNumN());
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public String getMSJ(){
        return this.msj;
    }
    public String getPrivada(){
        return this.clavePrivada;
    }
    
}
