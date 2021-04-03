import java.io.*;
public class Main
{
    public static void main(String[] args) throws Exception
    {
       InputStreamReader in = new InputStreamReader(System.in);
       BufferedReader tastiera = new BufferedReader(in);
       
       System.out.println("Inserire numero punti da creare: ");
       int n = Integer.parseInt(tastiera.readLine());
       
       Punto[] p = new Punto[n];
       
       for(int i = 0; i< n; i++)
       {
           System.out.println("\nInserire coordinate x del punto " + i + ": ");
           int x = Integer.parseInt(tastiera.readLine());
           System.out.println("Inserire coordinate y del punto " + i + ": ");
           int y = Integer.parseInt(tastiera.readLine());
       
           p[i] = new Punto(x, y);
       }
       Poligonale poli = new Poligonale(p);
       System.out.println("Lunghezza poligonale: "+poli.lunghezza());   
    }
}