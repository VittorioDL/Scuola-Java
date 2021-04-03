public class Poligonale
{
    public Punto[] punti;
    
    public Poligonale(Punto[] punti)
    {
        this.punti = punti;
    }
    
    public double lunghezza()
    {
       double l=0;
       int n = punti.length;
       for(int i = 0; i < n-1; i++)
       {
           l += punti[i].distanza2Punti(punti[i+1]);
       }
       
       l += punti[0].distanza2Punti(punti[n-1]);
       return l;
    }
}