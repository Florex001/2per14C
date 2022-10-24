package com.company;

public class Film {
    protected String cím;
    protected int hossz;
    protected boolean korhatáros_e;


    public Film(String cím, int hossz, boolean korhatáros_e){
        this.cím = cím;
        this.hossz = hossz;
        this.korhatáros_e = korhatáros_e;
    }

    public void setCím(String cím) {
        this.cím = cím;
    }

    public String getCím() {
        return cím;
    }

    public int getHossz() {
        return hossz;
    }

    public void setHossz(int hossz) {
        this.hossz = hossz;
    }

    public boolean isKorhatáros_e() {
        return korhatáros_e;
    }

    public void setKorhatáros_e(boolean korhatáros_e) {
        this.korhatáros_e = korhatáros_e;
    }

    @Override
    public String toString() {
        if (korhatáros_e){
            return String.format("%s: %d perces, korhatáros", this.cím, this.hossz );
        }else {
            return String.format("%s: %d perces, nem korhatáros", this.cím, this.hossz);
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Film){
            Film egyenlo = (Film)obj;
            if (this.cím.equals(egyenlo.getCím())){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
