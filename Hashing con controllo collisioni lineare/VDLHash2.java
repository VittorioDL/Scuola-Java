import java.lang.String;
import java.lang.Math;

public class VDLHash2
{
    private String cf;

    public VDLHash2(String cf)
    {
        this.cf = cf;
    }
    //consideriamo che la lunghezza massima del codice fiscale sia 16 e che includa solo lettere e numeri
    public int hashing(int dimensione) 
    {
        int hashedString=0; //valore massimo somma caratteri circa 400
        for(int i = 0; i < cf.length(); i++)
        {
            if((int)cf.charAt(i) >= 48 && (int)cf.charAt(i) <= 57) hashedString += (int)cf.charAt(i)-48;
            else if((int)cf.charAt(i) >= 65 && (int)cf.charAt(i) <= 90) hashedString += (int)cf.charAt(i)-64;
            else if((int)cf.charAt(i) >= 97 && (int)cf.charAt(i) <= 122) hashedString += (int)cf.charAt(i)-96;  
        }
        hashedString = Math.abs((int)(Math.log(hashedString*(hashedString%7))*(Math.pow(hashedString%41, (int)hashedString%3)))%dimensione);
        return hashedString;
    }
}
