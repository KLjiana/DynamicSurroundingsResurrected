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

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.widget.ForgeSlider;
import net.minecraftforge.common.ForgeConfigSpec;
import org.orecruncher.lib.gui.ColorPalette;
import org.orecruncher.sndctrl.SoundControl;
import org.orecruncher.sndctrl.api.sound.Category;
import org.orecruncher.sndctrl.api.sound.ISoundCategory;
import org.orecruncher.sndctrl.config.Config;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class QuickVolumeScreen extends Screen /*implements Slider.ISlider*/ {

    private static final int CONTROL_WIDTH = 160;
    private static final int CONTROL_HEIGHT = 20;
    private static final int CONTROL_SPACING = 5;
    private static final Button.OnPress NULL_PRESSABLE = (b) -> { };
    private static final Component SUFFIX = Component.literal("%");
    private static final Component FOOTER = Component.translatable("sndctrl.text.quickvolumemenu.footer");
    private static final Component TITLE = Component.translatable("sndctrl.text.quickvolumemenu.title");
    private static final Component OCCLUSION = Component.translatable("sndctrl.text.quickvolumemenu.occlusion");

    private final List<ISoundCategory> categories = new ArrayList<>();
    final List<Float> categoryValues = new ArrayList<>();
    private final List<ForgeSlider> sliders = new ArrayList<>();

    private Button occlusionToggle;

    private int footerY;

    protected QuickVolumeScreen() {
        super(TITLE);
    }

    @Override
    protected void init() {

        // Clear out the old cached data
        this.categories.clear();
        this.sliders.clear();

        // Collect the widgets into a list
        this.categories.addAll(Category.getCategoriesForMenu());
        for (final ISoundCategory cat : this.categories)
            this.categoryValues.add(cat.getVolumeScale());

        // Get base positioning information for display.  This should be roughly center of the screen.
        final int leftSide = (this.width - CONTROL_WIDTH) / 2;

        // Calculate the top of where the first slider would be
        final int totalHeight = (this.categories.size() + 1) * (CONTROL_HEIGHT + CONTROL_SPACING);
        int top = (this.height - totalHeight) / 2;

        int index = 0;
        // Build slider widgets for them.
        for (final ISoundCategory category : this.categories) {
            final DSlider slider = new DSlider(
                    leftSide,
                    top,
                    CONTROL_WIDTH,
                    CONTROL_HEIGHT,
                    getSliderLabel(category.getTextComponent()),
                    SUFFIX,
                    0,
                    100,
                    (int)(category.getVolumeScale() * 100),
                    true,
                    index
            );

            slider.y = top;
            top += CONTROL_HEIGHT + CONTROL_SPACING;
            slider.setParent(this);
            addRenderableWidget(slider);
            this.sliders.add(slider);
            index++;
        }

        this.occlusionToggle = new Button(
                leftSide,
                top,
                CONTROL_WIDTH,
                CONTROL_HEIGHT,
                generateTextForSetting(Config.CLIENT.sound.enableOcclusionCalcs),
                this::buttonPress
        );
        addRenderableWidget(this.occlusionToggle);
        top += CONTROL_HEIGHT + CONTROL_SPACING;

        this.footerY = top;
    }

    protected void buttonPress(@Nonnull final Button button) {
        Config.CLIENT.sound.enableOcclusionCalcs.set(!Config.CLIENT.sound.enableOcclusionCalcs.get());
        this.occlusionToggle.setMessage(generateTextForSetting(Config.CLIENT.sound.enableOcclusionCalcs));
    }

    protected Component generateTextForSetting(@Nonnull final ForgeConfigSpec.BooleanValue value) {
        final MutableComponent txt = OCCLUSION.plainCopy().append(": ");
        if (value.get()) {
            txt.append(CommonComponents.OPTION_ON);
        } else {
            txt.append(CommonComponents.OPTION_OFF);
        }
        return txt;
    }

    protected Component getSliderLabel(@Nonnull final Component text) {
        return ((MutableComponent)text).append(Component.literal(": "));
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
        // See if the mouse is over a slider and do the adjust thing
        for (final ForgeSlider slider : this.sliders) {
            if (slider.isMouseOver(mouseX, mouseY)) {
                slider.setValue(slider.getValue() + 0.05F * (delta > 0 ? 1 : -1));
//                slider.updateSlider();
                break;
            }
        }
        return false;
    }

    @Override
    public boolean mouseReleased(double p_mouseReleased_1_, double p_mouseReleased_3_, int p_mouseReleased_5_) {
//        for (final ForgeSlider slider : this.sliders)
//            slider.dragging = false;
        return false;
    }

//    @Override
//    public void onChangeSliderValue(@Nonnull final ForgeSlider slider) {
//        // Need to identify the ISoundCategory associated with the slider.
//        int idx = 0;
//        for (; idx < this.sliders.size(); idx++) {
//            if (this.sliders.get(idx) == slider)
//                break;
//        }
//
//        // Safety just in case
//        if (idx >= this.sliders.size())
//            return;
//
//        // Cache the value so we can set all at once
//        float v = slider.getValueInt() / 100F;
//        this.categoryValues.set(idx, v);
//    }

    @Override
    public void render(@Nonnull PoseStack stack, int mouseX, int mouseY, float partialTicks) {
        super.render(stack, mouseX, mouseY, partialTicks);

        // Render our text footer
        drawCenteredString(stack, this.font, FOOTER, this.width / 2, this.footerY, ColorPalette.WHITE.rgb());
    }

    @Override
    public void onClose() {
        for (int i = 0; i < this.categories.size(); i++) {
            final ISoundCategory cat = this.categories.get(i);
            // Setting the value will trigger autosave of the config
            try {
                cat.setVolumeScale(this.categoryValues.get(i));
            } catch(@Nonnull final Throwable t) {
                SoundControl.LOGGER.error(t, "Error saving value for Sound Category %s", cat.getName());
            }
        }
        super.onClose();
    }

}
