public class Pila extends Lista
{
    public Pila() {}
    
    public Pila(Nodo t)
    {
        testa = t;
    }
    
    public void push(Nodo t)
    {
        inserisciInCoda(t);    
    }
    
    public Nodo pop()
    {
        Nodo t = getCoda();
        cancellaCoda();
        return t;
    }
}