package com.company;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Jármű {
    private static int db = 0;

    private int azonosito;
    private String gyártó;
    private String model;
    private int gyártásÉve = -1;
    private String szín = null;
    private String alvazszam;
    private String rendszam;
    private String üzemanyag = null;
    private int ajtok_szama = 0;
    private int kormany_oldala = -1;//0-bal 1-jobb
    private boolean forgalomban_van_e = false;

    public Jármű(String gyártó, String model, String alvazszam, String rendszam, boolean forgalomban_van_e){
        db++;
        this.gyártó = gyártó;
        this.model = model;
        this.alvazszam = alvazszam;
        this.rendszam = rendszam;
        this.forgalomban_van_e = forgalomban_van_e;

    }

    public void setGyártásÉve(int gyártásÉve) {
        if (gyártásÉve < 1900){
            throw new IllegalArgumentException("Az évszám nem lehet 1900-nál korábbi!");
        }
        if (gyártásÉve > (Calendar.getInstance().get(Calendar.YEAR))){
            throw new IllegalArgumentException("Nem lehet az aktuális évtől nagyobb.");
        }
        this.gyártásÉve = gyártásÉve;
    }

    public int getAzonosito() {
        return azonosito;
    }

    public String getAlvazszam() {
        return alvazszam;
    }

    public String getModel() {
        return model;
    }

    public String getKormányOldalaSTR(){
        if (this.kormany_oldala ==0){
            return "bal";
        }else {
            return "jobb";
        }
    }

    public void setSzín(String szín) {
        this.szín = szín;
    }

    public void setÜzemanyag(String üzemanyag) {
        if ((!üzemanyag.equals("benzin") && !üzemanyag.equals("dízel") && !üzemanyag.equals("elektromos"))){
            throw new IllegalArgumentException("Az üzemanyag csak dízel bvenzin és elektromos lehet");
        }
        this.üzemanyag = üzemanyag;
    }

    public void setAjtok_szama(int ajtok_szama) {
        if (!((ajtok_szama > 0) && (ajtok_szama <= 5))){
            throw new IllegalArgumentException("Az ajtók száma nem lehet 5 nél nagyobb");
        }
        this.ajtok_szama = ajtok_szama;
    }

    public void setKormany_oldala(int kormany_oldala) {
        if ((kormany_oldala != 0) && (kormany_oldala != 1)) {
            throw new IllegalArgumentException("Kormány oldalának azonosítója nem megfelelő. 0-bal 1-jobb");
        }

        this.kormany_oldala = kormany_oldala;
    }
    public void setKormany_oldala(String kormany_oldala) {
        if (!kormany_oldala.equals("bal") && !kormany_oldala.equals("jobb")){
            throw new IllegalArgumentException("A kormány oldala csak bal vagy jobb lehet");
        }
        if (kormany_oldala.equals("bal")){
            this.kormany_oldala = 0;
        }else {
            this.kormany_oldala = 1;
        }
    }


    public String getGyártó() {
        return gyártó;
    }

    public String getRendszam() {
        return rendszam;
    }

    public boolean isForgalomban_van_e() {
        return forgalomban_van_e;
    }

    public String getSzín() {
        return szín;
    }

    public String getÜzemanyag() {
        return üzemanyag;
    }

    public int getKormany_oldala() {
        return kormany_oldala;
    }

    public int getAjtok_szama() {
        return ajtok_szama;
    }

    public int getGyártásÉve() {
        return gyártásÉve;
    }

    @Override
    public String toString() {
        if (this.forgalomban_van_e) {
            return String.format("\tJármű azonosítója: %d. \n" +
                            "\tJármű gyártója: %s\n" +
                            "\tJármű típusa: %s\n" +
                            "\tJármű gyártás éve: %d\n" +
                            "\tJármű színe: %s\n" +
                            "\tJármű alvázszáma: %s\n" +
                            "\tJármű rendszáma: %s\n" +
                            "\tJármű üzemanyaga %s\n" +
                            "\tJármű ajtók száma: %d\n" +
                            "\tJármű kormány oldala: %s\n" +
                            "\tJármű forgalomban van-e: Igen ", this.azonosito, this.gyártó, this.model, this.gyártásÉve,
                    this.szín, this.alvazszam, this.rendszam, this.üzemanyag, this.ajtok_szama, this.getKormányOldalaSTR(), this.forgalomban_van_e);
        }else {
            return String.format("\tJármű azonosítója: %d. \n" +
                            "\tJármű gyártója: %s\n" +
                            "\tJármű típusa: %s\n" +
                            "\tJármű gyártás éve: %d\n" +
                            "\tJármű színe: %s\n" +
                            "\tJármű alvázszáma: %s\n" +
                            "\tJármű rendszáma: %s\n" +
                            "\tJármű üzemanyaga %s\n" +
                            "\tJármű ajtók száma: %d\n" +
                            "\tJármű kormány oldala: %s\n" +
                            "\tJármű forgalomban van-e: Nem ", this.azonosito, this.gyártó, this.model, this.gyártásÉve,
                    this.szín, this.alvazszam, this.rendszam, this.üzemanyag, this.ajtok_szama, this.getKormányOldalaSTR(), this.forgalomban_van_e);
        }
    }

    public String jelszoGeneralas(){
        String jelszo = Integer.toString(this.gyártásÉve);
        jelszo += "-";
        jelszo += this.rendszam.replace("-", "");
        jelszo += "-";
        jelszo += this.alvazszam.substring(this.alvazszam.length() - 6 );
        jelszo += "-";
        jelszo += this.üzemanyag.substring(0, 1).toUpperCase();
        Random rng = new Random();
        for (int i = 0; i < 6; i++ ){
            int szam = rng.nextInt(10);
            jelszo += Integer.toString(szam);
        }
        return jelszo;
    }



}
