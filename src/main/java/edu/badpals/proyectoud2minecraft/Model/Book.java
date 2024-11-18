package edu.badpals.proyectoud2minecraft.Model;

public class Book {

    private Integer bkId = 0;
    private String bkName = "";
    private String bkType = "";
    private String bkEnchantment = "";
    private Integer bkLevel = 0;

    public Book(Integer bkId, String bkName, String bkType, String bkEnchantment, Integer bkLevel) {
        this.bkId = bkId;
        this.bkName = bkName;
        this.bkType = bkType;
        this.bkEnchantment = bkEnchantment;
        this.bkLevel = bkLevel;
    }

    public Book() {
    }

    public Book(String bkName, Integer bkLevel, String bkEnchantment, String bkmType) {
        this.bkName = bkName;
        this.bkLevel = bkLevel;
        this.bkEnchantment = bkEnchantment;
        this.bkType = bkmType;
    }

    public Integer getBkId() {
        return bkId;
    }

    public String getBkType() {
        return bkType;
    }

    public void setBkType(String bkType) {
        this.bkType = bkType;
    }

    public void setBkId(Integer bkId) {
        this.bkId = bkId;
    }

    public String getBkName() {
        return bkName;
    }

    public void setBkName(String bkName) {
        this.bkName = bkName;
    }

    public String getBkmType() {
        return bkType;
    }

    public void setBkmType(String bkmType) {
        this.bkType = bkmType;
    }

    public String getBkEnchantment() {
        return bkEnchantment;
    }

    public void setBkEnchantment(String bkEnchantment) {
        this.bkEnchantment = bkEnchantment;
    }

    public Integer getBkLevel() {
        return bkLevel;
    }

    public void setBkLevel(Integer bkLevel) {
        this.bkLevel = bkLevel;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bkId=" + bkId +
                ", bkName='" + bkName + '\'' +
                ", bkmType='" + bkType + '\'' +
                ", BkEnchantment=" + bkEnchantment +
                ", BkLevel='" + bkLevel + '\'' +
                '}';
    }
}
