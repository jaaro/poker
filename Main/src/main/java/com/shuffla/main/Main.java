package com.shuffla.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.shuffla.bot.Bot;
import com.shuffla.bot.BotModule;
import com.shuffla.bot.settings.BotSettings;
import com.shuffla.bot.settings.BotSettingsImpl;

public class Main {

    final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    /**
     * @param args
     */
    public static void main(String[] args) {
	(new Main()).go();

    }
    
    public void go() {
	try {
	    run();
    	} catch(IllegalAccessError e) {
	    LOGGER.error("Uncought exception", e);
	}
    }
    
    public void run() {
	BotSettings settings = new BotSettingsImpl();
	Injector injector = Guice.createInjector(new BotModule("Bocik", settings));
	Bot bot = injector.getInstance(Bot.class);
	bot.play(null);
    }

}
