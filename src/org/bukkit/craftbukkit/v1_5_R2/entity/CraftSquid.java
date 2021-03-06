package org.bukkit.craftbukkit.v1_5_R2.entity;

import net.minecraft.entity.passive.EntitySquid;

import org.bukkit.craftbukkit.v1_5_R2.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Squid;
//import org.bukkit.craftbukkit.CraftServer;

public class CraftSquid extends CraftWaterMob implements Squid {

    public CraftSquid(CraftServer server, EntitySquid entity) {
        super(server, entity);
    }

    @Override
    public EntitySquid getHandle() {
        return (EntitySquid) entity;
    }

    @Override
    public String toString() {
        return "CraftSquid";
    }

    public EntityType getType() {
        return EntityType.SQUID;
    }
}
