package me.give_me_moneyz.binding.core.capability;

import me.give_me_moneyz.binding.core.interfaces.IAllayCapability;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.*;

public class MagnetismCapability implements IAllayCapability {
    public static final Capability<MagnetismCapability> INSTANCE = CapabilityManager.get(new CapabilityToken<>(){});
    private Player player;
    private boolean ismagneting;

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    @Override
    public boolean ismagneting() {
        return this.ismagneting;
    }

    @Override
    public void setmagneting(boolean magneting) {
        this.ismagneting = magneting;
    }
}