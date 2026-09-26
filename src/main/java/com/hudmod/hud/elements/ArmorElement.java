package com.hudmod.hud.elements;

import com.hudmod.hud.HUDElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ArmorElement extends HUDElement {

    private Minecraft mc = Minecraft.getMinecraft();

    public ArmorElement(int x, int y) {
        super("Armor", x, y, 80, 10);
    }

    @Override
    public void render(FontRenderer fr) {
        if (!visible || mc.thePlayer == null) return;

        EntityPlayer player = mc.thePlayer;
        int total = 0;
        for (ItemStack stack : player.inventory.armorInventory) {
            if (stack != null) {
                total += stack.getMaxDamage() - stack.getItemDamage();
            }
        }

        String text = "Armor: " + total;
        this.width = fr.getStringWidth(text);
        fr.drawStringWithShadow(text, x, y, 0xFFFF00);
    }

    @Override
    public String getDisplayText() {
        if (mc.thePlayer == null) return "Armor: 0";
        EntityPlayer player = mc.thePlayer;
        int total = 0;
        for (ItemStack stack : player.inventory.armorInventory) {
            if (stack != null) {
                total += stack.getMaxDamage() - stack.getItemDamage();
            }
        }
        return "Armor: " + total;
    }
}