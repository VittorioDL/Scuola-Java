public class ProntoSoccorso 
{  
    public Coda r;
    public Coda y;
    public Coda w;
    
    public ProntoSoccorso() {}
    
    public ProntoSoccorso(Coda r, Coda y, Coda w) 
    {
        this.r = r;
        this.y = y;
        this.w = w;
        //r.concatenaCoda(y);
        //y.concatenaCoda(w);
    }
    
    public boolean isEmpty()
    {
        if((getSize()) == 0) return true;
        else return false;
    }
    
    public int getSize() {return getSizeR() + getSizeY() +getSizeW();}
    public int getSizeR()
    {
        if(r.isEmpty()) return 0;
        else 
        {
            int num = 1;
            Nodo n = r.getTesta();
            while(n.getSuccessivo() != null)
            {
                n = n.getSuccessivo();
                num++;
            }
            return num;
        }
    }
    
    public int getSizeY()
    {
        if(y.isEmpty()) return 0;
        else 
        {
            int num = 1;
            Nodo n = y.getTesta();
            while(n.getSuccessivo() != null)
            {
                n = n.getSuccessivo();
                num++;
            }
            return num;
        }
    }
    
    public int getSizeW()
    {
        if(w.isEmpty()) return 0;
        else 
        {
            int num = 1;
            Nodo n = w.getTesta();
            while(n.getSuccessivo() != null)
            {
                n = n.getSuccessivo();
                num++;
            }
            return num;
        }
    }
    
    public void aggiungiPaziente(Nodo n, int colore)
    {
        if(colore == 1) r.enqueue(n);
        if(colore == 2) y.enqueue(n);
        if(colore == 3) w.enqueue(n);
    }
    
    public Nodo pazienteConPriorita()
    {
        if(!r.isEmpty()) return r.dequeue();
        else if(!y.isEmpty()) return y.dequeue();
        else if(!w.isEmpty())return w.dequeue();
        else return null;
    }
    
    public boolean rimuoviPazienteR(String nominativo)
    {
        Nodo n = r.getTesta();
        if(!r.isEmpty())
        {
            if(n.getInformazione().equals(nominativo))
            {
                r.cancellaTesta();
                return true;
            }
            
            else 
            {
                while(n.getSuccessivo() != null)
                {
                    if(n.getSuccessivo().getInformazione().equals(nominativo))
                    {
                        n.setSuccessivo(n.getSuccessivo().getSuccessivo());
                        return true;
                    }
                    n = n.getSuccessivo();
                }
            }
        }
        return false;
    }
    
    public boolean rimuoviPazienteY(String nominativo)
    {
        Nodo n = y.getTesta();
        if(!y.isEmpty())
        {
            if(n.getInformazione().equals(nominativo))
            {
                y.cancellaTesta();
                return true;
            }
            else 
            {
                while(n.getSuccessivo() != null)
                {
                    if(n.getSuccessivo().getInformazione().equals(nominativo))
                    {
                        n.setSuccessivo(n.getSuccessivo().getSuccessivo());
                        return true;
                    }
                    n = n.getSuccessivo();
                }
            }
        }
        return false;
    }
    
    public boolean rimuoviPazienteW(String nominativo)
    {
        Nodo n = w.getTesta();
        if(!w.isEmpty())
        {
            if(n.getInformazione().equals(nominativo))
            {
                w.cancellaTesta();
                return true;
            }
            else 
            {
                while(n.getSuccessivo() != null)
                {
                    if(n.getSuccessivo().getInformazione().equals(nominativo))
                    {
                        n.setSuccessivo(n.getSuccessivo().getSuccessivo());
                        return true;
                    }
                    n = n.getSuccessivo();
                }
            }
        }
        return false;
    }
}