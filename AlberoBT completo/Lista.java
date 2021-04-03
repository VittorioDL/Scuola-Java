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
    
    public int getSize()
    {
        if(isEmpty()) return 0;
    
        else 
        {
            int num = 1;
            Nodo n = testa;
            while(n.getSuccessivo() != null)
            {
                n = n.getSuccessivo();
                num++;
            }
            return num;
        }
    }
    
    public Nodo getInPosizione(int index)
    {
        if(index > getSize()-1 || index < 0) return null;
        else
        {
            Nodo n = testa;
            for(int i = 1; i<=index; i++) n = n.getSuccessivo();
            
            return n;
        }
    }
    
    public void inserisciInPosizione(int index, Nodo nodo)
    {
        if(index > getSize()-1 || index < 0) System.out.println("Index out of bound");
        else if(index == 0) inserisciInTesta(nodo);
        else if(index == getSize()-1) inserisciInCoda(nodo);
        else
        {
            Nodo n = testa;
            for(int i = 1; i<index-1; i++) n = n.getSuccessivo();
            
            Nodo nodoSuccessivoAlNuovo = n.getSuccessivo();
            n.setSuccessivo(nodo);
            nodo.setSuccessivo(nodoSuccessivoAlNuovo);
        }
    }
    
    public void rimuoviInPosizione(int index)
    {
        if(index > getSize()-1 || index < 0) System.out.println("Index out of bound");
        
        else if(index == 0) cancellaTesta();
        else if(index == getSize()-1) cancellaCoda();
        else
        {
            Nodo n = testa;
            for(int i = 1; i<index-1; i++) n = n.getSuccessivo();
            
            Nodo nodoSuccessivo = n.getSuccessivo().getSuccessivo();
            n.setSuccessivo(nodoSuccessivo);
            
        }
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
    
    public void concatena(Lista l)
    {
        getCoda().setSuccessivo(l.getTesta());
    }
    
    public void concatenaInPosizione(Lista l, int index)
    {
        if(!isEmpty())
        {
            Nodo n = testa;
            for(int i = 1; i<index; i++) n = n.getSuccessivo();
            n.setSuccessivo(l.getTesta());
        }
    }
    
    public int posizioneNodo(Object o)
    {
        int cont = 1;
        Nodo n = testa;
        
        if(testa.getInformazione() == o) return 0;
        while(n.getSuccessivo().getInformazione() != o)
        {
            n = n.getSuccessivo();
            cont++;
        }
       
        return cont;
    }
    
    public void clear()
    {
        testa = null;
    }
}