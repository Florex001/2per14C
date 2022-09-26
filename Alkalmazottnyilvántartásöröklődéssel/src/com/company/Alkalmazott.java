package com.company;

public class Alkalmazott {
    protected String név;
    protected String beosztás;

    public Alkalmazott(String név, String beosztás){
        this.név = név;
        this.beosztás = beosztás;
    }

    public String getBeosztás() {
        return beosztás;
    }
    public String getNév() {
        return név;
    }
    public void setBeosztás(String beosztás) {
        this.beosztás = beosztás;
    }
    public void setNév(String név) {
        this.név = név;
    }

    public void csekketKiallit(int kifizetettÖsszeg){
        System.out.printf("Fizessenek %s (%s) részére %d Forintot.\n", this.név, this.beosztás, kifizetettÖsszeg);
    }
}
