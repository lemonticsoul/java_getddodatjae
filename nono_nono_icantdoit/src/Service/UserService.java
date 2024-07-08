package Service;


import DAO.UserDAO;
import Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserService  {

    UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO= userDAO;
    }

    public boolean Join(int id,User user){
        userDAO.save(id,user);
        return true;
    }

    public boolean Login(String username,String password){
        boolean success=userDAO.login(username,password);
        return success;
    }

    public boolean Change(String name,String changename){
        int id=userDAO.findByIdFromName(name);
        User user=userDAO.findByUserFromId(id,changename);
        boolean changesuccess=userDAO.change(id,user);
        return changesuccess;
    }

    public boolean Delete (String isLoginusername){
        int id=userDAO.findByIdFromUsername(isLoginusername);
        boolean successgetout=userDAO.deleteUser(id);
        return successgetout;
    }

}
