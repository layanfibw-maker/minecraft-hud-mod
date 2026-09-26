package com.hudmod.gui;

import com.hudmod.hud.HUDElement;
import com.hudmod.hud.HUDManager;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

public class HUDSettingsScreen extends GuiScreen {

    private final GuiScreen parent;
    private final HUDManager hudManager = HUDManager.getInstance();
    private int scrollOffset = 0;

    public HUDSettingsScreen(GuiScreen parent) {
        this.parent = parent;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        int y = 40;
        int buttonWidth = 200;

        for (HUDElement element : hudManager.getElements()) {
            String label = element.name + ": " + (element.visible ? "ON" : "OFF");
            this.buttonList.add(new GuiButton(element.name.hashCode(), this.width / 2 - buttonWidth / 2, y, buttonWidth, 20, label));
            y += 25;
        }

        y += 10;
        this.buttonList.add(new GuiButton(999, this.width / 2 - buttonWidth / 2, y, buttonWidth, 20, "Edit Positions"));
        this.buttonList.add(new GuiButton(1000, this.width / 2 - buttonWidth / 2, this.height - 30, buttonWidth, 20, "Back"));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, "HUD Settings", this.width / 2, 10, 0xFFFFFF);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 999) {
            this.mc.displayGuiScreen(new HUDEditorScreen(this));
        } else if (button.id == 1000) {
            this.mc.displayGuiScreen(parent);
        } else {
            HUDElement element = hudManager.getElementByName(getElementNameByHashCode(button.id));
            if (element != null) {
                element.visible = !element.visible;
                button.displayString = element.name + ": " + (element.visible ? "ON" : "OFF");
            }
        }
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) {
        if (keyCode == Keyboard.KEY_ESCAPE) {
            this.mc.displayGuiScreen(parent);
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }

    private String getElementNameByHashCode(int hashCode) {
        for (HUDElement element : hudManager.getElements()) {
            if (element.name.hashCode() == hashCode) {
                return element.name;
            }
        }
        return "";
    }
}