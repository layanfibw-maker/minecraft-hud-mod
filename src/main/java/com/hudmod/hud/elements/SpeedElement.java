package com.hudmod.hud.elements;

import com.hudmod.hud.HUDElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.EntityPlayer;

public class SpeedElement extends HUDElement {

    private Minecraft mc = Minecraft.getMinecraft();

    public SpeedElement(int x, int y) {
        super("Speed", x, y, 70, 10);
    }

    @Override
    public void render(FontRenderer fr) {
        if (!visible || mc.thePlayer == null) return;

        EntityPlayer player = mc.thePlayer;
        double speed = Math.sqrt(player.motionX * player.motionX + player.motionZ * player.motionZ);
        speed = Math.round(speed * 100.0) / 100.0;

        String text = "Speed: " + speed + "m/s";
        this.width = fr.getStringWidth(text);
        fr.drawStringWithShadow(text, x, y, 0x00FF00);
    }

    @Override
    public String getDisplayText() {
        if (mc.thePlayer == null) return "Speed: 0m/s";
        EntityPlayer player = mc.thePlayer;
        double speed = Math.sqrt(player.motionX * player.motionX + player.motionZ * player.motionZ);
        speed = Math.round(speed * 100.0) / 100.0;
        return "Speed: " + speed + "m/s";
    }
}