package com.shuffla.bot;

import com.google.inject.AbstractModule;
import com.shuffla.bot.resources.AISettings;
import com.shuffla.bot.resources.MyName;
import com.shuffla.bot.settings.BotSettings;

public class BotModule extends AbstractModule {
    private String playerName;
    private BotSettings botSettings;
    /**
     * Creates new game
     * @param botSettings
     */
    public BotModule(String playerName, BotSettings botSettings) {
	this.playerName = playerName;
	this.botSettings = botSettings;
    }
    
    @Override
    protected void configure() {
	bind(BotSettings.class).annotatedWith(AISettings.class).toInstance(botSettings);
	bindConstant().annotatedWith(MyName.class).to(playerName);
    }

}
