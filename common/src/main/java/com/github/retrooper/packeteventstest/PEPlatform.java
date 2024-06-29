/*
 * This file is part of packeteventstest - https://github.com/retrooper/packeteventstest
 * Copyright (C) 2024 retrooper and contributors
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
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.retrooper.packeteventstest;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packeteventstest.listeners.CommonPacketListener;
import com.github.retrooper.packeteventstest.managers.LogManager;
import com.github.retrooper.packeteventstest.tests.TestManager;
import lombok.Getter;

@Getter
public abstract class PEPlatform<P> {

    protected LogManager logManager;
    private TestManager<P> testManager;

    /**
     * Called when the platform is enabled.
     */
    public void commonOnEnable() {
        logManager = new LogManager();
        PacketEvents.getAPI().getEventManager().registerListener(new CommonPacketListener());
        testManager = new TestManager<>(this);

        logManager.sendPluginWarning();
    }

    /**
     * Called when the platform gets disabled.
     */
    public void commonOnDisable() {
        logManager.info("PacketEventsTest has been disabled!");
    }

    public abstract P getPlatform();
}