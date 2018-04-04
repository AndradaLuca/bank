package buisness.BLL;

import data.dao.ClientStatement;
import data.dao.ContStatement;
import data.dao.UserStatement;
import buisness.model.Client;

import java.util.List;

public class ClientBLL {

    private ClientStatement clientStatement;
    private ContStatement contStatement;
    Client client;
    RaportBLL raportBLL;
    public ClientBLL()
    {
        this.clientStatement=new ClientStatement();
        this.contStatement=new ContStatement();
        this.raportBLL = new RaportBLL();
    }

    public void insertClient(int id, String nume,String serie,String cnp,String adresa,String telefon)
    {
      client = new Client(id,nume,serie,cnp,adresa,telefon);
        clientStatement.insertClient(client);
        String actiune="A fost introdus Clientul cu id-ul: " + id;
        raportBLL.insert(UserStatement.id,actiune);
    }

    public void deleteClient(int id)
    {   contStatement.deleteContDupaClient(id);
        clientStatement.deleteClient(id);
        String actiune="A fost sters Clientul cu id-ul: " + id;
        raportBLL.insert(UserStatement.id,actiune);
    }

    public List<Client> getALL()
    {
        return clientStatement.getAll();
    }

    public void update(int id, String nume,String serie,String cnp,String adresa,String telefon)
    {
         client = new Client(id,nume,serie,cnp,adresa,telefon);
        clientStatement.updateClient(client);
        String actiune="A fost actualizat Clientul cu id-ul: " + id;
        raportBLL.insert(UserStatement.id,actiune);
    }



}
