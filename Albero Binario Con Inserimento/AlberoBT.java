public class AlberoBT
{
    public NodoBT Radice;
    public int pos;
    public Lista lista;
    
    public AlberoBT()
    {
        Radice = null;
    }
    
    public AlberoBT(NodoBT r)
    {
        Radice = r;
    }
    
    public void inserisciNodo(NodoBT n)
    {
        if(Radice == null)
        {
            Radice = n;
            return;
        }
        inserisciNodo(n,Radice);
    }
    
    private void inserisciNodo(NodoBT n, NodoBT r)
    {
        if(n.compareTo(r)>0)
        {
            if(r.getDestra()==null) r.setDestra(n);
            else inserisciNodo(n, r.getDestra());
        }
        
        else
        {
            if(r.getSinistra()==null) r.setSinistra(n);
            else inserisciNodo(n, r.getSinistra());
        }
    }
    
    
}