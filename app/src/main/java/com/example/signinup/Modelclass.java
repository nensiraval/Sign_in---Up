package com.example.signinup;

public class Modelclass {

    private String name,num;
    Modelclass(String name, String num)
    {
        this.name = name;
        this.num = num;
    }
    //alt + insert press to gettersetter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
