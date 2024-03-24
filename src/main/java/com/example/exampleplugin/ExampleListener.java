package com.example.exampleplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * A listener is what is used to listen for events that happen on the server.
 * A listener must implement the Listener interface, and have methods annotated
 * with @EventHandler to listen for events. We also need to register the listener
 * with the server in order for it to start listening for events. This is done
 * in the onEnable method of the main plugin file.
 * @see ExamplePlugin
 */
public class ExampleListener implements Listener {
    // We need to store a reference to the plugin that this listener is part of
    private final ExamplePlugin plugin;
    // We get this reference using dependancy injection.
    public ExampleListener(ExamplePlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * This method listens for the PlayerJoinEvent, which is called when a player
     * joins the server. There are a lot of events that you can listen for, and
     * you can find them all here: https://github.com/RhysB/Project-Poseidon/tree/master/src/main/java/org/bukkit/event
     * @param event The event that we are listening for.
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Log a message to the console when a player joins the server
        plugin.logger.info("Player " + event.getPlayer().getName() + " joined the server!");
        // Send a message to the player when they join the server
        event.getPlayer().sendMessage("Welcome to the server, " + event.getPlayer().getName() + "!");
    }
}
