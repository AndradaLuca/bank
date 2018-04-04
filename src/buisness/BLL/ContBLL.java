package buisness.BLL;

import data.dao.ContStatement;
import data.dao.UserStatement;
import buisness.model.Cont;

import javax.swing.*;
import java.util.List;

public class ContBLL {

    private ContStatement contStatement;
    private RaportBLL raportBLL;

    public ContBLL() {
        contStatement = new ContStatement();
        raportBLL= new RaportBLL();
    }

    public void insertCont(int idCont, int idClient, int tip, int suma, String data) {
        Cont cont = new Cont(idCont, idClient, tip, suma, data);
        contStatement.insertCont(cont);
        String actiune="A fost introdus Clientului cu id-ul: " + idClient + " contul cu id-ul";
        raportBLL.insert(UserStatement.id,actiune);
    }

    public void deleteCont(int id) {

        contStatement.deleteCont(id);
        String actiune="A fost sters contul cu id-ul " + id;
        raportBLL.insert(UserStatement.id,actiune);
    }

    public List<Cont> getAll() {
        String actiune="Au fost vizualizate conturile";
        raportBLL.insert(UserStatement.id,actiune);
        return contStatement.getAll();

    }

    public void update(int id, int suma, int tip, String data)
    {
        contStatement.updateCont(id,suma,tip,data);
        String actiune="S-a facut update la contul cu id-ul" + id + " cu suma de " + suma + " cu tipul " + tip + " cu data "+ data;
        raportBLL.insert(UserStatement.id,actiune);
    }

    public void transferaBani(int idCont1,int idCont2, int suma)
    {
            int suma1=contStatement.cauta(idCont1);
            int sumat=suma1-suma;
            if(sumat>0){
            contStatement.updateSuma(idCont1,sumat);}
            else
                if(sumat<=0){
                contStatement.updateSuma(idCont1,0);}
            int sumaf=suma +contStatement.cauta(idCont2);
            contStatement.updateSuma(idCont2,sumaf);
        String actiune="A fost efectuat transferul din contul cu id-ul" +idCont1 +" in contul cu id-ul" + idCont2 + " cu suma de " + suma;
        raportBLL.insert(UserStatement.id,actiune);
    }

    public void utilitati(int id)
    {
        if(contStatement.tip(id,1)>0  & (contStatement.tip(id,3)>0))
        {
            transferaBani(contStatement.tip(id,1),contStatement.tip(id,3),(contStatement.cauta(contStatement.tip(id,1)))/10);
            String actiune="Plata utilitatilor efectuata de contul cu id-ul "+ id;
            raportBLL.insert(UserStatement.id,actiune);
            JOptionPane.showMessageDialog(null,"Plata efectuata");
        }else
        if(contStatement.tip(id,2)>0  & (contStatement.tip(id,3)>0))
        {
            transferaBani(contStatement.tip(id,2),contStatement.tip(id,3),(contStatement.cauta(contStatement.tip(id,2)))/10);
            JOptionPane.showMessageDialog(null,"Plata efectuata");
            String actiune="Plata utilitatilor efectuata de contul cu id-ul "+ id;
            raportBLL.insert(UserStatement.id,actiune);
        }

        else JOptionPane.showMessageDialog(null,"Nu exista cont pentru utilitati");
    }


}
