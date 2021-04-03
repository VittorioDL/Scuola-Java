public class Coda extends Lista
{
    public Coda() {}
    
    public Coda(Nodo t)
    {
        testa = t;
    }
    
    public void enqueue(Nodo t)
    {
        inserisciInTesta(t);
    }
    
    public Nodo dequeue()
    {
        Nodo t = super.getCoda();
        cancellaCoda();
        return t;
    }
    
}