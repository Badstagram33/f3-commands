package gay.badstagram.f3commands;

import net.minecraft.client.MinecraftClient;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class Util {
    protected Util() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void debugLog(Text text) {
        MinecraftClient.getInstance()
                .inGameHud
                .getChatHud()
                .addMessage(
                        Text.empty()
                                .append(Text.translatable("debug.prefix")
                                        .formatted(Formatting.YELLOW, Formatting.BOLD))
                                .append(ScreenTexts.SPACE).append(text)
                );

    }
}
