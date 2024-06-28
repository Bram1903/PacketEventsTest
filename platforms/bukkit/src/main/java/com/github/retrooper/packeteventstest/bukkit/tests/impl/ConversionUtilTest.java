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

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals(bukkitLocation, convertedBackBukkitLocation);
    }

    private void potionEffectTypeTests() {
        for (PotionEffectType bukkitPotionEffectType : Registry.POTION_EFFECT_TYPE) {
            PotionType potionType = SpigotConversionUtil.fromBukkitPotionEffectType(bukkitPotionEffectType);
            if (potionType == null) throw new AssertionError("PotionType is null for " + bukkitPotionEffectType.getKey());

            PotionEffectType convertedBackBukkitPotionEffectType = SpigotConversionUtil.toBukkitPotionEffectType(potionType);
            if (convertedBackBukkitPotionEffectType == null) throw new AssertionError("PotionEffectType is null for " + potionType.getName());

            assertEquals(bukkitPotionEffectType, convertedBackBukkitPotionEffectType);
        }
    }

    private void gameModeTests() {
        for (GameMode bukkitGameMode : GameMode.values()) {
            com.github.retrooper.packetevents.protocol.player.GameMode peGameMode = SpigotConversionUtil.fromBukkitGameMode(bukkitGameMode);
            if (peGameMode == null) throw new AssertionError("GameMode is null for " + bukkitGameMode.name());

            GameMode convertedBack = SpigotConversionUtil.toBukkitGameMode(peGameMode);
            if (convertedBack == null) throw new AssertionError("GameMode is null for " + peGameMode.name());

            assertEquals(bukkitGameMode, convertedBack);
        }
    }

    private void bukkitBlockDataTests() {
        BlockData bukkitBlockData = Bukkit.createBlockData(Material.DIAMOND_BLOCK);
        WrappedBlockState wrappedBlockState = SpigotConversionUtil.fromBukkitBlockData(bukkitBlockData);
        BlockData convertedBackBukkitBlockData = SpigotConversionUtil.toBukkitBlockData(wrappedBlockState);

        assertEquals(bukkitBlockData, convertedBackBukkitBlockData);
    }

    private void entityTypeTests() {
        EntityType bukkitEntityType = EntityType.PLAYER;
        com.github.retrooper.packetevents.protocol.entity.type.EntityType peEntityType = SpigotConversionUtil.fromBukkitEntityType(bukkitEntityType);
        EntityType convertedBack = SpigotConversionUtil.toBukkitEntityType(peEntityType);

        assertEquals(bukkitEntityType, convertedBack);
    }

    private void itemMaterialTests() {
        Material bukkitItemMaterial = Material.DIAMOND_SWORD;
        ItemType itemType = SpigotConversionUtil.fromBukkitItemMaterial(bukkitItemMaterial);
        Material convertedBack = SpigotConversionUtil.toBukkitItemMaterial(itemType);

        assertEquals(bukkitItemMaterial, convertedBack);
    }

    private void materialDataTests() {
        MaterialData bukkitMaterialData = new MaterialData(Material.DIRT);
        WrappedBlockState peMaterialData = SpigotConversionUtil.fromBukkitMaterialData(bukkitMaterialData);
        MaterialData convertedBack = SpigotConversionUtil.toBukkitMaterialData(peMaterialData);

        assertEquals(bukkitMaterialData, convertedBack);
    }

    private void itemStackTests() {
        ItemStack bukkitItemStack = new ItemStack(Material.DIAMOND_SWORD, 1);
        com.github.retrooper.packetevents.protocol.item.ItemStack peItemStack = SpigotConversionUtil.fromBukkitItemStack(bukkitItemStack);
        ItemStack convertedBackBukkitItemStack = SpigotConversionUtil.toBukkitItemStack(peItemStack);

        assertEquals(bukkitItemStack, convertedBackBukkitItemStack);
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

        assertEquals(bukkitParticle, convertedBack);
    }
}
