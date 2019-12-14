/*
 * Dynamic Surroundings: Sound Control
 * Copyright (C) 2019  OreCruncher
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

package org.orecruncher.sndctrl.audio.acoustic;

import net.minecraft.entity.Entity;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.StringUtils;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.orecruncher.sndctrl.audio.AudioEngine;
import org.orecruncher.sndctrl.audio.Category;
import org.orecruncher.sndctrl.audio.ISoundInstance;
import org.orecruncher.sndctrl.audio.SoundBuilder;

import javax.annotation.Nonnull;

/**
 * A simple acoustic that uses an AcousticFactory to produce sound instances for playing.
 */
@OnlyIn(Dist.CLIENT)
public class SimpleAcoustic implements IAcoustic {

    @Nonnull
    private final IAcousticFactory factory;
    @Nonnull
    private final String name;

    public SimpleAcoustic(@Nonnull final SoundEvent event) {
        this(event.getName().toString(), event);
    }

    public SimpleAcoustic(@Nonnull final String name, @Nonnull final SoundEvent evt) {
        this(name, new AcousticFactory(SoundBuilder.builder(evt, Category.NEUTRAL)));
    }

    public SimpleAcoustic(@Nonnull final String name, @Nonnull final IAcousticFactory factory) {
        this.name = StringUtils.isNullOrEmpty(name) ? "<UNNAMED>" : name;
        this.factory = factory;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Override
    public void playAt(@Nonnull final BlockPos pos, @Nonnull final AcousticEvent ignored) {
        play(this.factory.createSoundAt(pos));
    }

    @Override
    public void playAt(@Nonnull final Vec3d pos, @Nonnull final AcousticEvent ignored) {
        play(this.factory.createSoundAt(pos));
    }

    @Override
    public void playNear(@Nonnull final Entity entity, @Nonnull final AcousticEvent ignored) {
        play(this.factory.createSoundNear(entity));
    }

    @Override
    public void playBackground(@Nonnull final AcousticEvent ignored) {
        play(this.factory.createBackgroundSound());
    }

    protected void play(@Nonnull final ISoundInstance sound) {
        AudioEngine.play(sound);
    }
}