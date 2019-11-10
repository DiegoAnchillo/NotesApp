package com.example.notesapp.repository;

import com.example.notesapp.models.User;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static List<User> users = new ArrayList<>();
    static{
        users.add(new User("luis456", "Luis Perez", "luis@gmail.com", "123456"));
        users.add(new User("ana1458", "Ana Maria", "ana@gmail.com", "123456"));
        users.add(new User("jose256", "Jose Ramirez", "jose@gmail.com", "123456"));
    }

    public static void create(String name,String fullname, String email, String password){
        User user = new User(name,fullname, email, password);
        SugarRecord.save(user);
    }

    public static User login(String username, String password){
        for (User user : users){
            if(user.getUser().equalsIgnoreCase(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public static User getUser(String username){
        for (User user : users){
            if(user.getUser().equalsIgnoreCase(username)){
                return user;
            }
        }
        return null;
    }

}
