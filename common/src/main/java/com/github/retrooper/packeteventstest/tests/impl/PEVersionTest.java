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

package com.github.retrooper.packeteventstest.tests.impl;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.util.PEVersion;
import com.github.retrooper.packetevents.util.PEVersions;
import com.github.retrooper.packeteventstest.PEPlatform;
import com.github.retrooper.packeteventstest.interfaces.Tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PEVersionTest<P> implements Tests {

    private final PEPlatform<P> platform;

    public PEVersionTest(PEPlatform<P> platform) {
        this.platform = platform;
    }

    @Override
    public void init() {
        staticVersionTest();
        dynamicVersionTest();
        createVersionTest();
        createVersionWithSnapshotTest();
        checkIfNewerTest();
        checkIfOlderTest();
        checkIfEqualsTest();
    }

    private void staticVersionTest() {
        PEVersion version = PEVersions.CURRENT;
        assertNotNull(version, "Expected current version to be not null");
    }

    private void dynamicVersionTest() {
        PEVersion version = PacketEvents.getAPI().getVersion();
        assertNotNull(version, "Expected dynamic version to be not null");
    }

    private void createVersionTest() {
        PEVersion version = new PEVersion(1, 0, 0);
        assertNotNull(version, "Expected new version instance to be not null");
    }

    private void createVersionWithSnapshotTest() {
        PEVersion version = new PEVersion(1, 0, 0, true);
        assertNotNull(version, "Expected new version instance with snapshot to be not null");
    }

    private void checkIfNewerTest() {
        PEVersion version = new PEVersion(3, 6, 1);
        PEVersion version2 = new PEVersion(3, 7, 1);
        boolean isNewer = version2.isNewerThan(version);
        assertTrue(isNewer, "Expected version2 (" + version2 + ") to be newer than version (" + version + ")");

        version = new PEVersion(2, 8, 8, true);
        version2 = new PEVersion(2, 8, 8);
        isNewer = version2.isNewerThan(version);
        assertTrue(isNewer, "Expected version2 (" + version2 + ") to be newer than version (" + version + ")");
    }

    private void checkIfOlderTest() {
        PEVersion version = new PEVersion(3, 6, 1);
        PEVersion version2 = new PEVersion(3, 7, 1);
        boolean isOlder = version.isOlderThan(version2);
        assertTrue(isOlder, "Expected version (" + version + ") to be older than version 2 (" + version2 + ")");

        version = new PEVersion(2, 8, 8, true);
        version2 = new PEVersion(2, 8, 8);
        isOlder = version.isOlderThan(version2);
        assertTrue(isOlder, "Expected version (" + version + ") to be older than version 2 (" + version2 + ")");
    }

    private void checkIfEqualsTest() {
        PEVersion version = new PEVersion(3, 6, 1);
        PEVersion version2 = new PEVersion(3, 6, 1);
        boolean isEqual = version.equals(version2);
        assertTrue(isEqual, "Expected version (" + version + ") to be equal to version 2 (" + version2 + ")");

        version = new PEVersion(2, 8, 8, true);
        version2 = new PEVersion(2, 8, 8, true);
        isEqual = version.equals(version2);
        assertTrue(isEqual, "Expected version (" + version + ") to be equal to version 2 (" + version2 + ")");
    }
}

