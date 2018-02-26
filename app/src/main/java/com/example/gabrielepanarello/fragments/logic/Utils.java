package com.example.gabrielepanarello.fragments.logic;

import com.example.gabrielepanarello.fragments.data.Main_Singleton;
import com.example.gabrielepanarello.fragments.data.Pizza;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriele Panarello on 15/02/2018.
 */

public class Utils {


    public static void init(){
        List<Pizza> lsTmp = new ArrayList<Pizza>();
        lsTmp.add(new Pizza(01,"Margherita","Pomodoro e Mozzarella"));
        lsTmp.add(new Pizza(02,"Wurstel","Pomodoro, Mozzarella e Wurstel"));
        lsTmp.add(new Pizza(03,"Calabrese","Pomodoro, Mozzarella e Salame"));

        Main_Singleton.getInstance().setContactList(lsTmp);
    }

    public static List<Pizza> getPizzaList(){
        return Main_Singleton.getInstance().getItemList();
    }

    public static void addPizza (Pizza contact){
        Main_Singleton.getInstance().getItemList().add(contact);
    }

    public static void removePizza (int contactPosition){
        Main_Singleton.getInstance().getItemList().remove(contactPosition);
    }



}