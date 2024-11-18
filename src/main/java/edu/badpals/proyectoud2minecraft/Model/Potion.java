package edu.badpals.proyectoud2minecraft.Model;

public class Potion {



    private int potId = 0;
    private String potName = "";
    private String potEffect = "";
    private int potDuration = 0;
    private int potLevel = 0;

    public Potion(int potId, String potName, String potEffect, int potDuration, int potLevel) {
        this.potId = potId;
        this.potName = potName;
        this.potEffect = potEffect;
        this.potDuration = potDuration;
        this.potLevel = potLevel;
    }

    public Potion() {
    }

    public Potion(String potName, String potEffect, int potDuration, int potLevel) {
        this.potName = potName;
        this.potEffect = potEffect;
        this.potDuration = potDuration;
        this.potLevel = potLevel;
    }

    public int getPotId() {
        return potId;
    }

    public void setPotId(int potId) {
        this.potId = potId;
    }

    public int getPotLevel() {
        return potLevel;
    }

    public void setPotLevel(int potLevel) {
        this.potLevel = potLevel;
    }

    public int getPotDuration() {
        return potDuration;
    }

    public void setPotDuration(int potDuration) {
        this.potDuration = potDuration;
    }

    public String getPotEffect() {
        return potEffect;
    }

    public void setPotEffect(String potEffect) {
        this.potEffect = potEffect;
    }

    public String getPotName() {
        return potName;
    }

    public void setPotName(String potName) {
        this.potName = potName;
    }

    @Override
    public String toString() {
        return "Potion{" +
                "potId=" + potId +
                ", potName='" + potName + '\'' +
                ", potEffect='" + potEffect + '\'' +
                ", potDuration=" + potDuration +
                ", potLevel=" + potLevel +
                '}';
    }
}