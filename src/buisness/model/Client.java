package buisness.model;

public class Client {


    private int idClient;
    private String nume;
    private String serie;
    private String cnp;
    private String adresa;
    private String telefon;

    public Client() {

    }

    public Client(int idClient, String nume, String serie, String cnp, String adresa, String telefon) {
        this.idClient = idClient;
        this.nume = nume;
        this.serie = serie;
        this.cnp = cnp;
        this.adresa = adresa;
        this.telefon = telefon;
    }


    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return this.nume;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getCnp() {
        return this.cnp;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getAdresa() {
        return this.adresa;
    }

    public int getIdClient()
    {
        return this.idClient;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getTelefon() {
        return this.telefon;
    }


    public String toString() {
        return getIdClient() + " " + getNume() + " " + getCnp() + " " + getSerie() + " " + getAdresa() + " " + getTelefon();
    }

}
