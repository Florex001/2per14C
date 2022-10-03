package com.company;

public class Autó {
    String rendszam;
    int teljesitmeny;
    boolean automatavaltos;

    public Autó(String rendszam, int teljesitmeny, boolean automatavaltos){
        this.rendszam = rendszam;
        this.teljesitmeny = teljesitmeny;
        this.automatavaltos = automatavaltos;
    }

    public String getRendszam() {
        return rendszam;
    }

    public int getTeljesitmeny() {
        return teljesitmeny;
    }

    public boolean isAutomatavaltos() {
        return automatavaltos;
    }

    @Override
    public String toString() {
        if (this.automatavaltos) {
            return String.format("Az autó rendszáma: %s, teljesítménye: %d, autómata váltós-e: Igen", this.rendszam, this.teljesitmeny);
        }
        else {
            return String.format("Az autó rendszáma: %s, teljesítménye: %d, autómata váltós-e: Igen", this.rendszam, this.teljesitmeny);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Autó){
            Autó másik = (Autó)obj;
            if (this.rendszam.equals(másik.getRendszam())){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public int compareTo(Autó obj){
        //1-ha a megadott nagyobb az aktuálistol
        //0-ha egyenlőek
        //-1-ha kisebb az aktuálistól

        if(obj.getTeljesitmeny() > this.teljesitmeny){
            return 1;
        }else if (obj.getTeljesitmeny() < this.teljesitmeny){
            return -1;
        }else {
            return 0;
        }
    }

    public Boolean rendszamEll(){
        if (this.rendszam.length() != 7){
            return false;
        }

       boolean eleje3betu =false;
        if (Character.isLetter(this.rendszam.charAt(0)) && Character.isLetter(this.rendszam.charAt(1)) && Character.isLetter(this.rendszam.charAt(2))){
            eleje3betu=true;
        }
        boolean kotojel = false;
        if (this.rendszam.charAt(3) == '-'){
            kotojel = true;
        }
        boolean utolso3szam = false;
        if (Character.isDigit(this.rendszam.charAt(4)) && Character.isDigit(this.rendszam.charAt(5)) && Character.isDigit(this.rendszam.charAt(6))){
            utolso3szam = true;
        }
        return eleje3betu && kotojel && utolso3szam;
    }

}
