package com.hudmod.hud;

import net.minecraft.client.gui.FontRenderer;

public abstract class HUDElement {

    public int x;
    public int y;
    public String name;
    public boolean visible;
    public int width;
    public int height;

    public HUDElement(String name, int x, int y, int width, int height) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.visible = true;
    }

    public abstract void render(FontRenderer fr);

    public abstract String getDisplayText();

    public boolean isMouseOver(int mouseX, int mouseY) {
        return mouseX >= this.x && mouseX <= this.x + this.width &&
               mouseY >= this.y && mouseY <= this.y + this.height;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}