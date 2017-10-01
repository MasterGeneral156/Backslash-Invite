package com.themastergeneral.invite;

import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import org.apache.logging.log4j.Logger;

import com.themastergeneral.invite.commands.CommandInvite;
import com.themastergeneral.invite.proxy.CommonProxy;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION, acceptableRemoteVersions = Main.acceptableRemoteVersion, updateJSON = Main.updateJSON, certificateFingerprint = Main.Fingerprint)
public class Main {
	public static final String MODID = "invite";
	public static final String MODNAME = "Backslash Invite";
	public static final String VERSION = "1.2";
	public static final String acceptableRemoteVersion = "*";
	public static final String Fingerprint = "441b509a0f58a0ef41aca8daf1be20d96287635e";
	public static final String updateJSON = "https://raw.githubusercontent.com/MasterGeneral156/Version/master/Backslash-Invite.json";

	@Instance
	public static Main instance = new Main();
	public static Logger logger;

	@SidedProxy(clientSide = "com.themastergeneral.invite.proxy.ClientProxy", serverSide = "com.themastergeneral.invite.proxy.ServerProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		logger = e.getModLog();
		logger.info("Backslash Invite is loading... are you ready to invite your friends?!");
		logger.info("Aye, aye captain!");
		logger.info("I can't hear you!");
		logger.info("AYE, AYE CAPTAIN!");
		logger.info("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
		logger.info("Backslash Invite has loaded completely.");
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent e) {
		e.registerServerCommand(new CommandInvite());
	}

	@EventHandler
	public void onFingerprintViolation(FMLFingerprintViolationEvent e) {
		FMLLog.warning("Invalid fingerprint detected for Backslash Invite! TheMasterGeneral will not support this version!");
	}
}
