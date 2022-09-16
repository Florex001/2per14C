package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
    private static ArrayList<Jármű> járművek = new ArrayList<>();
    public static void main(String[] args) {
        beolvas("autok.csv");

        System.out.println("A beolvasott fájlban " + járművek.size() + " jármű adata található meg.");

        int db = 0;
        for (Jármű elem : járművek){
            if (elem.getSzín().equals("Red")){
                db++;
            }
        }

        System.out.printf("Összesen %d db vörös autó van a listában!\n", db);

        db = 0;

        for (Jármű elem : járművek){
            if ((elem.getGyártó().equals("Ford")) && (elem.getÜzemanyag().equals("dízel"))){
                db++;
            }
        }
        System.out.printf("Összesen %d db gázolajjal működő Ford gépjármű van a listában!\n", db);

        double átlag = 0;
        for (Jármű elem : járművek){
            átlag += (Calendar.getInstance().get(Calendar.YEAR)) - (elem.getGyártásÉve());
        }

        átlag /= járművek.size();
        System.out.printf("A járművek átlagos kora: %.1f\n", átlag);

        db = 0;

        for (Jármű elem : járművek){
            if (elem.isForgalomban_van_e()){
                db++;
            }
        }
        System.out.printf("Összesen %d db jármű van forgalomban, és %d db nincsen forgalomban.\n", db, járművek.size()- db);

        boolean volt = false;
        for (Jármű elem: járművek){
            if (elem.getÜzemanyag().equals("elektromos")){
                volt = true;
            }
        }
        if (volt){
            System.out.println("A járművek között volt elektromos hajtású jármű.");
        }else{
            System.out.println("A járművek között nincs elektromos hajtásu");
        }

        Jármű maxJármű = járművek.get(0);
        Jármű minJármű = járművek.get(0);

        for(Jármű elem : járművek){
            if(elem.getGyártásÉve() > maxJármű.getGyártásÉve()){
                maxJármű = elem;
            }

            if (elem.getGyártásÉve() < minJármű.getGyártásÉve()){
                minJármű = elem;
            }
        }

        System.out.println("A legfiatalabb autó adatai:");
        System.out.println(maxJármű.toString());
        System.out.println("A legidősebb autó adatai:");
        System.out.println(minJármű.toString());

        Scanner sc = new Scanner(System.in);
        System.out.printf("Kérem adja meg a jármű gyártója nevét: ");
        String gyarto = sc.nextLine();
        System.out.printf("Kérem adja meg a jármű kormány oldalát(jobb/bal):");
        String kormanyoldala = sc.nextLine();

        if (!kormanyoldala.equals("bal") && !kormanyoldala.equals("jobb")){
            System.out.printf("Nem megfelelő értéket adott meg");
            System.exit(1);
        }

        volt = false;

        for (Jármű elem : járművek){
            if (elem.getGyártó().equals(gyarto) && elem.getKormányOldalaSTR().equals(kormanyoldala)){
                System.out.println(elem.getRendszam());
                volt = true;
            }
        }

        if (!volt){
            System.out.println("Ilyen paraméterekkel nincs jármű az állományban!");
        }

        System.out.println(gyartokKigyujtese().length);

        System.out.println(járművek.get(0).toString());
        System.out.println(járművek.get(0).jelszoGeneralas());

        File fájl = new File("jelszavak.txt");
        try {
            PrintWriter iro = new PrintWriter(fájl, Charset.forName("UTF-8"));

            iro.println("rendszám\tjelszo");
            for (Jármű elem : járművek){
                iro.print(elem.getRendszam());
                iro.print("\t");
                iro.println(elem.jelszoGeneralas());
            }

            iro.close();
        } catch (IOException e) {
            System.out.println("A jelszavakat nem tudtam ki generálni mert a jelszavak.txt nem írható!");
        }

    }


    private static String[] gyartokKigyujtese(){

        ArrayList<String> gyartoklista = new ArrayList<String>();

        for (Jármű elem: járművek){
            boolean volt = false;
            for (String gyarto : gyartoklista){
                if (gyarto.equals(elem.getGyártó())){
                    volt = true;
                    break;
                }
            }
            if (!volt) {
                gyartoklista.add(elem.getGyártó());
            }
        }
        String[] gyartok = new String[gyartoklista.size()];
        for (int i =0; i < gyartoklista.size(); i++){
            gyartok[i] = gyartoklista.get(i);
        }

        return gyartok;
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
