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
import net.minecraft.util.StringUtils;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * An acoustic that will play different sounds based on the AcousticEvent provided.  For example, for a given
 * EventSelectorAcoustic, an acoustic could be selected if a mob is walking vs. running.
 */
@OnlyIn(Dist.CLIENT)
public class EventSelectorAcoustic implements IAcoustic {

    private final Map<AcousticEvent, IAcoustic> mapping = new IdentityHashMap<>(4);
    @Nonnull
    private final String name;

    public EventSelectorAcoustic(@Nonnull final String name) {
        this.name = StringUtils.isNullOrEmpty(name) ? "<UNNAMED>" : name;
    }

    public void add(@Nonnull final AcousticEvent event, @Nonnull final IAcoustic acoustic) {
        this.mapping.put(event, acoustic);
    }

    @Nonnull
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void playAt(@Nonnull final BlockPos pos, @Nonnull final AcousticEvent event) {
        resolve(event).ifPresent(a -> a.playAt(pos));
    }

    @Override
    public void playAt(@Nonnull final Vec3d pos, @Nonnull final AcousticEvent event) {
        resolve(event).ifPresent(a -> a.playAt(pos));
    }

    @Override
    public void playNear(@Nonnull final Entity entity, @Nonnull final AcousticEvent event) {
        resolve(event).ifPresent(a -> a.playNear(entity));
    }

    @Override
    public void playBackground(@Nonnull final AcousticEvent event) {
        resolve(event).ifPresent(IAcoustic::playBackground);
    }

    @Nonnull
    protected Optional<IAcoustic> resolve(@Nonnull final AcousticEvent event) {
        IAcoustic acoustic = this.mapping.get(event);
        if (acoustic == null && event.canTransition())
            acoustic = this.mapping.get(event.getTransition());
        return Optional.ofNullable(acoustic);
    }

}