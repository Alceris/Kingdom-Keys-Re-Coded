package uk.co.wehavecookies56.kk.common.entity.mobs;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.lib.GuiIDs;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMunnyData;

/**
 * Created by Toby on 19/08/2016.
 */
public class EntityMoogle extends EntityCreature implements IKHMob {

    public EntityMoogle(World worldIn) {
        super(worldIn);
        this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 1.0F));
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }

    @Override
    protected void entityInit() {
        super.entityInit();
    }

    @Override
    public boolean isAIDisabled() {
        return false;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    }

    @Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand) {
        if(!player.isSneaking()) {
            this.world.playSound(player, this.posX, this.posY, this.posZ, ModSounds.kupo, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!this.world.isRemote) {
                PacketDispatcher.sendTo(new SyncMunnyData(player.getCapability(ModCapabilities.MUNNY, null)), (EntityPlayerMP) player);
            }
            player.openGui(KingdomKeys.instance, GuiIDs.GUI_SHOP, this.world, (int) this.posX, (int) this.posY, (int) this.posZ);
            return true;
        }
        return false;
    }

    @Override
    public EntityHelper.MobType getType() {
        return EntityHelper.MobType.NPC;
    }
    
    @Override
    public SoundEvent getAmbientSound()
    {
        return ModSounds.kupoliving;
    }
}
