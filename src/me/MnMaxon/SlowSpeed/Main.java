package me.MnMaxon.SlowSpeed;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
	public static String dataFolder;
	public static Main plugin;
	public static SuperYaml MainConfig;

	@Override
	public void onEnable() {
		plugin = this;
		dataFolder = this.getDataFolder().getAbsolutePath();
		reloadConfigs();
		getServer().getPluginManager().registerEvents(new MainListener(), this);
	}

	public static void reloadConfigs() {
		MainConfig = new SuperYaml(dataFolder + "/Config.yml");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You need to be a player to do this!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("Example") || cmd.getName().equalsIgnoreCase("Ex")) {
		} else
			displayHelp(p);
		return true;
	}

	private void displayHelp(CommandSender s) {
		s.sendMessage(ChatColor.AQUA + "========= Example =========");
		s.sendMessage(ChatColor.DARK_PURPLE + "/Command set <NAME>");
	}
}