package com.hudmod.hud.elements;

import com.hudmod.hud.HUDElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.EntityPlayer;

public class DirectionElement extends HUDElement {

    private Minecraft mc = Minecraft.getMinecraft();

    public DirectionElement(int x, int y) {
        super("Direction", x, y, 80, 10);
    }

    @Override
    public void render(FontRenderer fr) {
        if (!visible || mc.thePlayer == null) return;

        EntityPlayer player = mc.thePlayer;
        int yaw = (int) player.rotationYaw;
        if (yaw < 0) yaw += 360;

        String dir = getDirection(yaw);
        String text = "Dir: " + dir + " (" + yaw + "°)";
        this.width = fr.getStringWidth(text);
        fr.drawStringWithShadow(text, x, y, 0xFF00FF);
    }

    @Override
    public String getDisplayText() {
        if (mc.thePlayer == null) return "Dir: N (0°)";
        EntityPlayer player = mc.thePlayer;
        int yaw = (int) player.rotationYaw;
        if (yaw < 0) yaw += 360;
        String dir = getDirection(yaw);
        return "Dir: " + dir + " (" + yaw + "°)";
    }

    private String getDirection(int yaw) {
        if (yaw >= 315 || yaw < 45) return "S";
        if (yaw >= 45 && yaw < 135) return "W";
        if (yaw >= 135 && yaw < 225) return "N";
        if (yaw >= 225 && yaw < 315) return "E";
        return "N/A";
    }
}