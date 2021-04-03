public class NodoBT
{
  
    private Object info;
    private NodoBT sinistra;
    private NodoBT destra;
    
    public NodoBT() {}
    
    public NodoBT(Object info)
    {
        this.info = info;
    }
    
    public Object getInfo()
    {
        return info;
    }
    
    public void setInfo(Object i)
    {
        info = i;
    }
    
    public NodoBT getDestra()
    {
        return destra;
    }
    
    public void setDestra(NodoBT d)
    {
        destra = d;
    }
    
    public NodoBT getSinistra()
    {
        return sinistra;
    }
    
    public void setSinistra(NodoBT s)
    {
        sinistra = s;
    }
    
    public int compareTo(NodoBT n)
    {
        String sInfo = info.toString();
        String sN = n.getInfo().toString();
        return sInfo.compareTo(sN);
        // return +: 1^stringa > 2^stringa
        // return 0: 1^stringa = 2^stringa
        // return -: 1^stringa < 2^stringa
    }
}
