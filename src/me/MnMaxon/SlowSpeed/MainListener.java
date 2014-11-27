package me.MnMaxon.SlowSpeed;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MainListener implements Listener {
	@EventHandler
	public void onSprint(PlayerToggleSprintEvent e) {
		final Player p = e.getPlayer();
		if (!e.isSprinting()) {
			p.removePotionEffect(PotionEffectType.SPEED);
			MetaLists.quickPlayer.remove(p);
		} else {
			loop(p);
		}
	}

	private void loop(final Player p) {
		final double random = new Random().nextDouble();
		MetaLists.quickPlayer.add(p, random);
		int speed = -1;
		for (PotionEffect effect : p.getActivePotionEffects())
			if (effect.getType().equals(PotionEffectType.SPEED))
				speed = effect.getAmplifier();
		speed = speed + 1;
		if (speed == 5)
			return;
		final int time = 5;
		final int fSpeed = speed;
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
			public void run() {
				if (MetaLists.quickPlayer.contains(p) && ((double) MetaLists.quickPlayer.get(p)) == random) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, fSpeed), true);
					MetaLists.quickPlayer.remove(p);
					loop(p);
				}
			}
		}, time * 20L);
	}
}
