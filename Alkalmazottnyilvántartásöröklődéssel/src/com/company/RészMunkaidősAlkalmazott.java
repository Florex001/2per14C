package com.company;

public class RészMunkaidősAlkalmazott extends Alkalmazott{
    public int órabér;

    public int getÓrabér() {
        return órabér;
    }

    public void setÓrabér(int órabér) {
        this.órabér = órabér;
    }

    public RészMunkaidősAlkalmazott(String név, String beosztas){
        super(név, beosztas);
    }

    public RészMunkaidősAlkalmazott(String név, String beosztas, int órabér){
        super(név, beosztas);
        this.órabér = órabér;
    }

    public int FizetesMeghataroz(int munkaora){
        return this.órabér * munkaora;
    }

}
