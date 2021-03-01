package com.example.watercalc;

public class HumanInfo
{
    Boolean female;
    Double weight;
    Double growth;
    public HumanInfo()
    {
        this.female=true;
        this.weight=66.6;
        this.growth=188.0;
    }



    public HumanInfo(boolean male,double weight, double growth)
    {
        this.female=male;
        this.weight=weight;
        this.growth=growth;
    }

    public Boolean getMale() {
        return female;
    }

    public Double getGrowth() {
        return growth;
    }

    public Double getWeight() {
        return weight;
    }
}
