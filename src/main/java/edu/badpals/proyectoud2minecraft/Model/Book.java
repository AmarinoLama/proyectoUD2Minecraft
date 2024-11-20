package edu.badpals.proyectoud2minecraft.Model;

public class Book {

    private Integer bkId = 0;
    private String bkName = "";
    private TipoLibro bkType;
    private String bkEnchantment = "";
    private Integer bkLevel = 0;

    public Book() {
    }

    public Book(Integer bkId, String bkName, TipoLibro bkType, String bkEnchantment, Integer bkLevel) {
        this.bkId = bkId;
        this.bkName = bkName;
        this.bkType = bkType;
        this.bkEnchantment = bkEnchantment;
        this.bkLevel = bkLevel;
    }

    public Integer getBkId() {
        return bkId;
    }

    public TipoLibro getBkType() {
        return bkType;
    }

    public void setBkType(TipoLibro bkType) {
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

    public TipoLibro getBkmType() {
        return bkType;
    }

    public void setBkmType(TipoLibro bkmType) {
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
