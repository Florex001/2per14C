package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Autó auto1 = new Autó("LOL-692", 100, true);

        Autó[] járművek = new Autó[4];
        int esz =0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i<2; i++) {
            String adatsor = sc.nextLine();
            String[] adatok = adatsor.split(" ");
            járművek[esz] = new Autó(adatok[0], Integer.parseInt(adatok[1]), Boolean.parseBoolean(adatok[2]));
            esz++;
        }
        for (int i = 0; i<2; i++){
            String adatsor = sc.nextLine();
            String[] adatok = adatsor.split(" ");
            járművek[esz] = new Teherautó(adatok[0], Integer.parseInt(adatok[1]), Boolean.parseBoolean(adatok[2]), Integer.parseInt(adatok[3]));
            esz++;
        }


    }
}
