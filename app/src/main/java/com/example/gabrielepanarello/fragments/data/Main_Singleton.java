package com.example.gabrielepanarello.fragments.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriele Panarello on 15/02/2018.
 */

public class Main_Singleton {

    private static Main_Singleton ourInstance = new Main_Singleton();
    private static List<Pizza> pizzaList;

    public static Main_Singleton getInstance(){
        return ourInstance;
    }

    private Main_Singleton(){
        List<Pizza> contactList = new ArrayList<Pizza>();
    }

    public static List<Pizza> getItemList() {
        return pizzaList;
    }

    public static void setContactList(List<Pizza> singleContactList) {
        pizzaList = singleContactList;
    }


}