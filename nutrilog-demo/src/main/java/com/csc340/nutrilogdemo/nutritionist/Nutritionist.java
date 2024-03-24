package com.csc340.nutrilogdemo.nutritionist;
import com.csc340.nutrilogdemo.user.User;

import java.util.ArrayList;

public class Nutritionist extends User {

    public ArrayList<User> clients;

    public Nutritionist (){

    }

    public void setClients(ArrayList<User> clients) {
        this.clients = clients;
    }

    public ArrayList<User> getClients() {
        return clients;
    }
}
