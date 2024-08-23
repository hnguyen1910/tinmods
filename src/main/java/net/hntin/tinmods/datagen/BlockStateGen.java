package net.hntin.tinmods.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.hntin.tinmods.TinMods;
import net.hntin.tinmods.block.ModBlocks;

public class BlockStateGen extends BlockStateProvider {
    public BlockStateGen(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TinMods.MOD_ID, exFileHelper);
    }

    private static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;

    @Override
    protected void registerStatesAndModels() {
        getVariantBuilder(ModBlocks.THRONE_BLOCK.get())
                .forAllStates(blockState ->
                        ConfiguredModel.builder()
                                .modelFile(models().getExistingFile(modLoc("block/throne")))
                                .rotationY((int) blockState.getValue(HORIZONTAL_FACING).toYRot())
                                .build()
                );
        simpleBlockItem(ModBlocks.THRONE_BLOCK.get(),models().getExistingFile(modLoc("block/throne")));
    }




    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }
}
