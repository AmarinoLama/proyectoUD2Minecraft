package edu.badpals.proyectoud2minecraft.Model.Objetos;

public class Tool {


    private int ToolId = 0;
    private String ToolName = "";
    private int ToolDurability = 0;
    private int ToolFlammable = 0;
    private int ToolDamage = 0;

    public Tool() {
    }

    public Tool(String toolName, int toolDurability, int toolFlammable, int toolDamage) {
        ToolName = toolName;
        ToolDurability = toolDurability;
        ToolFlammable = toolFlammable;
        ToolDamage = toolDamage;
    }

    public Tool(int toolId, String toolName, int toolDurability, int toolFlammable, int toolDamage) {
        ToolId = toolId;
        ToolName = toolName;
        ToolDurability = toolDurability;
        ToolFlammable = toolFlammable;
        ToolDamage = toolDamage;
    }

    public int getToolId() {
        return ToolId;
    }

    public void setToolId(int toolId) {
        ToolId = toolId;
    }

    public String getToolName() {
        return ToolName;
    }

    public void setToolName(String toolName) {
        ToolName = toolName;
    }

    public int getToolDurability() {
        return ToolDurability;
    }

    public void setToolDurability(int toolDurability) {
        ToolDurability = toolDurability;
    }

    public int getToolFlammable() {
        return ToolFlammable;
    }

    public void setToolFlammable(int toolFlammable) {
        ToolFlammable = toolFlammable;
    }

    public int getToolDamage() {
        return ToolDamage;
    }

    public void setToolDamage(int toolDamage) {
        ToolDamage = toolDamage;
    }
}
