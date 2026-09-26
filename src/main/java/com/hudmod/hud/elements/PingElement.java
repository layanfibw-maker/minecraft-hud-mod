package com.hudmod.hud.elements;

import com.hudmod.hud.HUDElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class PingElement extends HUDElement {

    private Minecraft mc = Minecraft.getMinecraft();

    public PingElement(int x, int y) {
        super("Ping", x, y, 60, 10);
    }

    @Override
    public void render(FontRenderer fr) {
        if (!visible) return;

        int ping = 0;
        if (mc.getNetHandler() != null && mc.thePlayer != null) {
            net.minecraft.client.network.NetworkPlayerInfo info =
                    mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID());
            if (info != null) {
                ping = info.getResponseTime();
            }
        }

        String text = "Ping: " + ping + "ms";
        int color = getPingColor(ping);
        this.width = fr.getStringWidth(text);
        fr.drawStringWithShadow(text, x, y, color);
    }

    @Override
    public String getDisplayText() {
        int ping = 0;
        if (mc.getNetHandler() != null && mc.thePlayer != null) {
            net.minecraft.client.network.NetworkPlayerInfo info =
                    mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID());
            if (info != null) {
                ping = info.getResponseTime();
            }
        }
        return "Ping: " + ping + "ms";
    }

    private int getPingColor(int ping) {
        if (ping < 50) return 0x00FF00;
        if (ping < 100) return 0xFFFF00;
        return 0xFF0000;
    }
}