package com.shuffla.bot.settings;

import java.io.Serializable;

public interface BotSettings extends Serializable {

    Integer getRangeSize();
    
    NPlayerSettings getStrategy(int numberOfPlayers);

}
