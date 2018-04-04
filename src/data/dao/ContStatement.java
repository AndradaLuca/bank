package data.dao;

import data.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import buisness.model.Cont;

public class ContStatement {


    public void insertCont(Cont cont)  {
        try {
            ConnectionFactory cc = new ConnectionFactory();
            cc.createConnection();
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement posted = con
                    .prepareStatement("INSERT INTO  cont (idcont,tip,bani,data,idClient) values ('"
                            + cont.getIdCont() + "','" + cont.getTip() + "','" +cont.getBani() + "','"
                            + cont.getData() + "' ,'" + cont.getIdClient() +  "')");
            posted.executeUpdate();
            cc.close();
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteCont(int id) {
        try {
            ConnectionFactory cc = new ConnectionFactory();
            cc.createConnection();
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement posted = con
                    .prepareStatement("DELETE FROM cont WHERE idcont = '" + id + "'");
            posted.executeUpdate();
            cc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void deleteContDupaClient(int id) {
        try {
            ConnectionFactory cc = new ConnectionFactory();
            cc.createConnection();
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement posted = con
                    .prepareStatement("DELETE FROM cont WHERE idClient = '" + id + "'");
            posted.executeUpdate();
            cc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Cont> getAll() {
        List<Cont> list = new ArrayList<Cont>();


        String all = "SELECT * FROM cont ";
        ConnectionFactory cc = new ConnectionFactory();
        cc.createConnection();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = connection.prepareStatement(all);
            rs = st.executeQuery(all);


            while (rs.next()) {
                Cont cont = new Cont(rs.getInt("idcont"),rs.getInt("idClient"),rs.getInt("tip"),rs.getInt("bani"),rs.getString("data"));
                list.add(cont);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        cc.close();
        return list;

    }


    public void updateCont(int idCont,int suma,int tip,String data) {
        try {
            ConnectionFactory c = new ConnectionFactory();
            c.createConnection();
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement posted = connection.prepareStatement(
                    "UPDATE cont SET   tip= ?, data = ?, bani = ? " + " WHERE idcont = ? ");
            posted.setInt(1, tip);
            posted.setString(2, data);
            posted.setInt(3, suma);
            posted.setInt(4, idCont);

            posted.executeUpdate();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateSuma(int idCont,int suma) {
        try {
            ConnectionFactory c = new ConnectionFactory();
            c.createConnection();
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement posted = connection.prepareStatement(
                    "UPDATE cont SET    bani = ? " + " WHERE idcont = ? ");

            posted.setInt(1, suma);
            posted.setInt(2, idCont);

            posted.executeUpdate();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int cauta(int idCont) {
        int suma=0;
        String findStatementString = "SELECT * FROM cont where idcont = ?";
        ConnectionFactory c = new ConnectionFactory();
        c.createConnection();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, idCont);
            rs = findStatement.executeQuery();
            rs.next();

            suma = rs.getInt("bani");
           // System.out.println("SUMAAAAAA" +suma);


        } catch (SQLException e) {

        }
        c.close();

        return suma;
    }


    public int tip(int idClient,int tip) {
        int tipp=0;
        String findStatementString = "SELECT * FROM cont where idClient = ? and tip = ?";
        ConnectionFactory c = new ConnectionFactory();
        c.createConnection();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, idClient);
            findStatement.setLong(2, tip);
            rs = findStatement.executeQuery();
            rs.next();

            tipp = rs.getInt("idcont");
           // System.out.println("SUMAAAAAA" +suma);


        } catch (SQLException e) {

        }
        c.close();

        return tipp;
    }

}
