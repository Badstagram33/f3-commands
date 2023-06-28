package gay.badstagram.f3commands.client;

import com.mojang.brigadier.tree.LiteralCommandNode;
import gay.badstagram.f3commands.commands.F3Base;
import gay.badstagram.f3commands.commands.F3SubCommands;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

public class F3CommandsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            //Make some new nodes
            LiteralCommandNode<FabricClientCommandSource> baseNode = ClientCommandManager
                    .literal("f3")
                    .executes(new F3Base())
                    .build();

            LiteralCommandNode<FabricClientCommandSource> reloadAllChunksNode = ClientCommandManager
                    .literal("reloadAllChunks")
                    .executes(F3SubCommands::reloadAllChunks)
                    .build();

            LiteralCommandNode<FabricClientCommandSource> toggleHitBoxesNode = ClientCommandManager
                    .literal("toggleHitboxes")
                    .executes(F3SubCommands::toggleHitBoxes)
                    .build();

            LiteralCommandNode<FabricClientCommandSource> copyCoordsAsTpNode = ClientCommandManager
                    .literal("copyCoordsAsTp")
                    .executes(F3SubCommands::copyCoordsAsTp)
                    .build();

            LiteralCommandNode<FabricClientCommandSource> clearChatNode = ClientCommandManager
                    .literal("clearChat")
                    .executes(F3SubCommands::clearChat)
                    .build();

            LiteralCommandNode<FabricClientCommandSource> pauseOnLostFocusNode = ClientCommandManager
                    .literal("pauseOnLostFocus")
                    .executes(F3SubCommands::pauseOnLostFocus)
                    .build();

            LiteralCommandNode<FabricClientCommandSource> advancedToolTipsNode = ClientCommandManager
                    .literal("advancedToolTips")
                    .executes(F3SubCommands::advancedToolTips)
                    .build();

            LiteralCommandNode<FabricClientCommandSource> reloadResourcePacksNode = ClientCommandManager
                    .literal("reloadResourcePacks")
                    .executes(F3SubCommands::reloadResourcePacks)
                    .build();

            LiteralCommandNode<FabricClientCommandSource> chunkBoundariesNode = ClientCommandManager
                    .literal("toggleChunkBoundaries")
                    .executes(F3SubCommands::chunkBoundaries)
                    .build();

            LiteralCommandNode<FabricClientCommandSource> dumpTexturesNode = ClientCommandManager
                    .literal("dumpTextures")
                    .executes(F3SubCommands::dumpTextures)
                    .build();

            //Now stitch them together

            //usage: /f3 [reloadAllChunks|toggleHitBoxes|copyCoordsAsTp|clearChat|pauseOnLostFocus|advancedToolTips|reloadResourcePacks]
            dispatcher.getRoot().addChild(baseNode);
            baseNode.addChild(reloadAllChunksNode);
            baseNode.addChild(toggleHitBoxesNode);
            baseNode.addChild(copyCoordsAsTpNode);
            baseNode.addChild(clearChatNode);
            baseNode.addChild(advancedToolTipsNode);
            baseNode.addChild(pauseOnLostFocusNode);
            baseNode.addChild(reloadResourcePacksNode);
            baseNode.addChild(chunkBoundariesNode);
            baseNode.addChild(dumpTexturesNode);
        });
    }
}
