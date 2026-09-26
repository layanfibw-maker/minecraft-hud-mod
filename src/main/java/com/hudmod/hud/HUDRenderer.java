package com.hudmod.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class HUDRenderer {

    private final Minecraft mc = Minecraft.getMinecraft();
    private final HUDManager hudManager = HUDManager.getInstance();

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {
        if (event.isCanceled()) return;

        FontRenderer fr = mc.fontRendererObj;

        for (HUDElement element : hudManager.getElements()) {
            if (element.visible) {
                element.render(fr);
            }
        }
    }
}