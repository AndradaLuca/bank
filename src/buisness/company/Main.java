package buisness.company;

import buisness.BLL.ClientBLL;
import data.dao.ClientStatement;
import data.dao.ContStatement;
import data.dao.UserStatement;
import data.connection.ConnectionFactory;
import buisness.model.Client;
import buisness.model.Cont;
import buisness.model.User;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        int id;

        ConnectionFactory c = new ConnectionFactory();
        c.createConnection();

        ClientStatement cc = new ClientStatement();
        UserStatement uu = new UserStatement();
        ContStatement aa = new ContStatement();

        Client client = new Client(1, "Luca Andrada", "KX", "1234567890", "Mehedinti 21", "0758390662");
        User user= new User(5,"andrada","luca",1,"Luca Andrada","Mehedinti");
        User user1= new User(2,"andradaaa","luca",1,"Luca Andrada","Mehedinti");
        Cont cont = new Cont(1,1,1,2500,"12/12");

        //cc.insertClient(client);
       // aa.deleteCont(cont);
       // cc.deleteClient(client.getIdClient());
       // uu.insertUser(user1);
       // uu.deleteUser(user);
       // aa.insertCont(cont);
        ClientBLL ac= new ClientBLL();
        ac.insertClient(5,"andrada","luca","1","Luca Andrada","Mehedinti");
        List<Client> list=new ArrayList<Client>();

        list=cc.getAll();

        for (Client ccc: list)
        {
            System.out.println(ccc.toString());
        }

        c.close();
    }


}
