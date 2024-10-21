package bot;

import bot.commands.AdminCommands;
import bot.commands.FunCommands;
import bot.commands.UserCommands;
import bot.commands.TreasureHunt;
import bot.commands.ReactionRoles;
import bot.commands.UserAnalytics;
import bot.commands.EventScheduler;
import bot.database.MongoManager;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;

public class DJBot extends ListenerAdapter {

    private static final String TOKEN = "xxxxxxxx"; // Replace with your bot token
    private final MongoManager mongoManager = new MongoManager();

    public static void main(String[] args) {
        try {
            JDABuilder builder = JDABuilder.createDefault(TOKEN)
                    .addEventListeners(new DJBot(), new AdminCommands(), new FunCommands(), new UserCommands(), new TreasureHunt(), new ReactionRoles(), new UserAnalytics(), new EventScheduler())
                    .setActivity(Activity.playing("DJ Sage"));

            JDA jda = builder.build();
            jda.awaitReady(); // Wait until the bot is fully ready

            // Registering commands after the bot is ready
            new DJBot().registerSlashCommands(jda);
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void registerSlashCommands(JDA jda) {

        // Registering Admin commands
        jda.upsertCommand("mute","Mutes a user").queue();
        jda.upsertCommand("unmute","Unmutes a user").queue();
        jda.upsertCommand("kick","Kicks a user").queue();
        jda.upsertCommand("ban","Bans a User").queue();
        jda.upsertCommand("clear","Clears a message from a channel").addOption(OptionType.INTEGER,"amt","Amount of msgs",true).queue();


        // Register Fun Commands
        jda.upsertCommand("roll-dice", "Roll a dice").queue();
        jda.upsertCommand("trivia", "Ask a trivia question").queue();
        jda.upsertCommand("random-fact", "Get a random fact").queue();
        jda.upsertCommand("coin-toss", "Flip a coin").queue();
        jda.upsertCommand("joke", "Tell a joke").queue();
        jda.upsertCommand("choose", "Let the bot choose from options")
                .addOption(OptionType.STRING, "options", "Comma-separated list of options", true)
                .queue();
        jda.upsertCommand("rps", "Play Rock, Paper, Scissors").queue();

        // Register Reaction Roles Commands
        jda.upsertCommand("reaction-role-setup", "Set up a reaction role")
                .addOption(OptionType.STRING, "image-url", "URL of the image for the setup", true)
                .addOption(OptionType.STRING, "emoji", "Emoji to react with", true)
                .addOption(OptionType.STRING, "role-id", "ID of the role to assign", true)
                .queue();
        jda.upsertCommand("remove-reaction-role-setup", "Remove a reaction role setup")
                .addOption(OptionType.STRING, "emoji", "Emoji to remove the role from", true)
                .queue();
        jda.upsertCommand("assign-role", "Assign a role to yourself")
                .addOption(OptionType.STRING, "role-id", "ID of the role to assign", true)
                .queue();
        jda.upsertCommand("remove-role", "Remove a role from yourself")
                .addOption(OptionType.STRING, "role-id", "ID of the role to remove", true)
                .queue();
        jda.upsertCommand("list-roles", "List all available roles").queue();

        // Register Treasure Hunt Commands
        jda.upsertCommand("start-hunt", "Start a treasure hunt").queue();
        jda.upsertCommand("get-clue", "Get the current clue").queue();
        jda.upsertCommand("submit-answer", "Submit your answer to the clue")
                .addOption(OptionType.STRING, "answer", "Your answer to the clue", true)
                .queue();
        jda.upsertCommand("view-leaderboard", "View the leaderboard for the treasure hunt").queue();
        jda.upsertCommand("hint", "Get a hint for the current clue").queue();
        jda.upsertCommand("end-hunt", "End the current treasure hunt").queue();
        jda.upsertCommand("my-progress", "Check your progress in the treasure hunt").queue();

        // Register User Commands
        jda.upsertCommand("user-profile", "Show your user profile").queue();
        jda.upsertCommand("ping", "Check if the bot is responsive").queue();
        jda.upsertCommand("server-info", "Get information about the server").queue();
        jda.upsertCommand("avatar", "Get your avatar URL").queue();
        jda.upsertCommand("uptime", "Check how long the bot has been running").queue();
        jda.upsertCommand("help", "Get help information").queue();
        jda.upsertCommand("whoami", "Get details about yourself").queue();

        // Register User Analytics Commands
        jda.upsertCommand("user-stats", "Get statistics for a user")
                .addOption(OptionType.STRING, "user-id", "The ID of the user", false)
                .queue();
        jda.upsertCommand("top-active-users", "Get the top active users in the server").queue();
        jda.upsertCommand("user-activity", "Get user activity logs")
                .addOption(OptionType.STRING, "user-id", "The ID of the user", true)
                .queue();
        jda.upsertCommand("clear-user-stats", "Clear all user statistics").queue();
        jda.upsertCommand("track-message", "Track the number of messages sent by a user").queue();

        // Register Event Scheduler Commands
        jda.upsertCommand("schedule-event", "Schedule an event")
                .addOption(OptionType.STRING, "title", "Title of the event", true)
                .addOption(OptionType.STRING, "date-time", "Date and time of the event (ISO format)", true)
                .queue();
        jda.upsertCommand("view-events", "View all scheduled events").queue();
        jda.upsertCommand("cancel-event", "Cancel a scheduled event")
                .addOption(OptionType.STRING, "title", "Title of the event to cancel", true)
                .queue();
        jda.upsertCommand("remind-event", "Set a reminder for an event")
                .addOption(OptionType.STRING, "title", "Title of the event to remind", true)
                .queue();
        jda.upsertCommand("event-info", "Get information about a specific event")
                .addOption(OptionType.STRING, "title", "Title of the event", true)
                .queue();
    }
}
