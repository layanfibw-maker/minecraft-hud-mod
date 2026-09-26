package com.hudmod.hud.elements;

import com.hudmod.hud.HUDElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.EntityPlayer;

public class CoordinatesElement extends HUDElement {

    private Minecraft mc = Minecraft.getMinecraft();

    public CoordinatesElement(int x, int y) {
        super("Coordinates", x, y, 100, 10);
    }

    @Override
    public void render(FontRenderer fr) {
        if (!visible || mc.thePlayer == null) return;

        EntityPlayer player = mc.thePlayer;
        int px = (int) player.posX;
        int py = (int) player.posY;
        int pz = (int) player.posZ;

        String text = "XYZ: " + px + " " + py + " " + pz;
        this.width = fr.getStringWidth(text);
        fr.drawStringWithShadow(text, x, y, 0x00FFFF);
    }

    @Override
    public String getDisplayText() {
        if (mc.thePlayer == null) return "XYZ: 0 0 0";
        EntityPlayer player = mc.thePlayer;
        int px = (int) player.posX;
        int py = (int) player.posY;
        int pz = (int) player.posZ;
        return "XYZ: " + px + " " + py + " " + pz;
    }
}