package it.riccardo.app.webapprest.web.exception;

public class NotFoundException extends Exception {

    private static final long serialVersionUID = 7559393781645645348L;

    private String messaggio = "Elemento Ricercato Non Trovato!";

    public NotFoundException()
    {
        super();
    }

    public NotFoundException(String Messaggio)
    {
        super(Messaggio);
        this.messaggio = Messaggio;
    }

    public String getMessaggio()
    {
        return messaggio;
    }

    public void setMessaggio(String messaggio)
    {
        this.messaggio = messaggio;
    }
}
