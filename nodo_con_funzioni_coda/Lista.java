public class Lista
{
    Nodo testa;
    public Lista()
    {
        testa = null;
    }
    
    public Lista(Nodo t)
    {
        testa = t;
    }   
    
    public Nodo getTesta()
    {
        return testa;   
    }
    
    public Nodo getCoda()
    {
        if(!isEmpty())
        {
            Nodo n = testa;
            while(n.getSuccessivo() != null) n = n.getSuccessivo();
            return n;
        }
        else return testa;
    }
    
    public void cancellaCoda()
    {
        if(testa.getSuccessivo() == null) testa = testa.getSuccessivo();
        else if(!isEmpty())
        {
            Nodo n = testa;
            while(n.getSuccessivo().getSuccessivo() != null) n = n.getSuccessivo();
            n.setSuccessivo(null);
        }
    }
    
    public void inserisciInCoda(Nodo newCoda)
    {
        if(!isEmpty())
        {
            Nodo n = testa;
            while(n.getSuccessivo() != null) n = n.getSuccessivo();
            n.setSuccessivo(newCoda);
        }
        else testa = newCoda;
    }
    
    public void inserisciInTesta(Nodo n)
    {
        n.setSuccessivo(testa);
        testa = n;
    }
    
    public void cancellaTesta()
    {
        if(!isEmpty())
        {
            testa = testa.getSuccessivo();
        }
    }
    
    public boolean isEmpty()
    {
        if(testa == null) return true;
        else return false;
    }
}