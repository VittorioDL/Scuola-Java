public class Nodo 
{
    public Object informazione;
    public Nodo successivo;
    
    public Nodo(Object informazione, Nodo successivo)
    {
       this.informazione = informazione;
       this.successivo = successivo; 
    }
    
    public Nodo(Object informazione)
    {
       this.informazione = informazione;
    }
    
    public void setO(Object informazione)
    {
       this.informazione = informazione;
    }
    
    public void setSuccessivo(Nodo successivo)
    {
       this.successivo = successivo;
    }
    
    public Object getInformazione()
    {
       return informazione;
    }
   
    public Nodo getSuccessivo()
    {
       return successivo;
    }
}
