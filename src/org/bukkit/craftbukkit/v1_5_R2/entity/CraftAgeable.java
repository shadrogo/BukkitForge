package org.bukkit.craftbukkit.v1_5_R2.entity;

import net.minecraft.entity.EntityAgeable;

import org.bukkit.craftbukkit.v1_5_R2.CraftServer;
import org.bukkit.entity.Ageable;
//import org.bukkit.craftbukkit.CraftServer;

public class CraftAgeable extends CraftCreature implements Ageable {
    public CraftAgeable(CraftServer server, EntityAgeable entity) {
        super(server, entity);
    }

    public int getAge() {
        return getHandle().getAge();
    }

    public void setAge(int age) {
        getHandle().ticksExisted = (age);
    }

    public void setAgeLock(boolean lock) {
        //getHandle() = lock;
    }

    public boolean getAgeLock() {
        return false;
    }

    public void setBaby() {
        if (isAdult()) {
            setAge(-24000);
        }
    }

    public void setAdult() {
        if (!isAdult()) {
            setAge(0);
        }
    }

    public boolean isAdult() {
        return getAge() >= 0;
    }


    public boolean canBreed() {
        return getAge() == 0;
    }

    public void setBreed(boolean breed) {
        if (breed) {
            setAge(0);
        } else if (isAdult()) {
            setAge(6000);
        }
    }
    
    @Override
    public EntityAgeable getHandle() {
        return (EntityAgeable) entity;
    }
    
    @Override
    public String toString() {
        return "CraftAgeable";
    }
}
