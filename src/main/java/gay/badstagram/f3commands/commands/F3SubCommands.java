package gay.badstagram.f3commands.commands;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import gay.badstagram.f3commands.Util;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class F3SubCommands {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static int reloadAllChunks(CommandContext<FabricClientCommandSource> context) throws CommandSyntaxException {
        mc.worldRenderer.reload();

        Util.debugLog(Text.translatable("debug.reload_chunks.message"));
        return 1;
    }

    public static int toggleHitBoxes(CommandContext<FabricClientCommandSource> context) throws CommandSyntaxException {
        boolean shouldAlreadyRender = mc.getEntityRenderDispatcher().shouldRenderHitboxes();
        mc.getEntityRenderDispatcher().setRenderHitboxes(!shouldAlreadyRender);

        Util.debugLog(Text.translatable(shouldAlreadyRender ? "debug.show_hitboxes.off" : "debug.show_hitboxes.on"));
        return 1;
    }

    public static int copyCoordsAsTp(CommandContext<FabricClientCommandSource> context) {
        Identifier world = mc.world.getRegistryKey().getValue();
        double x = mc.player.getX();
        double y = mc.player.getY();
        double z = mc.player.getZ();
        double yaw = mc.player.getYaw();
        double pitch = mc.player.getPitch();

        String coords = "/execute in %s run tp @s %.2f %.2f %.2f %.2f %.2f".formatted(world, x, y, z, yaw, pitch);

        mc.keyboard.setClipboard(coords);

        Util.debugLog(Text.translatable("debug.copy_location.message"));

        return 1;
    }

    public static int clearChat(CommandContext<FabricClientCommandSource> context) {
        if (mc.inGameHud != null) {
            mc.inGameHud.getChatHud().clear(false);
        }

        return 1;
    }

    public static int pauseOnLostFocus(CommandContext<FabricClientCommandSource> context) {
        mc.options.pauseOnLostFocus = !mc.options.pauseOnLostFocus;

        Util.debugLog(Text.translatable(mc.options.pauseOnLostFocus ? "debug.pause_focus.on" : "debug.pause_focus.off"));

        return 1;
    }

    public static int advancedToolTips(CommandContext<FabricClientCommandSource> context) {
        mc.options.advancedItemTooltips = !mc.options.advancedItemTooltips;

        Util.debugLog(Text.translatable(mc.options.advancedItemTooltips ? "debug.advanced_tooltips.on" : "debug.advanced_tooltips.off"));
        return 1;
    }

    public static int reloadResourcePacks(CommandContext<FabricClientCommandSource> context) {
        mc.reloadResources();

        Util.debugLog(Text.translatable("debug.reload_resourcepacks.message"));
        return 1;
    }

    public static int chunkBoundaries(CommandContext<FabricClientCommandSource> context) {
        boolean bl = mc.debugRenderer.toggleShowChunkBorder();

        Util.debugLog(Text.translatable(bl ? "debug.chunk_boundaries.on" : "debug.chunk_boundaries.off"));
        return 1;
    }
}
