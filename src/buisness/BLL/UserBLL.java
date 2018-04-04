package buisness.BLL;

import data.dao.UserStatement;
import buisness.model.User;

import java.util.List;

public class UserBLL {


    private UserStatement userStatement;

    public UserBLL()
    {
        userStatement=new UserStatement();
    }

    public void insertUser(User user)
    {
        userStatement.insertUser(user);
    }

    public void deleteUser(int id)
    {
        userStatement.deleteUser(id);
    }

    public int cauta(String u,String p)
    {
        int ok=userStatement.cauta(u,p);
        return ok;
    }

    public List<User> getAll()
    {
        return userStatement.getAll();
    }

    public void update(String nume,String adresa,int idUser)
    {
        userStatement.updateUser(nume,adresa,idUser);
    }

}
