package com.hudmod.hud.elements;

import com.hudmod.hud.HUDElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class FPSElement extends HUDElement {

    private int lastFPS = 0;
    private long lastTime = System.currentTimeMillis();

    public FPSElement(int x, int y) {
        super("FPS", x, y, 50, 10);
    }

    @Override
    public void render(FontRenderer fr) {
        if (!visible) return;

        long now = System.currentTimeMillis();
        if (now - lastTime >= 1000) {
            lastFPS = Minecraft.getDebugFPS();
            lastTime = now;
        }

        String text = "FPS: " + lastFPS;
        int color = getFPSColor(lastFPS);
        this.width = fr.getStringWidth(text);
        fr.drawStringWithShadow(text, x, y, color);
    }

    @Override
    public String getDisplayText() {
        return "FPS: " + lastFPS;
    }

    private int getFPSColor(int fps) {
        if (fps >= 60) return 0x00FF00;
        if (fps >= 30) return 0xFFFF00;
        return 0xFF0000;
    }
}