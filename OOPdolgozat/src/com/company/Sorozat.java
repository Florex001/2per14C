package com.company;

public class Sorozat extends Film{

    public int epizodokSzama;

    public Sorozat(String cím, int hossz, boolean korhatáros_e, int epizodokSzama){
        super(cím, hossz, korhatáros_e);
        this.epizodokSzama = epizodokSzama;
    }

    @Override
    public String toString() {
        if (korhatáros_e){
            return String.format("%s: %d perces, korhatáros, epizódok száma: %d", this.cím, this.hossz, this.epizodokSzama );
        }else {
            return String.format("%s: %d perces, nem korhatáros, epizódok száma: %d", this.cím, this.hossz, this.epizodokSzama);
        }
    }

    public boolean sokrészes_e(){
        if (this.epizodokSzama > 1000){
            return true;
        }
        else {
            return false;
        }
    }
}
