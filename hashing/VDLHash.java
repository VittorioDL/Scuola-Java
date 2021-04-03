import java.lang.String;
import java.lang.Math;

public class VDLHash
{
    private String cf;

    public VDLHash(String cf)
    {
        this.cf = cf;
    }
    //consideriamo che la lunghezza massima del codice fiscale sia 16 e che includa solo lettere e numeri
    public int hashing() 
    {
        int hashedString=0; //valore massimo somma caratteri circa 400
        for(int i = 0; i < cf.length(); i++)
        {
            if((int)cf.charAt(i) >= 48 && (int)cf.charAt(i) <= 57) hashedString += (int)cf.charAt(i)-48;
            else if((int)cf.charAt(i) >= 65 && (int)cf.charAt(i) <= 90) hashedString += (int)cf.charAt(i)-64;
            else if((int)cf.charAt(i) >= 97 && (int)cf.charAt(i) <= 122) hashedString += (int)cf.charAt(i)-96;  
        }
        System.out.println("somma: "+ hashedString);
        hashedString = Math.abs((int)(Math.log(hashedString)*(Math.pow(hashedString%41, (int)hashedString%3))));
        return hashedString;
    }
    
}
