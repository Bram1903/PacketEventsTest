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

package com.github.retrooper.packeteventstest.bukkit.tests.impl;

import com.github.retrooper.packeteventstest.interfaces.Tests;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ConversionUtilTest implements Tests {

    private final JavaPlugin plugin;

    public ConversionUtilTest(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void init() {
        locationTests();
        itemStackTests();
    }

    private void locationTests() {
        World bukkitWorld = plugin.getServer().getWorlds().get(0);

        Location bukkitLocation = new Location(bukkitWorld, 0, 0, 0);
        com.github.retrooper.packetevents.protocol.world.Location peLocation = SpigotConversionUtil.fromBukkitLocation(bukkitLocation);
        Location convertedBackBukkitLocation = SpigotConversionUtil.toBukkitLocation(bukkitWorld, peLocation);

        if (!bukkitLocation.equals(convertedBackBukkitLocation)) {
            throw new AssertionError("Location conversion failed!");
        }
    }

    private void itemStackTests() {
        ItemStack bukkitItemStack = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemStack sad = new ItemStack(Material.SADDLE, 1);
        com.github.retrooper.packetevents.protocol.item.ItemStack peItemStack = SpigotConversionUtil.fromBukkitItemStack(bukkitItemStack);
        ItemStack convertedBackBukkitItemStack = SpigotConversionUtil.toBukkitItemStack(peItemStack);

        if (!bukkitItemStack.equals(convertedBackBukkitItemStack)) {
            throw new AssertionError("ItemStack conversion failed!");
        }
    }
}

