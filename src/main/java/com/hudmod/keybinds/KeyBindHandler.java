package com.hudmod.keybinds;

import com.hudmod.gui.HUDSettingsScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class KeyBindHandler {

    public static final KeyBinding openHUDSettings = new KeyBinding("Open HUD Settings", Keyboard.KEY_H, "HUD Mod");

    public KeyBindHandler() {
        ClientRegistry.registerKeyBinding(openHUDSettings);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (openHUDSettings.isPressed()) {
            Minecraft.getMinecraft().displayGuiScreen(new HUDSettingsScreen(Minecraft.getMinecraft().currentScreen));
        }
    }
}