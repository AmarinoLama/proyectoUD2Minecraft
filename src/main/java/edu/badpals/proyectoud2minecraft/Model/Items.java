package edu.badpals.proyectoud2minecraft.Model;

public class Items {


    /*

    ItmId INT AUTO_INCREMENT NOT NULL, -- ID de todos los items (Aqui estan todos)
    ItmName VARCHAR(40) NOT NULL, -- Nombre del item
    ItmDesc TEXT NOT NULL, -- Descripción del item
    ItmStackSize INT NOT NULL, -- Tamaño del stack
    ItmImage BLOB, -- Imagen del item, se guarda aqui para no tenerla en cada tabla
    Primary Key (ItmId)

     */

    private Integer ItmId = 0;
    private String ItmName = "";
    private String ItmDesc = "";
    private Integer ItmStackSize = 0;
    private String ItmImage = "";

    public Items(Integer itmId, String itmName, String itmDesc, Integer itmStackSize, String itmImage) {
        ItmId = itmId;
        ItmName = itmName;
        ItmDesc = itmDesc;
        ItmStackSize = itmStackSize;
        ItmImage = itmImage;
    }

    public Items() {
    }

    public Items(String itmName, String itmImage, Integer itmStackSize, String itmDesc) {
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
