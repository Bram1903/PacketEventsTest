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

package com.github.retrooper.packeteventstest.managers;

import java.util.logging.Logger;

public class LogManager {

    private static final Logger LOGGER = Logger.getLogger("PacketEventsTest");

    public void info(String message) {
        log(message, LogLevel.INFO);
    }

    public void warn(String message) {
        log(message, LogLevel.WARNING);
    }

    public void severe(String message) {
        log(message, LogLevel.SEVERE);
    }

    public void sendPluginWarning() {
        warn("This plugin is solely for development purposes and should not be used in a production environment.");
    }

    private void log(String message, LogLevel level) {
        switch (level) {
            case INFO:
                LOGGER.info(message);
                break;
            case WARNING:
                LOGGER.warning(message);
                break;
            case SEVERE:
                LOGGER.severe(message);
                break;
        }
    }

    private enum LogLevel {
        INFO,
        WARNING,
        SEVERE
    }
}

