public class Triangolo
{
    private Segmento l1;
    private Segmento l2;
    private Segmento l3;

    public Triangolo(Segmento l1, Segmento l2, Segmento l3)
    {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }
    
    public double Perimetro()
    {
        return l1.distanza() + l2.distanza() + l3.distanza();
    }

    public double Area()
    {
       return Math.sqrt(Perimetro()/2*(Perimetro()/2-l1.distanza())*(Perimetro()/2-l2.distanza())*(Perimetro()/2-l3.distanza()));
    }
}
