package edu.badpals.proyectoud2minecraft.Model.Objetos;

public class Item {

    private Integer ItmId = 0;
    private String ItmName = "";
    private String ItmDesc = "";
    private Integer ItmStackSize = 0;
    private String ItmImage = "";

    public Item(Integer itmId, String itmName, String itmDesc, Integer itmStackSize, String itmImage) {
        ItmId = itmId;
        ItmName = itmName;
        ItmDesc = itmDesc;
        ItmStackSize = itmStackSize;
        ItmImage = itmImage;
    }

    public Item() {
    }

    public Item(String itmName, String itmImage, Integer itmStackSize, String itmDesc) {
        ItmName = itmName;
        ItmImage = itmImage;
        ItmStackSize = itmStackSize;
        ItmDesc = itmDesc;
    }

    public Integer getItmId() {
        return ItmId;
    }

    public void setItmId(Integer itmId) {
        ItmId = itmId;
    }

    public String getItmName() {
        return ItmName;
    }

    public void setItmName(String itmName) {
        ItmName = itmName;
    }

    public String getItmDesc() {
        return ItmDesc;
    }

    public void setItmDesc(String itmDesc) {
        ItmDesc = itmDesc;
    }

    public Integer getItmStackSize() {
        return ItmStackSize;
    }

    public void setItmStackSize(Integer itmStackSize) {
        ItmStackSize = itmStackSize;
    }

    public String getItmImage() {
        return ItmImage;
    }

    public void setItmImage(String itmImage) {
        ItmImage = itmImage;
    }

    @Override
    public String toString() {
        return "Items{" +
                "ItmId=" + ItmId +
                ", ItmName='" + ItmName + '\'' +
                ", ItmDesc='" + ItmDesc + '\'' +
                ", ItmStackSize=" + ItmStackSize +
                ", ItmImage='" + ItmImage + '\'' +
                '}';
    }


}
