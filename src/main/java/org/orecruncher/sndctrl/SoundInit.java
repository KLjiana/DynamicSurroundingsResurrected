package org.orecruncher.sndctrl;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.orecruncher.environs.Environs;
import org.orecruncher.mobeffects.MobEffects;
import org.orecruncher.mobeffects.library.Constants;

public class SoundInit {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MobEffects.MOD_ID);

    public static final RegistryObject<SoundEvent> SWORD_SWING = SOUNDS.register(Constants.SWORD_SWING.getPath(), () -> new SoundEvent(Constants.SWORD_SWING));
    public static final RegistryObject<SoundEvent> AXE_SWING = SOUNDS.register(Constants.AXE_SWING.getPath(), () -> new SoundEvent(Constants.AXE_SWING));
    public static final RegistryObject<SoundEvent> SWORD_EQUIP = SOUNDS.register(Constants.SWORD_EQUIP.getPath(), () -> new SoundEvent(Constants.SWORD_EQUIP));
    public static final RegistryObject<SoundEvent> AXE_EQUIP = SOUNDS.register(Constants.AXE_EQUIP.getPath(), () -> new SoundEvent(Constants.AXE_EQUIP));
    public static final RegistryObject<SoundEvent> UTILITY_EQUIP = SOUNDS.register(Constants.UTILITY_EQUIP.getPath(), () -> new SoundEvent(Constants.UTILITY_EQUIP));
    public static final RegistryObject<SoundEvent> BOW_EQUIP = SOUNDS.register(Constants.BOW_EQUIP.getPath(), () -> new SoundEvent(Constants.BOW_EQUIP));
    public static final RegistryObject<SoundEvent> BOW_PULL = SOUNDS.register(Constants.BOW_PULL.getPath(), () -> new SoundEvent(Constants.BOW_PULL));
    public static final RegistryObject<SoundEvent> WATER_WATER_THROUGH= SOUNDS.register("water.water_through", () -> new SoundEvent(new ResourceLocation("mobeffects:water.water_through")));
    public static final RegistryObject<SoundEvent> WATER_STEREOFIX_WATER_THROUGH= SOUNDS.register("water_stereofix.water_through", () -> new SoundEvent(new ResourceLocation("mobeffects:water_stereofix.water_through")));
    public static final RegistryObject<SoundEvent> WATER_WATER_WANDER= SOUNDS.register("water.water_wander", () -> new SoundEvent(new ResourceLocation("mobeffects:water.water_wander")));
    public static final RegistryObject<SoundEvent> WATER_STEREOFIX_WATER_WANDER= SOUNDS.register("water_stereofix.water_wander", () -> new SoundEvent(new ResourceLocation("mobeffects:water_stereofix.water_wander")));
    public static final RegistryObject<SoundEvent> ARMOR_LIGHT_WALK= SOUNDS.register("armor.light_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:armor.light_walk")));
    public static final RegistryObject<SoundEvent> ARMOR_LIGHT_RUN= SOUNDS.register("armor.light_run", () -> new SoundEvent(new ResourceLocation("mobeffects:armor.light_run")));
    public static final RegistryObject<SoundEvent> ARMOR_MEDIUM_WALK= SOUNDS.register("armor.medium_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:armor.medium_walk")));
    public static final RegistryObject<SoundEvent> ARMOR_MEDIUM_RUN= SOUNDS.register("armor.medium_run", () -> new SoundEvent(new ResourceLocation("mobeffects:armor.medium_run")));
    public static final RegistryObject<SoundEvent> ARMOR_MEDIUM_FOOT= SOUNDS.register("armor.medium_foot", () -> new SoundEvent(new ResourceLocation("mobeffects:armor.medium_foot")));
    public static final RegistryObject<SoundEvent> ARMOR_CRYSTAL_WALK= SOUNDS.register("armor.crystal_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:armor.crystal_walk")));
    public static final RegistryObject<SoundEvent> ARMOR_CRYSTAL_RUN= SOUNDS.register("armor.crystal_run", () -> new SoundEvent(new ResourceLocation("mobeffects:armor.crystal_run")));
    public static final RegistryObject<SoundEvent> ARMOR_CRYSTAL_FOOT= SOUNDS.register("armor.crystal_foot", () -> new SoundEvent(new ResourceLocation("mobeffects:armor.crystal_foot")));
    public static final RegistryObject<SoundEvent> ARMOR_HEAVY_WALK= SOUNDS.register("armor.heavy_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:armor.heavy_walk")));
    public static final RegistryObject<SoundEvent> ARMOR_HEAVY_RUN= SOUNDS.register("armor.heavy_run", () -> new SoundEvent(new ResourceLocation("mobeffects:armor.heavy_run")));
    public static final RegistryObject<SoundEvent> ARMOR_HEAVY_FOOT= SOUNDS.register("armor.heavy_foot", () -> new SoundEvent(new ResourceLocation("mobeffects:armor.heavy_foot")));
    public static final RegistryObject<SoundEvent> ARMOR_SLIMEY_WALK= SOUNDS.register("armor.slimey_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:armor.slimey_walk")));
    public static final RegistryObject<SoundEvent> ARMOR_SLIMEY_RUN= SOUNDS.register("armor.slimey_run", () -> new SoundEvent(new ResourceLocation("mobeffects:armor.slimey_run")));
    public static final RegistryObject<SoundEvent> LEAVES_LEAVES_THROUGH= SOUNDS.register("leaves.leaves_through", () -> new SoundEvent(new ResourceLocation("mobeffects:leaves.leaves_through")));
    public static final RegistryObject<SoundEvent> BRUSH_BRUSH_THROUGH= SOUNDS.register("brush.brush_through", () -> new SoundEvent(new ResourceLocation("mobeffects:brush.brush_through")));
    public static final RegistryObject<SoundEvent> METALBAR_METALBAR_RUN= SOUNDS.register("metalbar.metalbar_run", () -> new SoundEvent(new ResourceLocation("mobeffects:metalbar.metalbar_run")));
    public static final RegistryObject<SoundEvent> GRASS_GRASS_WALK= SOUNDS.register("grass.grass_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:grass.grass_walk")));
    public static final RegistryObject<SoundEvent> GRASS_GRASS_RUN= SOUNDS.register("grass.grass_run", () -> new SoundEvent(new ResourceLocation("mobeffects:grass.grass_run")));
    public static final RegistryObject<SoundEvent> GRASS_GRASS_WANDER= SOUNDS.register("grass.grass_wander", () -> new SoundEvent(new ResourceLocation("mobeffects:grass.grass_wander")));
    public static final RegistryObject<SoundEvent> MUD_MUD_WALK= SOUNDS.register("mud.mud_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:mud.mud_walk")));
    public static final RegistryObject<SoundEvent> DIRT_DIRT_WANDER= SOUNDS.register("dirt.dirt_wander", () -> new SoundEvent(new ResourceLocation("mobeffects:dirt.dirt_wander")));
    public static final RegistryObject<SoundEvent> MUD_MUD_WANDER= SOUNDS.register("mud.mud_wander", () -> new SoundEvent(new ResourceLocation("mobeffects:mud.mud_wander")));
    public static final RegistryObject<SoundEvent> DIRT_DIRT_WALK= SOUNDS.register("dirt.dirt_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:dirt.dirt_walk")));
    public static final RegistryObject<SoundEvent> DIRT_DIRT_RUN= SOUNDS.register("dirt.dirt_run", () -> new SoundEvent(new ResourceLocation("mobeffects:dirt.dirt_run")));
    public static final RegistryObject<SoundEvent> DIRT_DIRT_LAND= SOUNDS.register("dirt.dirt_land", () -> new SoundEvent(new ResourceLocation("mobeffects:dirt.dirt_land")));
    public static final RegistryObject<SoundEvent> STONE_STONE_RUN= SOUNDS.register("stone.stone_run", () -> new SoundEvent(new ResourceLocation("mobeffects:stone.stone_run")));
    public static final RegistryObject<SoundEvent> STONE_STONE_WALK= SOUNDS.register("stone.stone_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:stone.stone_walk")));
    public static final RegistryObject<SoundEvent> STONE_STONE_WANDER= SOUNDS.register("stone.stone_wander", () -> new SoundEvent(new ResourceLocation("mobeffects:stone.stone_wander")));
    public static final RegistryObject<SoundEvent> CONCRETE_CONCRETE_RUN= SOUNDS.register("concrete.concrete_run", () -> new SoundEvent(new ResourceLocation("mobeffects:concrete.concrete_run")));
    public static final RegistryObject<SoundEvent> WOOD_WOOD_WALK= SOUNDS.register("wood.wood_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:wood.wood_walk")));
    public static final RegistryObject<SoundEvent> FLOORSQUEAK= SOUNDS.register("floorsqueak", () -> new SoundEvent(new ResourceLocation("mobeffects:floorsqueak")));
    public static final RegistryObject<SoundEvent> WOOD_LOG_WALK= SOUNDS.register("wood.log_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:wood.log_walk")));
    public static final RegistryObject<SoundEvent> SAND_SAND_WALK= SOUNDS.register("sand.sand_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:sand.sand_walk")));
    public static final RegistryObject<SoundEvent> SAND_SAND_RUN= SOUNDS.register("sand.sand_run", () -> new SoundEvent(new ResourceLocation("mobeffects:sand.sand_run")));
    public static final RegistryObject<SoundEvent> GRAVEL_GRAVEL_WALK= SOUNDS.register("gravel.gravel_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:gravel.gravel_walk")));
    public static final RegistryObject<SoundEvent> GRAVEL_GRAVEL_RUN= SOUNDS.register("gravel.gravel_run", () -> new SoundEvent(new ResourceLocation("mobeffects:gravel.gravel_run")));
    public static final RegistryObject<SoundEvent> GRAVEL_GRAVEL_WANDER= SOUNDS.register("gravel.gravel_wander", () -> new SoundEvent(new ResourceLocation("mobeffects:gravel.gravel_wander")));
    public static final RegistryObject<SoundEvent> GRAVEL_GRAVEL_LAND= SOUNDS.register("gravel.gravel_land", () -> new SoundEvent(new ResourceLocation("mobeffects:gravel.gravel_land")));
    public static final RegistryObject<SoundEvent> GLASS_GLASS_HIT= SOUNDS.register("glass.glass_hit", () -> new SoundEvent(new ResourceLocation("mobeffects:glass.glass_hit")));
    public static final RegistryObject<SoundEvent> GLASS_GLASS_HARD= SOUNDS.register("glass.glass_hard", () -> new SoundEvent(new ResourceLocation("mobeffects:glass.glass_hard")));
    public static final RegistryObject<SoundEvent> CONCRETE_CONCRETE_WALK= SOUNDS.register("concrete.concrete_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:concrete.concrete_walk")));
    public static final RegistryObject<SoundEvent> WEAKICE_WEAKICE_WALK= SOUNDS.register("weakice.weakice_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:weakice.weakice_walk")));
    public static final RegistryObject<SoundEvent> LINO_LINO_WALK= SOUNDS.register("lino.lino_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:lino.lino_walk")));
    public static final RegistryObject<SoundEvent> LINO_LINO_RUN= SOUNDS.register("lino.lino_run", () -> new SoundEvent(new ResourceLocation("mobeffects:lino.lino_run")));
    public static final RegistryObject<SoundEvent> MARBLE_MARBLE_WANDER= SOUNDS.register("marble.marble_wander", () -> new SoundEvent(new ResourceLocation("mobeffects:marble.marble_wander")));
    public static final RegistryObject<SoundEvent> CONCRETE_CONCRETE_WANDER= SOUNDS.register("concrete.concrete_wander", () -> new SoundEvent(new ResourceLocation("mobeffects:concrete.concrete_wander")));
    public static final RegistryObject<SoundEvent> BLUNTWOOD_BLUNTWOOD_WALK= SOUNDS.register("bluntwood.bluntwood_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:bluntwood.bluntwood_walk")));
    public static final RegistryObject<SoundEvent> BLUNTWOOD_BLUNTWOOD_WANDER= SOUNDS.register("bluntwood.bluntwood_wander", () -> new SoundEvent(new ResourceLocation("mobeffects:bluntwood.bluntwood_wander")));
    public static final RegistryObject<SoundEvent> RUG_RUG_WALK= SOUNDS.register("rug.rug_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:rug.rug_walk")));
    public static final RegistryObject<SoundEvent> METALBOX_METALBOX_WALK= SOUNDS.register("metalbox.metalbox_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:metalbox.metalbox_walk")));
    public static final RegistryObject<SoundEvent> METALBOX_METALBOX_RUN= SOUNDS.register("metalbox.metalbox_run", () -> new SoundEvent(new ResourceLocation("mobeffects:metalbox.metalbox_run")));
    public static final RegistryObject<SoundEvent> METALBOX_METALBOX_WANDER= SOUNDS.register("metalbox.metalbox_wander", () -> new SoundEvent(new ResourceLocation("mobeffects:metalbox.metalbox_wander")));
    public static final RegistryObject<SoundEvent> MARBLE_MARBLE_WALK= SOUNDS.register("marble.marble_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:marble.marble_walk")));
    public static final RegistryObject<SoundEvent> MARBLE_MARBLE_RUN= SOUNDS.register("marble.marble_run", () -> new SoundEvent(new ResourceLocation("mobeffects:marble.marble_run")));
    public static final RegistryObject<SoundEvent> METALBAR_METALBAR_WALK= SOUNDS.register("metalbar.metalbar_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:metalbar.metalbar_walk")));
    public static final RegistryObject<SoundEvent> METALBAR_METALBAR_WANDER= SOUNDS.register("metalbar.metalbar_wander", () -> new SoundEvent(new ResourceLocation("mobeffects:metalbar.metalbar_wander")));
    public static final RegistryObject<SoundEvent> SQUEAKYWOOD_SQUEAKYWOOD_WALK= SOUNDS.register("squeakywood.squeakywood_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:squeakywood.squeakywood_walk")));
    public static final RegistryObject<SoundEvent> SQUEAKYWOOD_SQUEAKYWOOD_WANDER= SOUNDS.register("squeakywood.squeakywood_wander", () -> new SoundEvent(new ResourceLocation("mobeffects:squeakywood.squeakywood_wander")));
    public static final RegistryObject<SoundEvent> SNOW_SNOW_WALK= SOUNDS.register("snow.snow_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:snow.snow_walk")));
    public static final RegistryObject<SoundEvent> SNOW_SNOW_RUN= SOUNDS.register("snow.snow_run", () -> new SoundEvent(new ResourceLocation("mobeffects:snow.snow_run")));
    public static final RegistryObject<SoundEvent> SNOW_SNOW_WANDER= SOUNDS.register("snow.snow_wander", () -> new SoundEvent(new ResourceLocation("mobeffects:snow.snow_wander")));
    public static final RegistryObject<SoundEvent> MUFFLEDICE_MUFFLEDICE_WALK= SOUNDS.register("muffledice.muffledice_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:muffledice.muffledice_walk")));
    public static final RegistryObject<SoundEvent> QUICKSAND_QUICKSAND_WALK= SOUNDS.register("quicksand.quicksand_walk", () -> new SoundEvent(new ResourceLocation("mobeffects:quicksand.quicksand_walk")));


}