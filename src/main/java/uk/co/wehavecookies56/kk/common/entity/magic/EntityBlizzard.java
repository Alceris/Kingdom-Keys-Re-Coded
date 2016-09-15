package uk.co.wehavecookies56.kk.common.entity.magic;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.client.core.handler.InputHandler;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnBlizzardParticles;

public class EntityBlizzard extends EntityThrowable {
	public EntityLivingBase shootingEntity;

	public EntityBlizzard (World world) {
		super(world);
	}

	public EntityBlizzard (World world, EntityLivingBase entity) {
		super(world, entity);
		shootingEntity = entity;
	}

	public EntityBlizzard (World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	@Override
	protected float getGravityVelocity () {
		return 0.0F;
	}

	@Override
	public void onUpdate () {
		super.onUpdate();
		if (shootingEntity == null) return;
		if (shootingEntity instanceof EntityPlayer)
		{
			if (!worldObj.isRemote) 
				PacketDispatcher.sendToAllAround(new SpawnBlizzardParticles(this, 1), (EntityPlayer) shootingEntity, 64.0D);
			if(InputHandler.lockOn != null)
			{
				EntityLiving target = (EntityLiving)InputHandler.lockOn;
				setThrowableHeading(target.posX - this.posX, target.posY - this.posY + target.height, target.posZ - this.posZ, 1.5f, 0);	
			}
		}else{
			if (!worldObj.isRemote) 
				PacketDispatcher.sendToAllAround(new SpawnBlizzardParticles(this,1), dimension, this.posX, this.posY, this.posZ, 64D);
		}
		if (ticksExisted > 60) setDead();
	}

	@Override
	protected void onImpact (RayTraceResult movingObject) {
		if (!this.worldObj.isRemote) {
			if (movingObject.entityHit != null) {
				if (movingObject.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), 8)) {
					applyEnchantments(this.shootingEntity, movingObject.entityHit);
					if (movingObject.entityHit.isBurning())
						movingObject.entityHit.extinguish();
					else
						if (shootingEntity instanceof EntityPlayer)
							movingObject.entityHit.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) shootingEntity), DamageCalculation.getMagicDamage((EntityPlayer) shootingEntity, 1));
						else
							movingObject.entityHit.attackEntityFrom(DamageSource.causeMobDamage(shootingEntity), 5);
				}
			} else {

				if (this.shootingEntity != null) {
					BlockPos blockpos = movingObject.getBlockPos().offset(movingObject.sideHit);
					if (this.worldObj.getBlockState(blockpos).getBlock() == Blocks.WATER)
						this.worldObj.setBlockState(blockpos, Blocks.ICE.getDefaultState());
					else if (this.worldObj.getBlockState(blockpos).getBlock() == Blocks.FIRE)
						this.worldObj.setBlockState(blockpos, Blocks.AIR.getDefaultState());
					else if (this.worldObj.getBlockState(blockpos).getBlock() == Blocks.LAVA) this.worldObj.setBlockState(blockpos, Blocks.OBSIDIAN.getDefaultState());
				}
			}
			setDead();
		}
	}
}
