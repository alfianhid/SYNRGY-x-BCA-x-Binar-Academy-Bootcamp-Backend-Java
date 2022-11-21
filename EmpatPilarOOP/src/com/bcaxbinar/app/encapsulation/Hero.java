package com.bcaxbinar.app.encapsulation;

public class Hero {
    // DEFAULT ACCESS MODIFIER => PUBLIC
    int levelDefault = 1; // variable default

    void displayDefault(){ // fungsi default
        System.out.println("Level Hero adalah " + levelDefault);
    }

    // PUBLIC ACCESS MODIFIER => BISA SEMUA CLASS
    public int levelPublic = 1; // variable public

    public void displayPublic() { // fungsi public
        System.out.println("Level Hero adalah " + levelPublic);
    }

    // PRIVATE ACCESS MODIFIER => HANYA CLASS INI
    private int levelPrivate = 1; // variable private

    private void displayPrivate() { // fungsi private
        System.out.println("Level Hero adalah " + levelPrivate);
    }

    // PROTECTED ACCESS MODIFIER => CLASS INI DAN TURUNANNYA/INSTANCE-NYA
    protected int levelProtected = 1; // variable protected

    protected void displayProtected() { // fungsi protected
        System.out.println("Level Hero adalah " + levelProtected);
    }
}
