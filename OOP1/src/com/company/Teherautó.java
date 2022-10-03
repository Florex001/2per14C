package com.company;

public class Teherautó extends Autó {

    private int teherbiras;

    public Teherautó(String rendszam, int teljesitmeny, boolean automatavaltos, int teherbiras) {
        super(rendszam, teljesitmeny, automatavaltos);
        this.teherbiras = teherbiras;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + String.format("Teherbírása: %d\n", this.teherbiras);
    }
}
