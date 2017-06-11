package com.themastergeneral.invite.commands;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import com.themastergeneral.invite.Main;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class CommandInvite extends CommandBase
{ 
    protected String fullEntityName;
    public CommandInvite()
    {
        aliases = Lists.newArrayList(Main.MODID, "invite", "INVITE");
    }
    private final List<String> aliases;
	public int compareTo(ICommand o) 
	{
		return 0;
	}
	@Nonnull
	public String getCommandName() 
	{ 
		return "invite";
	}
	@Override
	public String getUsage(ICommandSender sender) 
	{
		return "invite <username>";
	}
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if (args.length == 1 && args[0].length() > 0)
        {
			GameProfile gameprofile = server.getPlayerProfileCache().getGameProfileForUsername(args[0]);
            if (gameprofile == null)
            {
                throw new CommandException("commands.whitelist.add.failed", new Object[] {args[0]});
            }
            server.getPlayerList().addWhitelistedPlayer(gameprofile);
            notifyCommandListener(sender, this, "commands.whitelist.add.success", new Object[] {args[0]});
        }
        else
        {
            throw new WrongUsageException("/invite <username>", new Object[0]);
        }
		
	}
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) 
	{
		return true;
	}
	public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos) 
	{
		return null;
	}
	public boolean isUsernameIndex(String[] args, int index) 
	{
		return false;
	}
	@Nonnull
	public List<String> getCommandAliases() 
	{
		return aliases;
	}
	@Override
	public String getName() 
	{
		return "invite";
	}
	public int getRequiredPermissionLevel()
    {
        return 0;
    }
}
