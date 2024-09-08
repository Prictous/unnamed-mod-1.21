package net.quilters.unnamedmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.quilters.unnamedmod.UnnamedMod;

import java.util.List;

public class LightningStickItem extends Item {
    public LightningStickItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        //Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        if(!world.isClient()){
            context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity)context.getPlayer()),
                    item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
            LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(world);
            world.spawnEntity(lightningEntity);
            lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(context.getBlockPos()));
        }

        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("itemTooltip.unnamed-mod.lightning_stick").formatted(Formatting.GOLD));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
