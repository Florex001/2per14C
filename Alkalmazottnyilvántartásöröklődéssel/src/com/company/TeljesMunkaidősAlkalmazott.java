package com.company;

public class TeljesMunkaidősAlkalmazott extends Alkalmazott {
    private int hetifizetes;
    private int jutattaslevonas;

    public TeljesMunkaidősAlkalmazott(String név, String beosztas){
        super(név, beosztas);
    }

    public TeljesMunkaidősAlkalmazott(String név, String beosztas, int hetifizetes, int jutattaslevonas){
        super(név, beosztas);
        this.hetifizetes = hetifizetes;
        this.jutattaslevonas = jutattaslevonas;
    }

    public int getHetifizetes() {
        return hetifizetes;
    }

    public int getJutattaslevonas() {
        return jutattaslevonas;
    }

    public void setHetifizetes(int hetifizetes) {
        this.hetifizetes = hetifizetes;
    }

    public void setJutattaslevonas(int jutattaslevonas) {
        this.jutattaslevonas = jutattaslevonas;
    }

    public int FizetesMeghatarozas(){
        return hetifizetes - jutattaslevonas;
    }

    @Override
    public void csekketKiallit(int kifizetettÖsszeg) {
        System.out.printf("Fizessenek %s (%s) teljes munkaidős alkalmazott részére %d Forintot.\n",
                super.név, super.beosztás, kifizetettÖsszeg);
    }
}
