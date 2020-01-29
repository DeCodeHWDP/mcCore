package pl.gr4ss.core.object;

public class User {

    private String nick;
    private boolean incognito;

    public User(final String p){
        nick = p;
        incognito = false;
    }
    public String getName(){
        return nick;
    }
    public boolean getIncognito(){
        return incognito;
    }
    public void setIncognito(final Boolean b){
        incognito = b;
    }
}
