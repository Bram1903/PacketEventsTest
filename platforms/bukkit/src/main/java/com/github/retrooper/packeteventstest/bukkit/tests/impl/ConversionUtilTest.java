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

import com.github.retrooper.packetevents.protocol.item.type.ItemType;
import com.github.retrooper.packetevents.protocol.particle.type.ParticleType;
import com.github.retrooper.packetevents.protocol.potion.PotionType;
import com.github.retrooper.packetevents.protocol.world.Dimension;
import com.github.retrooper.packetevents.protocol.world.states.WrappedBlockState;
import com.github.retrooper.packeteventstest.interfaces.Tests;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import org.bukkit.*;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.List;

public class ConversionUtilTest implements Tests {

    private final JavaPlugin plugin;
    private final List<Runnable> tasks;

    public ConversionUtilTest(JavaPlugin plugin) {
        this.plugin = plugin;
        this.tasks = Arrays.asList(
                this::locationTests,
                this::potionEffectTypeTests,
                this::gameModeTests,
                this::bukkitBlockDataTests,
                this::entityTypeTests,
                this::itemMaterialTests,
                this::materialDataTests,
                this::itemStackTests,
                this::worldTests,
                this::particleTests
        );
    }

    @Override
    public void init() {
        for (Runnable task : tasks) {
            task.run();
        }
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

    private void potionEffectTypeTests() {
        PotionEffectType bukkitPotionEffectType = PotionEffectType.ABSORPTION;
        PotionType potionType = SpigotConversionUtil.fromBukkitPotionEffectType(bukkitPotionEffectType);
        PotionEffectType convertedBackBukkitPotionEffectType = SpigotConversionUtil.toBukkitPotionEffectType(potionType);

        if (!bukkitPotionEffectType.equals(convertedBackBukkitPotionEffectType)) {
            throw new AssertionError("PotionEffectType conversion failed!");
        }
    }

    private void gameModeTests() {
        GameMode bukkitGameMode = GameMode.CREATIVE;
        com.github.retrooper.packetevents.protocol.player.GameMode peGameMode = SpigotConversionUtil.fromBukkitGameMode(bukkitGameMode);
        GameMode convertedBack = SpigotConversionUtil.toBukkitGameMode(peGameMode);

        if (!bukkitGameMode.equals(convertedBack)) {
            throw new AssertionError("GameMode conversion failed!");
        }
    }

    private void bukkitBlockDataTests() {
        BlockData bukkitBlockData = Bukkit.createBlockData(Material.DIAMOND_BLOCK);
        WrappedBlockState wrappedBlockState = SpigotConversionUtil.fromBukkitBlockData(bukkitBlockData);
        BlockData convertedBackBukkitBlockData = SpigotConversionUtil.toBukkitBlockData(wrappedBlockState);

        if (!bukkitBlockData.equals(convertedBackBukkitBlockData)) {
            throw new AssertionError("BlockData conversion failed!");
        }
    }

    private void entityTypeTests() {
        EntityType bukkitEntityType = EntityType.PLAYER;
        com.github.retrooper.packetevents.protocol.entity.type.EntityType peEntityType = SpigotConversionUtil.fromBukkitEntityType(bukkitEntityType);
        EntityType convertedBack = SpigotConversionUtil.toBukkitEntityType(peEntityType);

        if (!bukkitEntityType.equals(convertedBack)) {
            throw new AssertionError("EntityType conversion failed!");
        }
    }

    private void itemMaterialTests() {
        Material bukkitItemMaterial = Material.DIAMOND_SWORD;
        ItemType itemType = SpigotConversionUtil.fromBukkitItemMaterial(bukkitItemMaterial);
        Material convertedBack = SpigotConversionUtil.toBukkitItemMaterial(itemType);

        if (!bukkitItemMaterial.equals(convertedBack)) {
            throw new AssertionError("Item material conversion failed!");
        }
    }

    private void materialDataTests() {
        MaterialData bukkitMaterialData = new MaterialData(Material.DIAMOND_SWORD);
        WrappedBlockState peMaterialData = SpigotConversionUtil.fromBukkitMaterialData(bukkitMaterialData);
        MaterialData convertedBack = SpigotConversionUtil.toBukkitMaterialData(peMaterialData);

        if (!bukkitMaterialData.equals(convertedBack)) {
            throw new AssertionError("MaterialData conversion failed!");
        }
    }

    private void itemStackTests() {
        ItemStack bukkitItemStack = new ItemStack(Material.DIAMOND_SWORD, 1);
        com.github.retrooper.packetevents.protocol.item.ItemStack peItemStack = SpigotConversionUtil.fromBukkitItemStack(bukkitItemStack);
        ItemStack convertedBackBukkitItemStack = SpigotConversionUtil.toBukkitItemStack(peItemStack);

        if (!bukkitItemStack.equals(convertedBackBukkitItemStack)) {
            throw new AssertionError("ItemStack conversion failed!");
        }
    }

    private void worldTests() {
        World bukkitWorld = plugin.getServer().getWorlds().get(0);
        Dimension dimension = SpigotConversionUtil.fromBukkitWorld(bukkitWorld);

        if (dimension.getDimensionName() == null || dimension.getDimensionName().isEmpty()) {
            throw new AssertionError("World conversion failed!");
        }
    }

    private void particleTests() {
        Particle bukkitParticle = Particle.FIREWORK;
        ParticleType<?> peParticle = SpigotConversionUtil.fromBukkitParticle(bukkitParticle);
        Particle convertedBack = (Particle) SpigotConversionUtil.toBukkitParticle(peParticle);

        if (!bukkitParticle.equals(convertedBack)) {
            throw new AssertionError("Particle conversion failed!");
        }
    }
}
