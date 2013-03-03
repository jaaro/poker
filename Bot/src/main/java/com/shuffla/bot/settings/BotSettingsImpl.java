package com.shuffla.bot.settings;

import java.util.HashMap;
import java.util.Map;

public class BotSettingsImpl implements BotSettings {

    private static final long serialVersionUID = 1L;
    
    private Map<Integer, NPlayerSettings> settings = new HashMap<Integer, NPlayerSettings>();

    public Integer getRangeSize() {
	return 1000;
    }
    
    public NPlayerSettings getStrategy(int numberOfPlayers) {
	return settings.get(numberOfPlayers);
    }
}
