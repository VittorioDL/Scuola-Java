public class Segmento
{
    private double x1, y1, x2, y2;

    public Segmento(double a1, double o1, double a2, double o2)
    {
        x1 = a1;
        y1 = o1;
        x2 = a2;
        y2 = o2;
    }

    public double distanza()
    {
       return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }
}
