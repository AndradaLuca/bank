package data.dao;

import data.connection.ConnectionFactory;
import buisness.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ClientStatement {


    protected static final Logger LOGGER = Logger.getLogger(ClientStatement.class.getName());

    public ClientStatement()
    {

    }

    public void insertClient(Client client)  {
        try {
            ConnectionFactory cc = new ConnectionFactory();
            cc.createConnection();
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement posted = con
                    .prepareStatement("INSERT INTO  client (idclient,nume,serie,cnp,adresa,telefon) values ('"
                            + 0 + "','" + client.getNume() + "','" + client.getSerie() + "','"
                            + client.getCnp() + "' ,'" + client.getAdresa() + "' ,'" + client.getTelefon() + "')");
            posted.executeUpdate();
            cc.close();
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteClient(int idClient) {


        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement posted = con
                    .prepareStatement("DELETE FROM client WHERE idclient = '" + idClient + "'");
            posted.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Client> getAll() {
        List<Client> list = new ArrayList<Client>();

        ConnectionFactory c = new ConnectionFactory();
        c.createConnection();
        String all = "SELECT * FROM client ";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = connection.prepareStatement(all);
            rs = st.executeQuery(all);


            while (rs.next()) {
                Client client = new Client(rs.getInt("idclient"),rs.getString("nume"),rs.getString("serie"),rs.getString("cnp"),rs.getString("adresa"),rs.getString("telefon"));
                list.add(client);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;

    }

    public void updateClient(Client client) {
        try {
            ConnectionFactory cc = new ConnectionFactory();
            cc.createConnection();
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement posted = connection.prepareStatement(
                    "UPDATE client SET  idClient = ?, nume= ?, serie = ?, cnp = ?, adresa = ?, telefon = ? " + " WHERE idclient = ? ");
            posted.setInt(1, client.getIdClient());
            posted.setString(2, client.getNume());
            posted.setString(3, client.getSerie());
            posted.setString(4, client.getCnp());
            posted.setString(5, client.getAdresa());
            posted.setString(6, client.getTelefon());
            posted.setInt(7, client.getIdClient());

            posted.executeUpdate();
            cc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }








}
