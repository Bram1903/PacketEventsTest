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

package com.github.retrooper.packeteventstest.bukkit.tests;

import com.github.retrooper.packeteventstest.bukkit.tests.impl.ConversionUtilTest;
import com.github.retrooper.packeteventstest.interfaces.Tests;
import io.github.retrooper.packetevents.util.folia.FoliaScheduler;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public class TestManager {

    public TestManager(JavaPlugin plugin) {
        registerTests(plugin);
    }

    private void registerTests(JavaPlugin plugin) {
        List<Tests> tests = Arrays.asList(
                new ConversionUtilTest(plugin)
        );

        tests.forEach(test -> FoliaScheduler.getAsyncScheduler().runNow(plugin, (o) -> test.init()));
    }
}


