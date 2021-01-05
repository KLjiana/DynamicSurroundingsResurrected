/*
 * Dynamic Surroundings
 * Copyright (C) 2020  OreCruncher
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>
 */

package org.orecruncher.sndctrl.library;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.orecruncher.lib.SoundTypeUtils;
import org.orecruncher.lib.Utilities;
import org.orecruncher.mobeffects.MobEffects;
import org.orecruncher.mobeffects.config.Config;
import org.orecruncher.mobeffects.library.Constants;
import org.orecruncher.sndctrl.api.acoustics.IAcoustic;
import org.orecruncher.sndctrl.api.sound.ISoundCategory;
import org.orecruncher.sndctrl.audio.acoustic.NullAcoustic;
import org.orecruncher.sndctrl.audio.acoustic.SimpleAcoustic;

import javax.annotation.Nonnull;
import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class Primitives {

    private static final String ARMOR_EQUIP_PREFIX = "primitive/armor/equip/";
    private static final String ARMOR_ACCENT_PREFIX = "primitive/armor/accent/";
    private static final String FOOTSTEP_PREFIX = "primitive/block/step/";
    private static final String VANILLA_FOOTSTEP_PREFIX = "primitive/block/step/vanilla/";
    private static final String SOUND_PREFIX = "primitive/sound/";

    @Nonnull
    public static ResourceLocation createArmorToolbarResource(@Nonnull final IArmorMaterial material) {
        return new ResourceLocation(MobEffects.MOD_ID, Utilities.safeResourcePath(ARMOR_EQUIP_PREFIX + material.getName()));
    }

    @Nonnull
    public static ResourceLocation createArmorAccentResource(@Nonnull final IArmorMaterial material) {
        return new ResourceLocation(MobEffects.MOD_ID, Utilities.safeResourcePath(ARMOR_ACCENT_PREFIX + material.getName()));
    }

    @Nonnull
    public static ResourceLocation createFootstepResource(@Nonnull final SoundType st) {
        return createFootstepResource(SoundTypeUtils.getSoundTypeName(st));
    }

    @Nonnull
    public static ResourceLocation createVanillaFootstepResource(@Nonnull final SoundType st) {
        final String safePath = Utilities.safeResourcePath(VANILLA_FOOTSTEP_PREFIX + SoundTypeUtils.getSoundTypeName(st));
        return new ResourceLocation(MobEffects.MOD_ID, safePath);
    }

    @Nonnull
    public static ResourceLocation createFootstepResource(@Nonnull final String soundType) {
        final String safePath = Utilities.safeResourcePath(FOOTSTEP_PREFIX + soundType);
        return new ResourceLocation(MobEffects.MOD_ID, safePath);
    }

    private static ResourceLocation createSoundLocation(@Nonnull final ResourceLocation loc, @Nonnull final ISoundCategory category) {
        final String safePath = Utilities.safeResourcePath(SOUND_PREFIX + category.getName() + "/" + loc.toString());
        return new ResourceLocation(MobEffects.MOD_ID, safePath);
    }

    public static IAcoustic getSound(@Nonnull final ResourceLocation loc, @Nonnull final ISoundCategory category) {
        final ResourceLocation resource = createSoundLocation(loc, category);
        IAcoustic acoustic = AcousticLibrary.resolve(resource);
        if (acoustic == NullAcoustic.INSTANCE) {
            final Optional<SoundEvent> se = SoundLibrary.getSound(loc);
            if (se.isPresent() && se.get() != SoundLibrary.MISSING) {
                acoustic = new SimpleAcoustic(se.get(), category);
                AcousticLibrary.addAcoustic(resource, acoustic);
            }
        }
        return acoustic;
    }

    @Nonnull
    public static IAcoustic getArmorToolbarAcoustic(@Nonnull final IArmorMaterial material) {
        final ResourceLocation loc = createArmorToolbarResource(material);
        IAcoustic acoustic = AcousticLibrary.resolve(loc);
        if (acoustic == NullAcoustic.INSTANCE) {
            acoustic = new SimpleAcoustic(material.getSoundEvent(), Constants.TOOLBAR);
            AcousticLibrary.addAcoustic(loc, acoustic);
        }
        return acoustic;
    }

    public static IAcoustic getArmorAccentAcoustic(@Nonnull final IArmorMaterial material) {
        final ResourceLocation loc = createArmorAccentResource(material);
        return footstepAcousticResolver(loc, material.getSoundEvent());
    }

    @Nonnull
    public static IAcoustic getFootstepAcoustic(@Nonnull final BlockState state) {
        return getFootstepAcoustic(state.getSoundType());
    }

    @Nonnull
    public static IAcoustic getVanillaFootstepAcoustic(@Nonnull final SoundType soundType) {
        final ResourceLocation loc = createVanillaFootstepResource(soundType);
        return footstepAcousticResolver(loc, soundType);
    }

    @Nonnull
    public static IAcoustic getFootstepAcoustic(@Nonnull final SoundType soundType) {
        final ResourceLocation loc = createFootstepResource(soundType);
        return footstepAcousticResolver(loc, soundType);
    }

    @Nonnull
    private static IAcoustic footstepAcousticResolver(@Nonnull final ResourceLocation loc, @Nonnull final SoundEvent soundType) {
        IAcoustic acoustic = AcousticLibrary.resolve(loc);
        if (acoustic == NullAcoustic.INSTANCE) {
            final SimpleAcoustic simple = new SimpleAcoustic(soundType, Constants.FOOTSTEPS);
            AcousticLibrary.addAcoustic(loc, simple);
            acoustic = simple;
        }
        return acoustic;
    }

    @Nonnull
    private static IAcoustic footstepAcousticResolver(@Nonnull final ResourceLocation loc, @Nonnull final SoundType soundType) {
        IAcoustic acoustic = AcousticLibrary.resolve(loc);
        if (acoustic == NullAcoustic.INSTANCE) {
            final SimpleAcoustic simple = new SimpleAcoustic(soundType.getStepSound(), Constants.FOOTSTEPS);
            // Minecraft scales footstep sound volume to 15%
            simple.getFactory().setVolume(soundType.getVolume() * (0.15F / (Config.FOOTSTEP_VOLUME_DEFAULT / 100F)));
            simple.getFactory().setPitch(soundType.getPitch());
            AcousticLibrary.addAcoustic(loc, simple);
            acoustic = simple;
        }
        return acoustic;
    }
}