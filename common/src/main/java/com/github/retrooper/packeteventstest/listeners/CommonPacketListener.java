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

package com.github.retrooper.packeteventstest.listeners;

import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.configuration.client.*;
import com.github.retrooper.packetevents.wrapper.configuration.server.*;
import com.github.retrooper.packetevents.wrapper.handshaking.client.WrapperHandshakingClientHandshake;
import com.github.retrooper.packetevents.wrapper.login.client.*;
import com.github.retrooper.packetevents.wrapper.login.server.*;
import com.github.retrooper.packetevents.wrapper.play.client.*;
import com.github.retrooper.packetevents.wrapper.play.server.*;
import com.github.retrooper.packetevents.wrapper.status.client.WrapperStatusClientPing;
import com.github.retrooper.packetevents.wrapper.status.client.WrapperStatusClientRequest;
import com.github.retrooper.packetevents.wrapper.status.server.WrapperStatusServerPong;
import com.github.retrooper.packetevents.wrapper.status.server.WrapperStatusServerResponse;

public class CommonPacketListener extends PacketListenerAbstract {
    @Override
    public void onPacketSend(PacketSendEvent event) {
        // @formatter:off
        if (event.getPacketType() == PacketType.Configuration.Server.PLUGIN_MESSAGE) new WrapperConfigServerPluginMessage(event);
        if (event.getPacketType() == PacketType.Configuration.Server.SELECT_KNOWN_PACKS) new WrapperConfigServerSelectKnownPacks(event);
        if (event.getPacketType() == PacketType.Configuration.Server.RESET_CHAT) new WrapperConfigServerResetChat(event);
        if (event.getPacketType() == PacketType.Configuration.Server.KEEP_ALIVE) new WrapperConfigServerKeepAlive(event);
        if (event.getPacketType() == PacketType.Configuration.Server.RESOURCE_PACK_REMOVE) new WrapperConfigServerResourcePackRemove(event);
        if (event.getPacketType() == PacketType.Configuration.Server.REGISTRY_DATA) new WrapperConfigServerRegistryData(event);
        if (event.getPacketType() == PacketType.Configuration.Server.CONFIGURATION_END) new WrapperConfigServerConfigurationEnd(event);
        if (event.getPacketType() == PacketType.Configuration.Server.UPDATE_ENABLED_FEATURES) new WrapperConfigServerUpdateEnabledFeatures(event);
        if (event.getPacketType() == PacketType.Configuration.Server.COOKIE_REQUEST) new WrapperConfigServerCookieRequest(event);
        if (event.getPacketType() == PacketType.Configuration.Server.TRANSFER) new WrapperConfigServerTransfer(event);
        if (event.getPacketType() == PacketType.Configuration.Server.DISCONNECT) new WrapperConfigServerDisconnect(event);
        if (event.getPacketType() == PacketType.Configuration.Server.STORE_COOKIE) new WrapperConfigServerStoreCookie(event);
        if (event.getPacketType() == PacketType.Configuration.Server.RESOURCE_PACK_SEND) new WrapperConfigServerResourcePackSend(event);
        if (event.getPacketType() == PacketType.Configuration.Server.CUSTOM_REPORT_DETAILS) new WrapperConfigServerCustomReportDetails(event);
        if (event.getPacketType() == PacketType.Configuration.Server.SERVER_LINKS) new WrapperConfigServerServerLinks(event);
        if (event.getPacketType() == PacketType.Login.Server.COOKIE_REQUEST) new WrapperLoginServerCookieRequest(event);
        if (event.getPacketType() == PacketType.Login.Server.SET_COMPRESSION) new WrapperLoginServerSetCompression(event);
        if (event.getPacketType() == PacketType.Login.Server.ENCRYPTION_REQUEST) new WrapperLoginServerEncryptionRequest(event);
        if (event.getPacketType() == PacketType.Login.Server.LOGIN_PLUGIN_REQUEST) new WrapperLoginServerPluginRequest(event);
        if (event.getPacketType() == PacketType.Login.Server.LOGIN_SUCCESS) new WrapperLoginServerLoginSuccess(event);
        if (event.getPacketType() == PacketType.Login.Server.DISCONNECT) new WrapperLoginServerDisconnect(event);
        if (event.getPacketType() == PacketType.Play.Server.SET_COMPRESSION) new WrapperPlayServerSetCompression(event);
        if (event.getPacketType() == PacketType.Play.Server.CHAT_PREVIEW_PACKET) new WrapperPlayServerChatPreview(event);
        if (event.getPacketType() == PacketType.Play.Server.SPAWN_EXPERIENCE_ORB) new WrapperPlayServerSpawnExperienceOrb(event);
        if (event.getPacketType() == PacketType.Play.Server.SPAWN_WEATHER_ENTITY) new WrapperPlayServerSpawnWeatherEntity(event);
        if (event.getPacketType() == PacketType.Play.Server.ACKNOWLEDGE_PLAYER_DIGGING) new WrapperPlayServerAcknowledgePlayerDigging(event);
        if (event.getPacketType() == PacketType.Play.Server.PLUGIN_MESSAGE) new WrapperPlayServerPluginMessage(event);
        if (event.getPacketType() == PacketType.Play.Server.DESTROY_ENTITIES) new WrapperPlayServerDestroyEntities(event);
        if (event.getPacketType() == PacketType.Play.Server.TAGS) new WrapperPlayServerTags(event);
        if (event.getPacketType() == PacketType.Play.Server.CUSTOM_CHAT_COMPLETIONS) new WrapperPlayServerCustomChatCompletions(event);
        if (event.getPacketType() == PacketType.Play.Server.TICKING_STEP) new WrapperPlayServerTickingStep(event);
        if (event.getPacketType() == PacketType.Play.Server.CHAT_MESSAGE) new WrapperPlayServerChatMessage(event);
        if (event.getPacketType() == PacketType.Play.Server.ENTITY_VELOCITY) new WrapperPlayServerEntityVelocity(event);
        if (event.getPacketType() == PacketType.Play.Server.ENTITY_HEAD_LOOK) new WrapperPlayServerEntityHeadLook(event);
        if (event.getPacketType() == PacketType.Play.Server.WORLD_BORDER) new WrapperPlayServerWorldBorder(event);
        if (event.getPacketType() == PacketType.Play.Server.UPDATE_ENABLED_FEATURES) new WrapperPlayServerUpdateEnabledFeatures(event);
        if (event.getPacketType() == PacketType.Play.Server.ENTITY_SOUND_EFFECT) new WrapperPlayServerEntitySoundEffect(event);
        if (event.getPacketType() == PacketType.Play.Server.ENTITY_EQUIPMENT) new WrapperPlayServerEntityEquipment(event);
        if (event.getPacketType() == PacketType.Play.Server.ENTITY_TELEPORT) new WrapperPlayServerEntityTeleport(event);
        if (event.getPacketType() == PacketType.Play.Server.WORLD_BORDER_CENTER) new WrapperPlayServerWorldBorderCenter(event);
        if (event.getPacketType() == PacketType.Play.Server.SET_TITLE_TEXT) new WrapperPlayServerSetTitleText(event);
        if (event.getPacketType() == PacketType.Play.Server.DEBUG_SAMPLE) new WrapperPlayServerDebugSample(event);
        if (event.getPacketType() == PacketType.Play.Server.UPDATE_ENTITY_NBT) new WrapperPlayServerUpdateEntityNBT(event);
        if (event.getPacketType() == PacketType.Play.Server.SPAWN_PLAYER) new WrapperPlayServerSpawnPlayer(event);
        if (event.getPacketType() == PacketType.Play.Server.BLOCK_BREAK_ANIMATION) new WrapperPlayServerBlockBreakAnimation(event);
        if (event.getPacketType() == PacketType.Play.Server.RESPAWN) new WrapperPlayServerRespawn(event);
        if (event.getPacketType() == PacketType.Play.Server.SPAWN_PAINTING) new WrapperPlayServerSpawnPainting(event);
        if (event.getPacketType() == PacketType.Play.Server.UNLOAD_CHUNK) new WrapperPlayServerUnloadChunk(event);
        if (event.getPacketType() == PacketType.Play.Server.ENTITY_RELATIVE_MOVE_AND_ROTATION) new WrapperPlayServerEntityRelativeMoveAndRotation(event);
        if (event.getPacketType() == PacketType.Play.Server.WORLD_BORDER_SIZE) new WrapperPlayServerWorldBorderSize(event);
        if (event.getPacketType() == PacketType.Play.Server.PARTICLE) new WrapperPlayServerParticle(event);
        if (event.getPacketType() == PacketType.Play.Server.SELECT_ADVANCEMENTS_TAB) new WrapperPlayServerSelectAdvancementsTab(event);
        if (event.getPacketType() == PacketType.Play.Server.PLAYER_INFO) new WrapperPlayServerPlayerInfo(event);
        if (event.getPacketType() == PacketType.Play.Server.BLOCK_CHANGE) new WrapperPlayServerBlockChange(event);
        if (event.getPacketType() == PacketType.Play.Server.END_COMBAT_EVENT) new WrapperPlayServerEndCombatEvent(event);
        if (event.getPacketType() == PacketType.Play.Server.REMOVE_ENTITY_EFFECT) new WrapperPlayServerRemoveEntityEffect(event);
        if (event.getPacketType() == PacketType.Play.Server.SPAWN_ENTITY) new WrapperPlayServerSpawnEntity(event);
        if (event.getPacketType() == PacketType.Play.Server.ATTACH_ENTITY) new WrapperPlayServerAttachEntity(event);
        if (event.getPacketType() == PacketType.Play.Server.ACTION_BAR) new WrapperPlayServerActionBar(event);
        if (event.getPacketType() == PacketType.Play.Server.DISPLAY_CHAT_PREVIEW) new WrapperPlayServerSetDisplayChatPreview(event);
        if (event.getPacketType() == PacketType.Play.Server.WORLD_BORDER_LERP_SIZE) new WrapperPlayWorldBorderLerpSize(event);
        if (event.getPacketType() == PacketType.Play.Server.CHANGE_GAME_STATE) new WrapperPlayServerChangeGameState(event);
        if (event.getPacketType() == PacketType.Play.Server.UPDATE_SCORE) new WrapperPlayServerUpdateScore(event);
        if (event.getPacketType() == PacketType.Play.Server.HURT_ANIMATION) new WrapperPlayServerHurtAnimation(event);
        if (event.getPacketType() == PacketType.Play.Server.PROJECTILE_POWER) new WrapperPlayServerProjectilePower(event);
        if (event.getPacketType() == PacketType.Play.Server.ENTER_COMBAT_EVENT) new WrapperPlayServerEnterCombatEvent(event);
        if (event.getPacketType() == PacketType.Play.Server.BLOCK_ACTION) new WrapperPlayServerBlockAction(event);
        if (event.getPacketType() == PacketType.Play.Server.CHUNK_BATCH_END) new WrapperPlayServerChunkBatchEnd(event);
        if (event.getPacketType() == PacketType.Play.Server.INITIALIZE_WORLD_BORDER) new WrapperPlayServerInitializeWorldBorder(event);
        if (event.getPacketType() == PacketType.Play.Server.UPDATE_VIEW_DISTANCE) new WrapperPlayServerUpdateViewDistance(event);
        if (event.getPacketType() == PacketType.Play.Server.STORE_COOKIE) new WrapperPlayServerStoreCookie(event);
        if (event.getPacketType() == PacketType.Play.Server.CHUNK_BATCH_BEGIN) new WrapperPlayServerChunkBatchBegin(event);
        if (event.getPacketType() == PacketType.Play.Server.SCOREBOARD_OBJECTIVE) new WrapperPlayServerScoreboardObjective(event);
        if (event.getPacketType() == PacketType.Play.Server.PLAYER_INFO_REMOVE) new WrapperPlayServerPlayerInfoRemove(event);
        if (event.getPacketType() == PacketType.Play.Server.ENTITY_METADATA) new WrapperPlayServerEntityMetadata(event);
        if (event.getPacketType() == PacketType.Play.Server.RESOURCE_PACK_SEND) new WrapperPlayServerResourcePackSend(event);
        if (event.getPacketType() == PacketType.Play.Server.DISGUISED_CHAT) new WrapperPlayServerDisguisedChat(event);
        if (event.getPacketType() == PacketType.Play.Server.BLOCK_ENTITY_DATA) new WrapperPlayServerBlockEntityData(event);
        if (event.getPacketType() == PacketType.Play.Server.PING) new WrapperPlayServerPing(event);
        if (event.getPacketType() == PacketType.Play.Server.TITLE) new WrapperPlayServerTitle(event);
        if (event.getPacketType() == PacketType.Play.Server.TICKING_STATE) new WrapperPlayServerTickingState(event);
        if (event.getPacketType() == PacketType.Play.Server.DEBUG_PONG) new WrapperPlayServerDebugPong(event);
        if (event.getPacketType() == PacketType.Play.Server.NBT_QUERY_RESPONSE) new WrapperPlayServerNBTQueryResponse(event);
        if (event.getPacketType() == PacketType.Play.Server.ENTITY_RELATIVE_MOVE) new WrapperPlayServerEntityRelativeMove(event);
        if (event.getPacketType() == PacketType.Play.Server.MULTI_BLOCK_CHANGE) new WrapperPlayServerMultiBlockChange(event);
        if (event.getPacketType() == PacketType.Play.Server.SET_TITLE_TIMES) new WrapperPlayServerSetTitleTimes(event);
        if (event.getPacketType() == PacketType.Play.Server.DISCONNECT) new WrapperPlayServerDisconnect(event);
        if (event.getPacketType() == PacketType.Play.Server.CRAFT_RECIPE_RESPONSE) new WrapperPlayServerCraftRecipeResponse(event);
        if (event.getPacketType() == PacketType.Play.Server.COLLECT_ITEM) new WrapperPlayServerCollectItem(event);
        if (event.getPacketType() == PacketType.Play.Server.FACE_PLAYER) new WrapperPlayServerFacePlayer(event);
        if (event.getPacketType() == PacketType.Play.Server.UPDATE_HEALTH) new WrapperPlayServerUpdateHealth(event);
        if (event.getPacketType() == PacketType.Play.Server.CAMERA) new WrapperPlayServerCamera(event);
        if (event.getPacketType() == PacketType.Play.Server.CONFIGURATION_START) new WrapperPlayServerConfigurationStart(event);
        if (event.getPacketType() == PacketType.Play.Server.SOUND_EFFECT) new WrapperPlayServerSoundEffect(event);
        if (event.getPacketType() == PacketType.Play.Server.ACKNOWLEDGE_BLOCK_CHANGES) new WrapperPlayServerAcknowledgeBlockChanges(event);
        if (event.getPacketType() == PacketType.Play.Server.EXPLOSION) new WrapperPlayServerExplosion(event);
        if (event.getPacketType() == PacketType.Play.Server.PLAYER_INFO_UPDATE) new WrapperPlayServerPlayerInfoUpdate(event);
        if (event.getPacketType() == PacketType.Play.Server.UPDATE_VIEW_POSITION) new WrapperPlayServerUpdateViewPosition(event);
        if (event.getPacketType() == PacketType.Play.Server.ENTITY_STATUS) new WrapperPlayServerEntityStatus(event);
        if (event.getPacketType() == PacketType.Play.Server.ENTITY_ROTATION) new WrapperPlayServerEntityRotation(event);
        if (event.getPacketType() == PacketType.Play.Server.MERCHANT_OFFERS) new WrapperPlayServerMerchantOffers(event);
        if (event.getPacketType() == PacketType.Play.Server.COOKIE_REQUEST) new WrapperPlayServerCookieRequest(event);
        if (event.getPacketType() == PacketType.Play.Server.OPEN_HORSE_WINDOW) new WrapperPlayServerOpenHorseWindow(event);
        if (event.getPacketType() == PacketType.Play.Server.SPAWN_POSITION) new WrapperPlayServerSpawnPosition(event);
        if (event.getPacketType() == PacketType.Play.Server.TEAMS) new WrapperPlayServerTeams(event);
        if (event.getPacketType() == PacketType.Play.Server.PLAYER_LIST_HEADER_AND_FOOTER) new WrapperPlayServerPlayerListHeaderAndFooter(event);
        if (event.getPacketType() == PacketType.Play.Server.CLEAR_TITLES) new WrapperPlayServerClearTitles(event);
        if (event.getPacketType() == PacketType.Play.Server.SET_EXPERIENCE) new WrapperPlayServerSetExperience(event);
        if (event.getPacketType() == PacketType.Play.Server.DECLARE_COMMANDS) new WrapperPlayServerDeclareCommands(event);
        if (event.getPacketType() == PacketType.Play.Server.DISPLAY_SCOREBOARD) new WrapperPlayServerDisplayScoreboard(event);
        if (event.getPacketType() == PacketType.Play.Server.WINDOW_CONFIRMATION) new WrapperPlayServerWindowConfirmation(event);
        if (event.getPacketType() == PacketType.Play.Server.RESET_SCORE) new WrapperPlayServerResetScore(event);
        if (event.getPacketType() == PacketType.Play.Server.RESOURCE_PACK_REMOVE) new WrapperPlayServerResourcePackRemove(event);
        if (event.getPacketType() == PacketType.Play.Server.OPEN_BOOK) new WrapperPlayServerOpenBook(event);
        if (event.getPacketType() == PacketType.Play.Server.UPDATE_SIMULATION_DISTANCE) new WrapperPlayServerUpdateSimulationDistance(event);
        if (event.getPacketType() == PacketType.Play.Server.COMBAT_EVENT) new WrapperPlayServerCombatEvent(event);
        if (event.getPacketType() == PacketType.Play.Server.SET_COOLDOWN) new WrapperPlayServerSetCooldown(event);
        if (event.getPacketType() == PacketType.Play.Server.TIME_UPDATE) new WrapperPlayServerTimeUpdate(event);
        if (event.getPacketType() == PacketType.Play.Server.WINDOW_PROPERTY) new WrapperPlayServerWindowProperty(event);
        if (event.getPacketType() == PacketType.Play.Server.USE_BED) new WrapperPlayServerUseBed(event);
        if (event.getPacketType() == PacketType.Play.Server.DECLARE_RECIPES) new WrapperPlayServerDeclareRecipes(event);
        if (event.getPacketType() == PacketType.Play.Server.SERVER_DATA) new WrapperPlayServerServerData(event);
        if (event.getPacketType() == PacketType.Play.Server.PLAYER_POSITION_AND_LOOK) new WrapperPlayServerPlayerPositionAndLook(event);
        if (event.getPacketType() == PacketType.Play.Server.TRANSFER) new WrapperPlayServerTransfer(event);
        if (event.getPacketType() == PacketType.Play.Server.OPEN_SIGN_EDITOR) new WrapperPlayServerOpenSignEditor(event);
        if (event.getPacketType() == PacketType.Play.Server.VEHICLE_MOVE) new WrapperPlayServerVehicleMove(event);
        if (event.getPacketType() == PacketType.Play.Server.ENTITY_EFFECT) new WrapperPlayServerEntityEffect(event);
        if (event.getPacketType() == PacketType.Play.Server.BUNDLE) new WrapperPlayServerBundle(event);
        if (event.getPacketType() == PacketType.Play.Server.SET_TITLE_SUBTITLE) new WrapperPlayServerSetTitleSubtitle(event);
        if (event.getPacketType() == PacketType.Play.Server.DEATH_COMBAT_EVENT) new WrapperPlayServerDeathCombatEvent(event);
        if (event.getPacketType() == PacketType.Play.Server.HELD_ITEM_CHANGE) new WrapperPlayServerHeldItemChange(event);
        if (event.getPacketType() == PacketType.Play.Server.OPEN_WINDOW) new WrapperPlayServerOpenWindow(event);
        if (event.getPacketType() == PacketType.Play.Server.SET_SLOT) new WrapperPlayServerSetSlot(event);
        if (event.getPacketType() == PacketType.Play.Server.SET_PASSENGERS) new WrapperPlayServerSetPassengers(event);
        if (event.getPacketType() == PacketType.Play.Server.ENTITY_ANIMATION) new WrapperPlayServerEntityAnimation(event);
        if (event.getPacketType() == PacketType.Play.Server.JOIN_GAME) new WrapperPlayServerJoinGame(event);
        if (event.getPacketType() == PacketType.Play.Server.WORLD_BORDER_WARNING_DELAY) new WrapperPlayWorldBorderWarningDelay(event);
        if (event.getPacketType() == PacketType.Play.Server.DELETE_CHAT) new WrapperPlayServerDeleteChat(event);
        if (event.getPacketType() == PacketType.Play.Server.KEEP_ALIVE) new WrapperPlayServerKeepAlive(event);
        if (event.getPacketType() == PacketType.Play.Server.SERVER_DIFFICULTY) new WrapperPlayServerDifficulty(event);
        if (event.getPacketType() == PacketType.Play.Server.ENTITY_MOVEMENT) new WrapperPlayServerEntityMovement(event);
        if (event.getPacketType() == PacketType.Play.Server.WORLD_BORDER_WARNING_REACH) new WrapperPlayServerWorldBorderWarningReach(event);
        if (event.getPacketType() == PacketType.Play.Server.WINDOW_ITEMS) new WrapperPlayServerWindowItems(event);
        if (event.getPacketType() == PacketType.Play.Server.UPDATE_ATTRIBUTES) new WrapperPlayServerUpdateAttributes(event);
        if (event.getPacketType() == PacketType.Play.Server.SYSTEM_CHAT_MESSAGE) new WrapperPlayServerSystemChatMessage(event);
        if (event.getPacketType() == PacketType.Play.Server.PLAYER_ABILITIES) new WrapperPlayServerPlayerAbilities(event);
        if (event.getPacketType() == PacketType.Play.Server.TAB_COMPLETE) new WrapperPlayServerTabComplete(event);
        if (event.getPacketType() == PacketType.Play.Server.SPAWN_LIVING_ENTITY) new WrapperPlayServerSpawnLivingEntity(event);
        if (event.getPacketType() == PacketType.Play.Server.MAP_CHUNK_BULK) new WrapperPlayServerChunkDataBulk(event);
        if (event.getPacketType() == PacketType.Play.Server.PLAYER_CHAT_HEADER) new WrapperPlayServerPlayerChatHeader(event);
        if (event.getPacketType() == PacketType.Play.Server.CLOSE_WINDOW) new WrapperPlayServerCloseWindow(event);
        if (event.getPacketType() == PacketType.Play.Server.CHUNK_DATA) new WrapperPlayServerChunkData(event);
        if (event.getPacketType() == PacketType.Play.Server.CUSTOM_REPORT_DETAILS) new WrapperPlayServerCustomReportDetails(event);
        if (event.getPacketType() == PacketType.Play.Server.SERVER_LINKS) new WrapperPlayServerServerLinks(event);
        if (event.getPacketType() == PacketType.Status.Server.RESPONSE) new WrapperStatusServerResponse(event);
        if (event.getPacketType() == PacketType.Status.Server.PONG) new WrapperStatusServerPong(event);
        // @formatter:on
    }

    @Override
    public void onPacketReceive(PacketReceiveEvent event) {
        // @formatter:off
        if (event.getPacketType() == PacketType.Configuration.Client.CLIENT_SETTINGS) new WrapperConfigClientSettings(event);
        if (event.getPacketType() == PacketType.Configuration.Client.KEEP_ALIVE) new WrapperConfigClientKeepAlive(event);
        if (event.getPacketType() == PacketType.Configuration.Client.COOKIE_RESPONSE) new WrapperConfigClientCookieResponse(event);
        if (event.getPacketType() == PacketType.Configuration.Client.RESOURCE_PACK_STATUS) new WrapperConfigClientResourcePackStatus(event);
        if (event.getPacketType() == PacketType.Configuration.Client.CONFIGURATION_END_ACK) new WrapperConfigClientConfigurationEndAck(event);
        if (event.getPacketType() == PacketType.Configuration.Client.SELECT_KNOWN_PACKS) new WrapperConfigClientSelectKnownPacks(event);
        if (event.getPacketType() == PacketType.Configuration.Client.PLUGIN_MESSAGE) new WrapperConfigClientPluginMessage(event);
        if (event.getPacketType() == PacketType.Configuration.Client.PONG) new WrapperConfigClientPong(event);
        if (event.getPacketType() == PacketType.Handshaking.Client.HANDSHAKE) new WrapperHandshakingClientHandshake(event);
        if (event.getPacketType() == PacketType.Login.Client.LOGIN_SUCCESS_ACK) new WrapperLoginClientLoginSuccessAck(event);
        if (event.getPacketType() == PacketType.Login.Client.COOKIE_RESPONSE) new WrapperLoginClientCookieResponse(event);
        if (event.getPacketType() == PacketType.Login.Client.ENCRYPTION_RESPONSE) new WrapperLoginClientEncryptionResponse(event);
        if (event.getPacketType() == PacketType.Login.Client.LOGIN_START) new WrapperLoginClientLoginStart(event);
        if (event.getPacketType() == PacketType.Login.Client.LOGIN_PLUGIN_RESPONSE) new WrapperLoginClientPluginResponse(event);
        if (event.getPacketType() == PacketType.Play.Client.NAME_ITEM) new WrapperPlayClientNameItem(event);
        if (event.getPacketType() == PacketType.Play.Client.QUERY_BLOCK_NBT) new WrapperPlayClientQueryBlockNBT(event);
        if (event.getPacketType() == PacketType.Play.Client.UPDATE_COMMAND_BLOCK_MINECART) new WrapperPlayClientUpdateCommandBlockMinecart(event);
        if (event.getPacketType() == PacketType.Play.Client.CONFIGURATION_ACK) new WrapperPlayClientConfigurationAck(event);
        if (event.getPacketType() == PacketType.Play.Client.DEBUG_PING) new WrapperPlayClientDebugPing(event);
        if (event.getPacketType() == PacketType.Play.Client.CHAT_COMMAND_UNSIGNED) new WrapperPlayClientChatCommandUnsigned(event);
        if (event.getPacketType() == PacketType.Play.Client.CHAT_ACK) new WrapperPlayClientChatAck(event);
        if (event.getPacketType() == PacketType.Play.Client.SPECTATE) new WrapperPlayClientSpectate(event);
        if (event.getPacketType() == PacketType.Play.Client.GENERATE_STRUCTURE) new WrapperPlayClientGenerateStructure(event);
        if (event.getPacketType() == PacketType.Play.Client.PONG) new WrapperPlayClientPong(event);
        if (event.getPacketType() == PacketType.Play.Client.TAB_COMPLETE) new WrapperPlayClientTabComplete(event);
        if (event.getPacketType() == PacketType.Play.Client.SET_BEACON_EFFECT) new WrapperPlayClientSetBeaconEffect(event);
        if (event.getPacketType() == PacketType.Play.Client.PLAYER_ABILITIES) new WrapperPlayClientPlayerAbilities(event);
        if (event.getPacketType() == PacketType.Play.Client.COOKIE_RESPONSE) new WrapperPlayClientCookieResponse(event);
        if (event.getPacketType() == PacketType.Play.Client.PICK_ITEM) new WrapperPlayClientPickItem(event);
        if (event.getPacketType() == PacketType.Play.Client.KEEP_ALIVE) new WrapperPlayClientKeepAlive(event);
        if (event.getPacketType() == PacketType.Play.Client.LOCK_DIFFICULTY) new WrapperPlayClientLockDifficulty(event);
        if (event.getPacketType() == PacketType.Play.Client.CLICK_WINDOW) new WrapperPlayClientClickWindow(event);
        if (event.getPacketType() == PacketType.Play.Client.STEER_VEHICLE) new WrapperPlayClientSteerVehicle(event);
        if (event.getPacketType() == PacketType.Play.Client.SLOT_STATE_CHANGE) new WrapperPlayClientSlotStateChange(event);
        if (event.getPacketType() == PacketType.Play.Client.SET_RECIPE_BOOK_STATE) new WrapperPlayClientSetRecipeBookState(event);
        if (event.getPacketType() == PacketType.Play.Client.PLUGIN_MESSAGE) new WrapperPlayClientPluginMessage(event);
        if (event.getPacketType() == PacketType.Play.Client.USE_ITEM) new WrapperPlayClientUseItem(event);
        if (event.getPacketType() == PacketType.Play.Client.SELECT_TRADE) new WrapperPlayClientSelectTrade(event);
        if (event.getPacketType() == PacketType.Play.Client.EDIT_BOOK) new WrapperPlayClientEditBook(event);
        if (event.getPacketType() == PacketType.Play.Client.CREATIVE_INVENTORY_ACTION) new WrapperPlayClientCreativeInventoryAction(event);
        if (event.getPacketType() == PacketType.Play.Client.CLIENT_STATUS) new WrapperPlayClientClientStatus(event);
        if (event.getPacketType() == PacketType.Play.Client.ANIMATION) new WrapperPlayClientAnimation(event);
        if (event.getPacketType() == PacketType.Play.Client.INTERACT_ENTITY) new WrapperPlayClientInteractEntity(event);
        if (event.getPacketType() == PacketType.Play.Client.WINDOW_CONFIRMATION) new WrapperPlayClientWindowConfirmation(event);
        if (event.getPacketType() == PacketType.Play.Client.PLAYER_BLOCK_PLACEMENT) new WrapperPlayClientPlayerBlockPlacement(event);
        if (event.getPacketType() == PacketType.Play.Client.UPDATE_SIGN) new WrapperPlayClientUpdateSign(event);
        if (event.getPacketType() == PacketType.Play.Client.CRAFT_RECIPE_REQUEST) new WrapperPlayClientCraftRecipeRequest(event);
        if (event.getPacketType() == PacketType.Play.Client.PLAYER_ROTATION) new WrapperPlayClientPlayerRotation(event);
        if (event.getPacketType() == PacketType.Play.Client.DEBUG_SAMPLE_SUBSCRIPTION) new WrapperPlayClientDebugSampleSubscription(event);
        if (event.getPacketType() == PacketType.Play.Client.TELEPORT_CONFIRM) new WrapperPlayClientTeleportConfirm(event);
        if (event.getPacketType() == PacketType.Play.Client.ENTITY_ACTION) new WrapperPlayClientEntityAction(event);
        if (event.getPacketType() == PacketType.Play.Client.CHUNK_BATCH_ACK) new WrapperPlayClientChunkBatchAck(event);
        if (event.getPacketType() == PacketType.Play.Client.CHAT_PREVIEW) new WrapperPlayClientChatPreview(event);
        if (event.getPacketType() == PacketType.Play.Client.PLAYER_DIGGING) new WrapperPlayClientPlayerDigging(event);
        if (event.getPacketType() == PacketType.Play.Client.CHAT_MESSAGE) new WrapperPlayClientChatMessage(event);
        if (event.getPacketType() == PacketType.Play.Client.CLIENT_SETTINGS) new WrapperPlayClientSettings(event);
        if (event.getPacketType() == PacketType.Play.Client.RESOURCE_PACK_STATUS) new WrapperPlayClientResourcePackStatus(event);
        if (event.getPacketType() == PacketType.Play.Client.SET_DISPLAYED_RECIPE) new WrapperPlayClientSetDisplayedRecipe(event);
        if (event.getPacketType() == PacketType.Play.Client.UPDATE_JIGSAW_BLOCK) new WrapperPlayClientUpdateJigsawBlock(event);
        if (event.getPacketType() == PacketType.Play.Client.CHAT_COMMAND) new WrapperPlayClientChatCommand(event);
        if (event.getPacketType() == PacketType.Play.Client.PLAYER_POSITION_AND_ROTATION) new WrapperPlayClientPlayerPositionAndRotation(event);
        if (event.getPacketType() == PacketType.Play.Client.PLAYER_POSITION) new WrapperPlayClientPlayerPosition(event);
        if (event.getPacketType() == PacketType.Play.Client.QUERY_ENTITY_NBT) new WrapperPlayClientQueryEntityNBT(event);
        if (event.getPacketType() == PacketType.Play.Client.VEHICLE_MOVE) new WrapperPlayClientVehicleMove(event);
        if (event.getPacketType() == PacketType.Play.Client.STEER_BOAT) new WrapperPlayClientSteerBoat(event);
        if (event.getPacketType() == PacketType.Play.Client.UPDATE_COMMAND_BLOCK) new WrapperPlayClientUpdateCommandBlock(event);
        if (event.getPacketType() == PacketType.Play.Client.CLOSE_WINDOW) new WrapperPlayClientCloseWindow(event);
        if (event.getPacketType() == PacketType.Play.Client.HELD_ITEM_CHANGE) new WrapperPlayClientHeldItemChange(event);
        if (event.getPacketType() == PacketType.Play.Client.SET_DIFFICULTY) new WrapperPlayClientSetDifficulty(event);
        if (event.getPacketType() == PacketType.Play.Client.ADVANCEMENT_TAB) new WrapperPlayClientAdvancementTab(event);
        if (event.getPacketType() == PacketType.Play.Client.CLICK_WINDOW_BUTTON) new WrapperPlayClientClickWindowButton(event);
        if (event.getPacketType() == PacketType.Play.Client.CHAT_SESSION_UPDATE) new WrapperPlayClientChatSessionUpdate(event);
        if (event.getPacketType() == PacketType.Status.Client.PING) new WrapperStatusClientPing(event);
        if (event.getPacketType() == PacketType.Status.Client.REQUEST) new WrapperStatusClientRequest(event);
        // @formatter:on
    }
}
