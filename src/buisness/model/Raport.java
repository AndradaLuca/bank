package buisness.model;

public class Raport {
    private int idRaport;
    private int idAngajat;
    private String data;
    private String actiune;


    public Raport() {
    }

    public Raport(int idRaport, int idAngajat, String data, String actiune) {
        this.idRaport = idRaport;
        this.idAngajat = idAngajat;
        this.data = data;
        this.actiune = actiune;
    }

    public int getIdRaport() {
        return idRaport;
    }

    public void setIdRaport(int idRaport) {
        this.idRaport = idRaport;
    }

    public int getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getActiune() {
        return actiune;
    }

    public void setActiune(String actiune) {
        this.actiune = actiune;
    }
}
