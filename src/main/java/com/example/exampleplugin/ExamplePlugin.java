package com.example.exampleplugin;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main plugin file. This handles starting and stopping your plugin.
 * Usually this contains any static resources your plugin needs as well,
 * being passed to other parts of your plugin using dependancy injection.
 */
public class ExamplePlugin extends JavaPlugin {

    /**
     * Logger for the plugin. This is used to log messages to the console.
     * We make this public so other parts of our plugin can use our logger.
     */
    public Logger logger;

    /**
     * Called when the plugin is enabled. This is where you should do any setup
     * that your plugin needs to do when it is first started.
     */
    @Override
    public void onEnable() {
        // Get the logger and set our reference to it. In this current version of
        // Posiedon, we have to get the logger from the server. In the future,
        // each plugin may get its own logger. If we decide to use a custom logger
        // with the server logger as a parent, we can also do that. Having every
        // part of our plugin get the logger from this one place means we have
        // much more control over the logging configuration.
        this.logger = getServer().getLogger();

        // Create our event listener. This is where the dependancy injection happens.
        // Dependancy injection is just when you pass an object that another object.
        // In this case we pass this to the listener so it has a reference to the plugin.
        ExampleListener listener = new ExampleListener(this);

        // Register the listener with the server. This tells the server that we want
        // to listen for events. The server will then call the methods in our listener
        // when those events happen.
        getServer().getPluginManager().registerEvents(listener, this);

        this.logger.info("Hello world from ExamplePlugin!");
    }

    /**
     * Called when the plugin is disabled. This is where you should do any cleanup
     * that your plugin needs to do when it is stopped.
     */
    @Override
    public void onDisable() {
        this.logger.info("Goodbye world from ExamplePlugin!");
    }
    
}
