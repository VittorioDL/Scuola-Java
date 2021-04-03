public class IndicePersona extends NodoBT
{
    private int posInLista;
    private String cf;
    
    public IndicePersona(String cf)
    {
        this.cf = cf;
    }
    
    public IndicePersona(int posInLista)
    {
        this.posInLista = posInLista;
    }
    
    public IndicePersona(int posInLista, String cf)
    {
        this.posInLista = posInLista;
        this.cf = cf;
    }
    
    public int getPosInLista()
    {
        return posInLista;
    }
    
    public String toString()
    {
        return cf;
    }
}
