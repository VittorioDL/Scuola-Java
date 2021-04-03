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
    
    public void inserisciInTesta(Nodo n)
    {
        n.setSuccessivo(testa);
        testa = n;
    }
    
    public void cancellaTesta()
    {
        if(testa != null)
        {
            testa = testa.getSuccessivo();
        }
    }
}