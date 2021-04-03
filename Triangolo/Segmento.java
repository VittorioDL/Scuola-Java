public class Segmento
{
    private Punto p1;
    private Punto p2;

    public Segmento(Punto p1, Punto p2)
    {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double distanza()
    {
       return p1.distanza2Punti(p2);
    }
}

