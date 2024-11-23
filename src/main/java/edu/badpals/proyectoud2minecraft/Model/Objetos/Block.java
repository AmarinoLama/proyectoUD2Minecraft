package edu.badpals.proyectoud2minecraft.Model.Objetos;

public class Block {

    private Integer blkId = 0;
    private String BlkIdName = "";
    private Integer blkLuminosity = 0;
    private Integer blkBlastResistance = 0;
    private Integer blkFlammable = 0;

    public Block() {
    }

    public Block(String BlkIdName, Integer blkLuminosity, Integer blkBlastResistance, Integer blkFlammable) {
        this.BlkIdName = BlkIdName;
        this.blkLuminosity = blkLuminosity;
        this.blkBlastResistance = blkBlastResistance;
        this.blkFlammable = blkFlammable;
    }

    public Block(Integer blkId, String BlkIdName, Integer blkLuminosity, Integer blkBlastResistance, Integer blkFlammable) {
        this.blkId = blkId;
        this.BlkIdName = BlkIdName;
        this.blkLuminosity = blkLuminosity;
        this.blkBlastResistance = blkBlastResistance;
        this.blkFlammable = blkFlammable;
    }

    public Integer getBlkId() {
        return blkId;
    }

    public void setBlkId(Integer blkId) {
        this.blkId = blkId;
    }

    public String getBlkIdName() {
        return BlkIdName;
    }

    public void setBlkIdName(String blkIdName) {
        this.BlkIdName = blkIdName;
    }

    public Integer getBlkLuminosity() {
        return blkLuminosity;
    }

    public void setBlkLuminosity(Integer blkLuminosity) {
        this.blkLuminosity = blkLuminosity;
    }

    public Integer getBlkBlastResistance() {
        return blkBlastResistance;
    }

    public void setBlkBlastResistance(Integer blkBlastResistance) {
        this.blkBlastResistance = blkBlastResistance;
    }

    public Integer getBlkFlammable() {
        return blkFlammable;
    }

    public void setBlkFlammable(Integer blkFlammable) {
        this.blkFlammable = blkFlammable;
    }
}
