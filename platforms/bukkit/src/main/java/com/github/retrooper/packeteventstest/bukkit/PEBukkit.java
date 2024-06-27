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

package com.github.retrooper.packeteventstest.bukkit;

import org.bukkit.plugin.java.JavaPlugin;

public class PEBukkit extends JavaPlugin {
    private final BukkitPacketEventsTest pe = new BukkitPacketEventsTest(this);

    public BukkitPacketEventsTest getPE() {
        return this.pe;
    }

    @Override
    public void onEnable() {
        pe.commonOnEnable();
        pe.EnableTestManager();
    }

    @Override
    public void onDisable() {
        pe.commonOnDisable();
    }
}