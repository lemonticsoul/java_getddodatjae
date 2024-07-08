package DAO;

import Model.User;

import java.util.Arrays;
import java.util.Map;


public class UserDAO  {

    private Map<Integer, User> db;

    public UserDAO(Map<Integer, User> db){
        this.db=db;
    }

    public void save(int id,User user){
        db.put(id,user);
    }

    public Map<Integer, User>  getDb() {
        return db;
    }


    public boolean login(String username,String password){
        for (int key: db.keySet()){
            User user=db.get(key);
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;

    }

    //Name을 통한 id찾기
    public int findByIdFromName(String name){
        for (int key: db.keySet()){
            User user=db.get(key);
            if (user.getName().equals(name) ){
                return user.getId();
            }
        }
        return 0;
    }


    public User findByUserFromId(int id,String changename){
        for (int key: db.keySet()){
            User user=db.get(key);
            if (key==id ){
                user.setName(changename);
                return user;
            }
        }
        return null;
    }

    //change user
    public boolean change(int id,User user){
        db.put(id,user);
        return true;
    }

    //username을 가지고 id get sql
    public int findByIdFromUsername(String isLoginusername){
        for (int key: db.keySet()){
            User user=db.get(key);
            if (user.getUsername().equals(isLoginusername)){
                return user.getId();
            }
        }
       return 0;
    }

    //delete sql
    public boolean deleteUser(int id){
        System.out.println(id);
        db.remove(id);
        return true;
    }







}
