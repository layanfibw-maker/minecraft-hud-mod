package com.hudmod.gui;

import com.hudmod.hud.HUDElement;
import com.hudmod.hud.HUDManager;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class HUDEditorScreen extends GuiScreen {

    private final GuiScreen parent;
    private final HUDManager hudManager = HUDManager.getInstance();
    private HUDElement draggingElement = null;
    private int dragOffsetX = 0;
    private int dragOffsetY = 0;

    public HUDEditorScreen(GuiScreen parent) {
        this.parent = parent;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        int y = this.height - 50;
        int buttonWidth = 100;
        int spacing = 110;

        this.buttonList.add(new GuiButton(0, this.width / 2 - spacing - buttonWidth / 2, y, buttonWidth, 20, "Reset"));
        this.buttonList.add(new GuiButton(1, this.width / 2 - buttonWidth / 2, y, buttonWidth, 20, "Save"));
        this.buttonList.add(new GuiButton(2, this.width / 2 + spacing - buttonWidth / 2, y, buttonWidth, 20, "Back"));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        GlStateManager.enableBlend();

        // Draw background
        drawRect(0, 0, this.width, this.height, 0x80000000);

        // Draw elements with outlines
        for (HUDElement element : hudManager.getElements()) {
            if (element.visible) {
                element.render(this.fontRendererObj);
                // Draw selection box
                int color = draggingElement == element ? 0xFF00FF00 : 0xFF00FFFF;
                drawRect(element.x - 2, element.y - 2, element.x + element.width + 2, element.y + element.height + 2, color);
            }
        }

        // Draw title
        this.drawCenteredString(this.fontRendererObj, "HUD Editor - Drag elements to reposition", this.width / 2, 10, 0xFFFFFF);
        this.drawString(this.fontRendererObj, "Mouse: " + mouseX + ", " + mouseY, 10, 30, 0xFFFFFF);

        GlStateManager.disableBlend();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        super.mouseClicked(mouseX, mouseY, mouseButton);

        if (mouseButton == 0) { // Left click
            draggingElement = hudManager.getElementAt(mouseX, mouseY);
            if (draggingElement != null) {
                dragOffsetX = mouseX - draggingElement.x;
                dragOffsetY = mouseY - draggingElement.y;
            }
        }
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
        if (state == 0) {
            draggingElement = null;
        }
    }

    @Override
    public void handleMouseInput() {
        super.handleMouseInput();

        int mouseX = Mouse.getEventX() * this.width / this.mc.displayWidth;
        int mouseY = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;

        if (Mouse.isButtonDown(0) && draggingElement != null) {
            int newX = mouseX - dragOffsetX;
            int newY = mouseY - dragOffsetY;

            // Clamp to screen
            newX = Math.max(0, Math.min(newX, this.width - draggingElement.width));
            newY = Math.max(0, Math.min(newY, this.height - draggingElement.height));

            draggingElement.setPosition(newX, newY);
        }
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) { // Reset
            hudManager.getElements().clear();
            hudManager.initElements();
        } else if (button.id == 1) { // Save
            hudManager.savePositions();
            this.mc.displayGuiScreen(parent);
        } else if (button.id == 2) { // Back
            this.mc.displayGuiScreen(parent);
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
}
