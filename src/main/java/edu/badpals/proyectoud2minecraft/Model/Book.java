package edu.badpals.proyectoud2minecraft.Model;

public class Book {

    private Integer bkId = 0;
    private String bkName = "";
    private String bkType = "";
    private String BkEnchantment = "";
    private Integer BkLevel = 0;

    public Book(Integer bkId, String bkName, String bkType, String BkEnchantment, Integer BkLevel) {
        this.bkId = bkId;
        this.bkName = bkName;
        this.bkType = bkType;
        this.BkEnchantment = BkEnchantment;
        this.BkLevel = BkLevel;
    }

    public Book() {
    }

    public Book(String bkName, Integer bkLevel, String bkEnchantment, String bkmType) {
        this.bkName = bkName;
        BkLevel = bkLevel;
        BkEnchantment = bkEnchantment;
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
        return BkEnchantment;
    }

    public void setBkEnchantment(String bkEnchantment) {
        BkEnchantment = bkEnchantment;
    }

    public Integer getBkLevel() {
        return BkLevel;
    }

    public void setBkLevel(Integer bkLevel) {
        BkLevel = bkLevel;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bkId=" + bkId +
                ", bkName='" + bkName + '\'' +
                ", bkmType='" + bkType + '\'' +
                ", BkEnchantment=" + BkEnchantment +
                ", BkLevel='" + BkLevel + '\'' +
                '}';
    }
}
