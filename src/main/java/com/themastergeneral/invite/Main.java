package com.themastergeneral.invite;

import com.themastergeneral.invite.commands.CommandInvite;
import com.themastergeneral.invite.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION, acceptableRemoteVersions = Main.acceptableRemoteVersion)
public class Main 
{
    public static final String MODID = "invite";
    public static final String MODNAME = "Backslash Invite";
    public static final String VERSION = "1.1";
    public static final String acceptableRemoteVersion = "*";
    
    @Instance
    public static Main instance = new Main();
    
    @SidedProxy(clientSide="com.themastergeneral.invite.proxy.ClientProxy", serverSide="com.themastergeneral.invite.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) 
    {
    	proxy.preInit(e);
    }
    @EventHandler
    public void init(FMLInitializationEvent e) 
    {
    	proxy.init(e);
    }
        
    @EventHandler
    public void postInit(FMLPostInitializationEvent e) 
    {
    	proxy.postInit(e);
    }
    @EventHandler
    public void serverLoad(FMLServerStartingEvent e)
    {
    	e.registerServerCommand(new CommandInvite());
    }
}
