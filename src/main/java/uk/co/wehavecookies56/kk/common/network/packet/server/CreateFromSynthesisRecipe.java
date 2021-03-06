package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.api.recipes.FreeDevRecipeRegistry;
import uk.co.wehavecookies56.kk.api.recipes.Recipe;
import uk.co.wehavecookies56.kk.api.recipes.RecipeRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SynthesisMaterialCapability;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMaterialData;

public class CreateFromSynthesisRecipe extends AbstractMessage.AbstractServerMessage<CreateFromSynthesisRecipe> {

    public CreateFromSynthesisRecipe () {}

    String name;
    int amountToRemove;

    public CreateFromSynthesisRecipe (String name, int amountToRemove) {
        this.name = name;
        this.amountToRemove = amountToRemove;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        this.name = buffer.readString(100);
        this.amountToRemove = buffer.readInt();
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeString(name);
        buffer.writeInt(amountToRemove);
    }

    @Override
    public void process (EntityPlayer player, Side side) {
        boolean freeDev = false;
        if (FreeDevRecipeRegistry.isFreeDevRecipeRegistered(name)) {
            freeDev = true;
        }
        if (!freeDev) {
            if (RecipeRegistry.get(name).getResult().getItem() instanceof ItemKeychain)
            player.inventory.addItemStackToInventory(RecipeRegistry.get(name).getResult());
            Recipe r = RecipeRegistry.get(name);
            SynthesisMaterialCapability.ISynthesisMaterial MATS = player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null);
            Iterator it = r.getRequirements().entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry<Material, Integer> pair = (Map.Entry<Material, Integer>) it.next();
                MATS.removeMaterial(pair.getKey(), pair.getValue());
            }
        } else {
            player.inventory.addItemStackToInventory(FreeDevRecipeRegistry.get(name).getResult());
            Recipe r = FreeDevRecipeRegistry.get(name);
            SynthesisMaterialCapability.ISynthesisMaterial MATS = player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null);
            Iterator it = r.getRequirements().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Material, Integer> pair = (Map.Entry<Material, Integer>) it.next();
                MATS.removeMaterial(pair.getKey(), pair.getValue());
            }
        }
        PacketDispatcher.sendTo(new SyncMaterialData(player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null)), (EntityPlayerMP) player);

    }

}
