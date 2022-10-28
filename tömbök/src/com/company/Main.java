package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] szamok = {26 , 85, 72, 39 , 7 , 53};//alap tömb
        int[] masoltszamok = Arrays.copyOf(szamok, szamok.length);//számok átmásolása és az uj tömb hossza

        System.out.println(Arrays.toString(masoltszamok));//kiirja a másolt számokat

        int[] szamok3 = Arrays.copyOfRange(szamok, 2, 4);//szám másolás indexel

        System.out.println(Arrays.toString(szamok3));//ki irja az alap tömbnek a közepén lévő számokat

        if (Arrays.equals(szamok, masoltszamok)){//ha ugyan azok az elemek és ugyan az a tipus akkor
            System.out.println("Megegyezik a két tömb");//megegyezik a két tömb
        }else {//különben
            System.out.println("Nem egyezik meg a két tömb");//nem egyezik meg a két tömb
        }

        Arrays.fill(szamok3, 5);//lecseréli a tömbben lévő összes számot 5 ösre

        System.out.println(Arrays.toString(szamok3));//kiírjuk az ujra definiált szamok3 tömböt aminek az eredménye 5 , 5 lesz mert lecseréltük az összes elemet 5 ösre

        Arrays.sort(szamok);//növekvő sorba rendezzük az alap tömböt

        System.out.println(Arrays.toString(szamok));//kiírjuk az átrendezett alap tömböt

    }
}
