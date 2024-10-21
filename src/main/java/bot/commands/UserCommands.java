package bot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.Duration;
import java.time.Instant;

public class UserCommands extends ListenerAdapter {

    private final Instant botStartTime = Instant.now();

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "user-profile":
                userProfile(event);
                break;
            case "ping":
                ping(event);
                break;
            case "server-info":
                serverInfo(event);
                break;
            case "avatar":
                avatar(event);
                break;
            case "uptime":
                uptime(event);
                break;
            case "help":
                help(event);
                break;
            case "whoami":
                whoAmI(event);
                break;
        }
    }

    // Command: Show user profile
    private void userProfile(SlashCommandInteractionEvent event) {
        try {
            String profileInfo = "User Profile: Name: " + event.getUser().getName() + " | ID: " + event.getUser().getId();
            event.reply(profileInfo).queue();
        } catch (Exception e) {
            event.reply("An error occurred while fetching your profile.").queue();
        }
    }

    // Command: Ping
    private void ping(SlashCommandInteractionEvent event) {
        try {
            event.reply("Pong!").queue();
        } catch (Exception e) {
            event.reply("An error occurred while responding to ping.").queue();
        }
    }

    // Command: Server info
    private void serverInfo(SlashCommandInteractionEvent event) {
        try {
            String serverInfo = "Server Info: " + event.getGuild().getName() + " | Members: " + event.getGuild().getMemberCount();
            event.reply(serverInfo).queue();
        } catch (Exception e) {
            event.reply("An error occurred while fetching server info.").queue();
        }
    }

    // Command: User avatar
    private void avatar(SlashCommandInteractionEvent event) {
        try {
            String avatarUrl = event.getUser().getAvatarUrl();
            if (avatarUrl != null) {
                event.reply("Here is your avatar: " + avatarUrl).queue();
            } else {
                event.reply("You do not have an avatar set.").queue();
            }
        } catch (Exception e) {
            event.reply("An error occurred while fetching your avatar.").queue();
        }
    }

    // Command: Uptime
    private void uptime(SlashCommandInteractionEvent event) {
        try {
            Duration uptime = Duration.between(botStartTime, Instant.now());
            long hours = uptime.toHours();
            long minutes = uptime.toMinutes() % 60;
            long seconds = uptime.getSeconds() % 60;
            event.reply("Bot has been running for " + hours + " hours, " + minutes + " minutes, and " + seconds + " seconds!").queue();
        } catch (Exception e) {
            event.reply("An error occurred while fetching uptime.").queue();
        }
    }

    // Command: Help
    private void help(SlashCommandInteractionEvent event) {
        try {
            String helpMessage = "Here are the available commands:\n" +
                    "/user-profile - Show your user profile\n" +
                    "/ping - Test the bot's responsiveness\n" +
                    "/server-info - Get information about the server\n" +
                    "/avatar - Get your avatar URL\n" +
                    "/uptime - Check how long the bot has been running\n" +
                    "/whoami - Get details about yourself";
            event.reply(helpMessage).queue();
        } catch (Exception e) {
            event.reply("An error occurred while fetching the help information.").queue();
        }
    }

    // Command: Who am I
    private void whoAmI(SlashCommandInteractionEvent event) {
        try {
            String whoAmIInfo = "You are " + event.getUser().getName() + " with ID: " + event.getUser().getId();
            event.reply(whoAmIInfo).queue();
        } catch (Exception e) {
            event.reply("An error occurred while identifying you.").queue();
        }
    }
}
