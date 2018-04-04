package data.dao;

import data.connection.ConnectionFactory;
import buisness.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserStatement {

    public static int id;

    public void insertUser(User user)  {
        try {
            ConnectionFactory c = new ConnectionFactory();
            c.createConnection();
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement posted = con
                    .prepareStatement("INSERT INTO  user (iduser,username,password,tip,nume,adresa) values ('"
                            + 0 + "','" + user.getUsername() + "','" + user.getPass() + "','"
                            + user.getTip() + "' ,'" + user.getNume() + "' ,'" + user.getAdresa() + "')");
            posted.executeUpdate();
            c.close();
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            ConnectionFactory c = new ConnectionFactory();
            c.createConnection();
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement posted = con
                    .prepareStatement("DELETE FROM user WHERE iduser = '" + id + "'");
            posted.executeUpdate();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();


        }
    }


    public  int cauta(String user,String pass) {



        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query ="SELECT * FROM user where username = ? and password = ?";
        ConnectionFactory c = new ConnectionFactory();
        c.createConnection();
        int ok=0;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,user);
            statement.setString(2,pass);
            resultSet = statement.executeQuery();
            resultSet.next();
             ok=resultSet.getInt(4);
            if(ok==1)
            {
                id=resultSet.getInt(1);
            }

        } catch (SQLException e) {

        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
            ConnectionFactory.close();
        }


        return ok ;
    }

    public  int cautaNume(String user) {



        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query ="SELECT * FROM user where username = ?";
        ConnectionFactory c = new ConnectionFactory();
        c.createConnection();
        int ok=0;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,user);
            resultSet = statement.executeQuery();
            resultSet.next();
            ok=resultSet.getInt(4);
            if(ok==1)
            {
                id=resultSet.getInt(1);
            }

        } catch (SQLException e) {

        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
            ConnectionFactory.close();
        }


        return ok ;
    }


    public List<User> getAll() {
        List<User> list = new ArrayList<User>();

        ConnectionFactory c = new ConnectionFactory();
        c.createConnection();
        String all = "SELECT * FROM user ";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = connection.prepareStatement(all);
            rs = st.executeQuery(all);


            while (rs.next()) {
               User user = new User(rs.getInt("iduser"),rs.getString("username"),rs.getString("password"),rs.getInt("tip"),rs.getString("nume"),rs.getString("adresa"));
                list.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            c.close();
        return list;

    }

    public void updateUser(String nume,String adresa,int idUser) {
        try {
            ConnectionFactory c = new ConnectionFactory();
            c.createConnection();
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement posted = connection.prepareStatement(
                    "UPDATE user SET   nume= ?, adresa = ? " + " WHERE iduser = ? ");
            posted.setString(1, nume);
            posted.setString(2, adresa);
            posted.setInt(3, idUser);


            posted.executeUpdate();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
