package buisness.BLL;

import data.dao.RaportStatement;
import buisness.model.Raport;
import data.dao.UserStatement;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RaportBLL {

    private RaportStatement raportStatement = new RaportStatement();
    private UserStatement user = new UserStatement();

    public void insert(int idAng, String actiune) {
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        Date d = new Date();
        String time = data.format(d);
        Raport raport = new Raport(1, idAng, time, actiune);
        raportStatement.insertRaport(raport);
    }

    public List<String> cauta(String nume, String data) {
        int idangajat = user.cautaNume(nume);
        if (idangajat == 0) {
            JOptionPane.showMessageDialog(null, "The " + nume + " do not exists");
        }
            return raportStatement.cauta(idangajat, data);

    }

}
