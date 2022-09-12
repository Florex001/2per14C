package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Jármű> járművek = new ArrayList<>();
    public static void main(String[] args) {
        beolvas("autok.csv");

        System.out.println(járművek.size());
    }


    public static void beolvas(String fajlnev){
         File fajl = new File(fajlnev);
        try {
            Scanner olvaso = new Scanner(fajl, "UTF-8");

            olvaso.nextLine();
            while (olvaso.hasNextLine()){
                String sor = olvaso.nextLine();
                String[] adatok = sor.split(";");
                Jármű seged = new Jármű(adatok[0], adatok[1], adatok[4], adatok[5], Boolean.parseBoolean(adatok[9]));
                seged.setAjtok_szama(Integer.parseInt(adatok[7]));
                seged.setGyártásÉve(Integer.parseInt(adatok[2]));
                seged.setSzín(adatok[3]);
                seged.setKormany_oldala(adatok[8]);
                seged.setÜzemanyag(adatok[6]);
                járművek.add(seged);
            }

            olvaso.close();
        } catch (FileNotFoundException e) {
            System.out.print("Az "+fajlnev+" nem található a mappában!");
        }
    }
}
