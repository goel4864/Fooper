package com.example.fooper;

public class DonationData
{
    String Name, Number,Adress,Food,Quant,usercred;

    public DonationData(String name, String number, String adress, String food, String quant) {
        Name = name;
        Number = number;
        Adress = adress;
        Food = food;
        Quant = quant;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getFood() {
        return Food;
    }

    public void setFood(String food) {
        Food = food;
    }

    public String getQuant() {
        return Quant;
    }

    public void setQuant(String quant) {
        Quant = quant;
    }

    public String getUsercred() {
        return usercred;
    }

    public void setUsercred(String usercred) {
        this.usercred = usercred;
    }
}
