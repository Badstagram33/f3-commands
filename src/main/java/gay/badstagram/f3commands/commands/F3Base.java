package gay.badstagram.f3commands.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class F3Base implements Command<FabricClientCommandSource> {
    @Override
    public int run(CommandContext<FabricClientCommandSource> context) throws CommandSyntaxException {
        MinecraftClient.getInstance().options.debugEnabled = !MinecraftClient.getInstance().options.debugEnabled;

        return 0;
    }
}
