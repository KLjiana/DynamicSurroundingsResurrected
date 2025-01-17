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
package org.orecruncher.sndctrl.gui;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.orecruncher.lib.GameUtils;
import org.orecruncher.sndctrl.SoundControl;

@Mod.EventBusSubscriber(modid = SoundControl.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Keys {



    @SubscribeEvent
    public static void keyPressed(InputEvent.Key event) {
        if (GameUtils.getMC().screen == null && GameUtils.getPlayer() != null) {
            if (KeysModBus.quickVolumeGui.consumeClick()) {
                GameUtils.getMC().setScreen(new QuickVolumeScreen());
            } else if (KeysModBus.soundConfigGui.consumeClick()) {
                final boolean singlePlayer = GameUtils.getMC().getSingleplayerServer() != null && GameUtils.getMC().getSingleplayerServer().isPublished();
                GameUtils.getMC().setScreen(new IndividualSoundControlScreen(null, singlePlayer));
                if (singlePlayer)
                    GameUtils.getMC().getSoundManager().pause();
            }
        }
    }
}