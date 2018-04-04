package buisness.model;

public class Cont {

    private int idCont;
    private int idClient;
    private int tip;
    private int bani;
    private String data;


    public Cont() {

    }

    public Cont(int idCont, int idClient, int tip, int bani, String data) {
        this.idCont = idCont;
        this.idClient = idClient;
        this.tip = tip;//
        this.bani = bani;
        this.data = data;
    }


    public void setTip(int tip) {
        this.tip = tip;
    }

    public int getTip() {
        return this.tip;
    }

    public void setBani(int suma) {
        this.bani = suma;
    }

    public int getBani() {
        return this.bani;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdClient() {
        return this.idClient;
    }

    public int getIdCont() {
        return this.idCont;
    }

    public String getData() {
        return this.data;
    }

    public String toString() {
        return this.idCont + " " + this.idClient + " " + getTip() + " " + getBani() + " " + getData();
    }

}
