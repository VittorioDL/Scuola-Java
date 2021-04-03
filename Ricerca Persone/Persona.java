public class Persona
{
    private String nome;
    private String cognome;
    private String cf;
    private int annoNascita;
    private int meseNascita;
    private int giornoNascita;
    
    public Persona() {}
    
    public Persona(String nome, String cognome, String cf, int annoNascita,int meseNascita, int giornoNascita)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.annoNascita = annoNascita;
        this.meseNascita = meseNascita;
        this.giornoNascita = giornoNascita;
    }
    
    public void visualizzaInformazioni()
    {
        System.out.println("Nome: "+nome+"\nCognome: "+cognome+"\nCodice fiscale: "+cf+
                           "\nData nascita: "+giornoNascita+"/"+meseNascita+"/"+annoNascita);
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public String getCognome()
    {
        return cognome;
    }
    
    public String getCF()
    {
        return cf;
    }
    
    public int getAnno()
    {
        return annoNascita;
    }
    
    public int getMese()
    {
        return meseNascita;
    }
    
    public int getGiorno()
    {
        return giornoNascita;
    }
}
