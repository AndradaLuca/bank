package buisness.model;

public class User {

    private int idUser;
    private String username;
    private String pass;
    private int tip;
    private String nume;
    private String adresa;


    public User() {

    }

    public User(int idUser, String username, String pass, int tip, String nume, String adresa) {
        this.idUser = idUser;
        this.username = username;
        this.tip = tip;
        this.nume = nume;
        this.adresa = adresa;
        this.pass = pass;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return this.pass;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return this.nume;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getIdUser()
    {
        return this.idUser;
    }

    public int getTip() {
        return this.tip;
    }

    public String getAdresa() {
        return this.adresa;
    }


    public String toString() {
        return "Userul cu numele " + getNume() + " are username-ul " + getUsername() + " si parola " + getPass() + " are contul de tipul " + this.tip + " cu adresa " + getAdresa();
    }

}
