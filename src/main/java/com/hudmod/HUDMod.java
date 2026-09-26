package com.hudmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = HUDMod.MODID, name = HUDMod.NAME, version = HUDMod.VERSION)
public class HUDMod {

    public static final String MODID = "hudmod";
    public static final String NAME = "Lunar HUD Mod";
    public static final String VERSION = "1.0.0";

    @SidedProxy(clientSide = "com.hudmod.ClientProxy", serverSide = "com.hudmod.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }
}