package data.dao;

import buisness.model.Raport;
import data.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RaportStatement {


    public void insertRaport(Raport raport)  {
        try {
            ConnectionFactory c = new ConnectionFactory();
            c.createConnection();
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement posted = con
                    .prepareStatement("INSERT INTO  raport (idraport,idangajat,data,actiune) values ('"
                            + 0 + "','" + raport.getIdAngajat() + "','" +raport.getData() + "','"
                            + raport.getActiune()  + "')");
            posted.executeUpdate();
            c.close();
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public  List<String> cauta(int idAngajat,String data) {
        List<String> lista = new ArrayList<String>();
        String findStatementString = "SELECT * FROM raport where idangajat = ? and data =?";
        ConnectionFactory c = new ConnectionFactory();
        c.createConnection();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, idAngajat);
            findStatement.setString(2, data);
            rs = findStatement.executeQuery();
            while(rs.next())
            {
                lista.add(rs.getString("actiune"));
            }



            // System.out.println("SUMAAAAAA" +suma);


        } catch (SQLException e) {

        }
        c.close();

        return lista;
    }


}
