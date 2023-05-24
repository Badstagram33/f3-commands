package gay.badstagram.f3commands;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class F3Commands implements ModInitializer {
    private Logger _logger;
    private final String MOD_ID = "f3commands";
    private static F3Commands _instance;

    @Override
    public void onInitialize() {

    }

    public Logger getLogger() {
        if (_logger == null) {
            _logger = LoggerFactory.getLogger(MOD_ID);
        }
        return _logger;
    }

    public String getModId() {
        return MOD_ID;
    }

    public static F3Commands getInstance() {
        if (_instance == null) {
            _instance = new F3Commands();
        }

        return _instance;
    }
}
