package me.MnMaxon.SlowSpeed;

import org.bukkit.entity.Entity;
import org.bukkit.metadata.FixedMetadataValue;

public class MetaLists {
	public static MetaLists quickPlayer = new MetaLists("quickPlayer");

	private String name;

	public MetaLists(String name) {
		this.name = name;
	}

	public Boolean contains(Entity ent) {
		if (ent == null)
			return false;
		return ent.hasMetadata(getName());
	}

	public Object get(Entity ent) {
		if (ent == null)
			return null;
		return ent.getMetadata(getName()).get(0).value();
	}

	public void add(Entity ent) {
		if (ent == null)
			return;
		add(ent, true);
	}

	public void add(Entity ent, Object object) {
		if (ent == null)
			return;
		ent.setMetadata(getName(), new FixedMetadataValue(Main.plugin, object));
	}

	public void remove(Entity ent) {
		if (ent == null)
			return;
		ent.removeMetadata(getName(), Main.plugin);
	}

	public String getName() {
		return name;
	}
}