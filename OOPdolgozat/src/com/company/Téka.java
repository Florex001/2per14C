package com.company;

import java.util.ArrayList;

public class Téka {
    public ArrayList<Film> Téka = new ArrayList<Film>();

    public ArrayList<Film> getTéka() {
        return Téka;
    }

    public void setTéka(ArrayList<Film> téka) {
        Téka = téka;
    }
    public void leghosszabbfilm(){
        int leghosszabb = 0;
        for (int i = 0; i < Téka.size();i++){ //sajnos nem tudom mi kell oda :(
            if (Téka.indexOf(i)>leghosszabb){
                leghosszabb = Téka.indexOf(i);
            }
        }
        System.out.println(leghosszabb);
    }
}
