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

import com.github.retrooper.packetevents.protocol.entity.pose.EntityPose;
import com.github.retrooper.packetevents.protocol.item.type.ItemType;
import com.github.retrooper.packetevents.protocol.particle.type.ParticleType;
import com.github.retrooper.packetevents.protocol.player.HumanoidArm;
import com.github.retrooper.packetevents.protocol.potion.PotionType;
import com.github.retrooper.packetevents.protocol.world.Dimension;
import com.github.retrooper.packetevents.protocol.world.states.WrappedBlockState;
import com.github.retrooper.packeteventstest.interfaces.Tests;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import org.bukkit.*;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pose;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MainHand;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConversionUtilTest implements Tests {

    private final JavaPlugin plugin;
    private final List<Runnable> tasks;

    public ConversionUtilTest(JavaPlugin plugin) {
        this.plugin = plugin;
        this.tasks = Arrays.asList(
                this::locationTests,
                this::potionEffectTypeTests,
                this::gameModeTests,
                this::blockDataTests,
                this::entityTypeTests,
                this::itemMaterialTests,
                this::materialDataTests,
                this::itemStackTests,
                this::worldTests,
                this::particleTests,
                this::getEntityByIntIdTests,
                this::poseTests,
                this::handTests
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

        assertEquals(bukkitLocation, convertedBackBukkitLocation, "Mismatch in Location conversion");
    }

    private void potionEffectTypeTests() {
        for (PotionEffectType bukkitPotionEffectType : Registry.POTION_EFFECT_TYPE) {
            PotionType potionType = SpigotConversionUtil.fromBukkitPotionEffectType(bukkitPotionEffectType);
            assertNotNull(potionType, "PotionType is null for " + bukkitPotionEffectType.getKey());

            PotionEffectType convertedBackBukkitPotionEffectType = SpigotConversionUtil.toBukkitPotionEffectType(potionType);
            assertNotNull(convertedBackBukkitPotionEffectType, "PotionEffectType is null for " + potionType.getName());

            assertEquals(bukkitPotionEffectType, convertedBackBukkitPotionEffectType, "Mismatch in PotionEffectType for " + bukkitPotionEffectType.getKey());
        }
    }

    private void gameModeTests() {
        for (GameMode bukkitGameMode : GameMode.values()) {
            com.github.retrooper.packetevents.protocol.player.GameMode peGameMode = SpigotConversionUtil.fromBukkitGameMode(bukkitGameMode);
            assertNotNull(peGameMode, "GameMode is null for " + bukkitGameMode.name());

            GameMode convertedBack = SpigotConversionUtil.toBukkitGameMode(peGameMode);
            assertNotNull(convertedBack, "GameMode is null for " + peGameMode.name());

            assertEquals(bukkitGameMode, convertedBack, "Mismatch in GameMode for " + bukkitGameMode.name());
        }
    }

    private void blockDataTests() {
        for (Material material : Material.values()) {
            if (!material.isBlock() || material.isLegacy()) continue;

            BlockData bukkitBlockData = material.createBlockData();
            assertNotNull(bukkitBlockData, "BlockData is null for " + material.name());

            WrappedBlockState wrappedBlockState = SpigotConversionUtil.fromBukkitBlockData(bukkitBlockData);
            assertNotNull(wrappedBlockState, "WrappedBlockState is null for " + bukkitBlockData.getMaterial().name());

            BlockData convertedBackBukkitBlockData = SpigotConversionUtil.toBukkitBlockData(wrappedBlockState);
            assertNotNull(convertedBackBukkitBlockData, "BlockData is null for " + wrappedBlockState.getType().getName());

            assertEquals(bukkitBlockData, convertedBackBukkitBlockData, "Mismatch in BlockData for " + material.name());
        }
    }

    private void entityTypeTests() {
        for (EntityType bukkitEntityType : EntityType.values()) {
            if (bukkitEntityType == EntityType.UNKNOWN) continue;

            com.github.retrooper.packetevents.protocol.entity.type.EntityType peEntityType = SpigotConversionUtil.fromBukkitEntityType(bukkitEntityType);
            assertNotNull(peEntityType, "EntityType is null for " + bukkitEntityType.name());

            EntityType convertedBack = SpigotConversionUtil.toBukkitEntityType(peEntityType);
            assertNotNull(convertedBack, "Converted EntityType is null for " + peEntityType.getName());

            assertEquals(bukkitEntityType, convertedBack, "Mismatch in EntityType for " + bukkitEntityType.name());
        }
    }

    private void itemMaterialTests() {
        for (Material bukkitItemMaterial : Material.values()) {
            if (!bukkitItemMaterial.isItem()) continue;

            ItemType itemType = SpigotConversionUtil.fromBukkitItemMaterial(bukkitItemMaterial);
            assertNotNull(itemType, "ItemType is null for " + bukkitItemMaterial.name());

            Material convertedBack = SpigotConversionUtil.toBukkitItemMaterial(itemType);
            assertNotNull(convertedBack, "Converted Material is null for " + itemType.getName());

            assertEquals(bukkitItemMaterial, convertedBack, "Mismatch in Material for " + bukkitItemMaterial.name());
        }
    }

    private void materialDataTests() {
        for (Material bukkitMaterial : Material.values()) {
            if (bukkitMaterial.isLegacy()) continue;

            MaterialData bukkitMaterialData = new MaterialData(bukkitMaterial);
            WrappedBlockState peMaterialData = SpigotConversionUtil.fromBukkitMaterialData(bukkitMaterialData);
            assertNotNull(peMaterialData, "WrappedBlockState is null for " + bukkitMaterialData.getItemType().name());

            MaterialData convertedBack = SpigotConversionUtil.toBukkitMaterialData(peMaterialData);
            assertNotNull(convertedBack, "Converted MaterialData is null for " + peMaterialData.getType().getName());

            assertEquals(bukkitMaterialData, convertedBack, "Mismatch in MaterialData for " + bukkitMaterialData.getItemType().name());
        }
    }

    private void itemStackTests() {
        for (Material bukkitItemMaterial : Material.values()) {
            if (!bukkitItemMaterial.isItem()) continue;

            ItemStack bukkitItemStack = new ItemStack(bukkitItemMaterial, 1);
            com.github.retrooper.packetevents.protocol.item.ItemStack peItemStack = SpigotConversionUtil.fromBukkitItemStack(bukkitItemStack);
            assertNotNull(peItemStack, "ItemStack is null for " + bukkitItemMaterial.name());

            ItemStack convertedBackBukkitItemStack = SpigotConversionUtil.toBukkitItemStack(peItemStack);
            assertNotNull(convertedBackBukkitItemStack, "Converted ItemStack is null for " + peItemStack.getType().getName());

            assertEquals(bukkitItemStack, convertedBackBukkitItemStack, "Mismatch in ItemStack for " + bukkitItemMaterial.name());
        }
    }

    private void worldTests() {
        World bukkitWorld = plugin.getServer().getWorlds().get(0);
        Dimension dimension = SpigotConversionUtil.fromBukkitWorld(bukkitWorld);
        assertNotNull(dimension, "Dimension is null for " + bukkitWorld.getName());

        assertNotNull(dimension.getDimensionName(), "Dimension name is null");
        assertFalse(dimension.getDimensionName().isEmpty(), "Dimension name is empty");
    }

    private void particleTests() {
        for (Particle bukkitParticle : Particle.values()) {
            ParticleType<?> peParticle = SpigotConversionUtil.fromBukkitParticle(bukkitParticle);
            assertNotNull(peParticle, "ParticleType is null for " + bukkitParticle.name());

            Particle convertedBack = (Particle) SpigotConversionUtil.toBukkitParticle(peParticle);
            assertNotNull(convertedBack, "Converted Particle is null for " + peParticle.getName());

            assertEquals(bukkitParticle, convertedBack, "Mismatch in Particle for " + bukkitParticle.name());
        }
    }

    private void getEntityByIntIdTests() {
        //TODO: Implement
    }

    private void poseTests() {
        for (Pose pose : Pose.values()) {
            EntityPose pePose = SpigotConversionUtil.fromBukkitPose(pose);
            assertNotNull(pePose, "Pose is null for " + pose.name());

            Pose convertedBack = SpigotConversionUtil.toBukkitPose(pePose);
            assertNotNull(convertedBack, "Converted Pose is null for " + pePose.name());

            assertEquals(pose, convertedBack, "Mismatch in Pose for " + pose.name());
        }
    }

    private void handTests() {
        for (HumanoidArm arm : HumanoidArm.values()) {
            MainHand mainHand = SpigotConversionUtil.toBukkitHand(arm);
            assertNotNull(mainHand, "MainHand is null for " + arm.name());
        }
    }
}
