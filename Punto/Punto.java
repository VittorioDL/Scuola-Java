public class Punto
{
    private double X;
    private double Y;
    
    public Punto(double ascissa, double ordinata)
    {
        X = ascissa;
        Y = ordinata;
    }
    
    public double distanza2Punti(Punto p2)
    {
        return Math.sqrt((X-p2.X)*(X-p2.X)+(Y-p2.Y)*(Y-p2.Y));
    }
    
    public void setX(double ascissa)
    {
        X = ascissa;
    }
    
    public void setY(double ordinata)
    {
        Y = ordinata;
    }
    
    public double getX()
    {
        return X;
    }
    
    public double getY()
    {
        return Y;
    }

    public double distanzaDaOrigine()
    {
        return Math.sqrt(X*X+Y*Y);
    }
}
