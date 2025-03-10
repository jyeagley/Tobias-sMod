package net.meanmon13.tobiassmod.block;

import net.meanmon13.tobiassmod.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.phys.AABB;


import javax.annotation.Nullable;

public class KillButton extends ButtonBlock {

    public KillButton(BlockBehaviour.Properties properties)
    {
        super(BlockSetType.OAK, 10, properties);
    }

    @Override
    public void press(BlockState state, Level level, BlockPos pos, @Nullable Player player)
    {
        if (!level.isClientSide && level instanceof ServerLevel serverLevel)
        {
            int radius = Config.killButtonRadius;
            AABB boundingBox = new AABB(pos).inflate(radius);

            for (LivingEntity entity : serverLevel.getEntitiesOfClass(LivingEntity.class, boundingBox))
            {
                if (entity instanceof Player)
                {
                    // Don't kill the players!!!!
                    continue;
                }

                entity.hurt(serverLevel.damageSources().magic(), Float.MAX_VALUE);
            }

            // Play Sound effect
            level.playSound(null, pos, SoundEvents.ZOMBIFIED_PIGLIN_DEATH, SoundSource.BLOCKS, 1.0f, 1.0f);

            super.press(state, level, pos, player);
        }
    }

}
