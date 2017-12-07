package Cifrados;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Touchier
 */
public class cCifra {
    int primo;
    BigInteger p, q, n;
    BigInteger phi, e, d;
    
    public cCifra(int tamanioPrimo){
        this.primo= tamanioPrimo;
        GeneraPrimos();
    }
    
    public cCifra(int tamanioPrimo, BigInteger P, BigInteger Q){
        this.primo= tamanioPrimo;
        this.p= P;
        this.q= Q;
        GeneraClaves();
    }
    
    public void GeneraPrimos(){
        p= new BigInteger(primo, 10, new Random());
        do{
            q= new BigInteger(primo, 10, new Random());
        }while(q.compareTo(p) == 0);
    }
    
    public void GeneraClaves(){
        n= p.multiply(q);
        phi= (p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1))));
    
        do{
            e= new BigInteger(2 * primo, new Random());
        }while((e.compareTo(phi) != -1) || (e.gcd(phi).compareTo(BigInteger.valueOf(1)) != 0));
        d= e.modInverse(phi);
    }
    
    public BigInteger[] Encripta (String msj){
        int i;
        byte[] temp= new byte[1];
        byte[] digitos= msj.getBytes();
        BigInteger[] bigDigitos= new BigInteger[digitos.length];
        
        for(i= 0; i < bigDigitos.length; i++){
            temp[0]= digitos[i];
            bigDigitos[i]= new BigInteger(temp);
        }
        
        BigInteger[] encriptado= new BigInteger[bigDigitos.length];
        for(i= 0; i < bigDigitos.length; i++){
            encriptado[i]= bigDigitos[i].modPow(e, n);
        }
        return (encriptado);
    }
    
    public String Desencriptar(BigInteger[] msjEncrip){
        BigInteger[] desencriptado= new BigInteger[msjEncrip.length];
        
        for(int i= 0; i < msjEncrip.length; i++){
            desencriptado[i]= msjEncrip[i].modPow(d, n);
        }
        
        char[] caracteres= new char[desencriptado.length];
        
        for(int i= 0; i < caracteres.length; i++){
            caracteres[i]= (char)desencriptado[i].intValue();
        }
        
        return (new String(caracteres));
    }
    
    public String Desencriptar(BigInteger[] msjEncrip, BigInteger e, BigInteger d){
        setD(d);
        setE(e);
        BigInteger[] desencriptado= new BigInteger[msjEncrip.length];
        
        for(int i= 0; i < msjEncrip.length; i++){
            desencriptado[i]= msjEncrip[i].modPow(this.d, this.e);
        }
        
        char[] caracteres= new char[desencriptado.length];
        
        for(int i= 0; i < caracteres.length; i++){
            caracteres[i]= (char)desencriptado[i].intValue();
        }
        
        return (new String(caracteres));
    }
    
    public void setD(BigInteger d){
        this.n= d;
    }
    public void setE(BigInteger e){
        this.e= e;
    }
    
    
    public BigInteger getP(){return this.p;}
    public BigInteger getQ(){return this.q;}
    public BigInteger getPhi(){return this.phi;}
    public BigInteger getE(){return this.e;}
    public BigInteger getD(){return this.d;};
    public BigInteger getN(){return this.n;};
}
