package bot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Member;

import java.util.HashMap;
import java.util.Map;

public class UserAnalytics extends ListenerAdapter {

    private final Map<String, Integer> userMessageCounts = new HashMap<>(); // Tracks user message counts

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "user-stats":
                userStats(event);
                break;
            case "top-active-users":
                topActiveUsers(event);
                break;
            case "user-activity":
                userActivity(event);
                break;
            case "clear-user-stats":
                clearUserStats(event);
                break;
            case "track-message":
                trackMessage(event);
                break;
        }
    }

    // Command: Show user statistics
    private void userStats(SlashCommandInteractionEvent event) {
        String userId = event.getOption("user-id") != null ? event.getOption("user-id").getAsString() : event.getUser().getId();
        Integer messageCount = userMessageCounts.getOrDefault(userId, 0);

        event.reply("User Stats for <@" + userId + ">:\nMessages sent: " + messageCount).queue();
    }

    // Command: Show top active users
    private void topActiveUsers(SlashCommandInteractionEvent event) {
        StringBuilder topUsers = new StringBuilder("Top Active Users:\n");

        userMessageCounts.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())) // Sort by message count
                .limit(5) // Limit to top 5
                .forEach(entry -> {
                    topUsers.append("<@").append(entry.getKey()).append(">: ").append(entry.getValue()).append(" messages\n");
                });

        event.reply(topUsers.toString()).queue();
    }

    // Command: Show user activity log
    private void userActivity(SlashCommandInteractionEvent event) {
        String userId = event.getOption("user-id").getAsString();
        // Assuming there's a method to fetch user activity logs
        String activityLog = fetchUserActivity(userId); // Placeholder for actual fetching logic

        if (activityLog != null && !activityLog.isEmpty()) {
            event.reply("Activity log for <@" + userId + ">:\n" + activityLog).queue();
        } else {
            event.reply("No activity found for user <@" + userId + ">").queue();
        }
    }

    // Command: Clear user stats
    private void clearUserStats(SlashCommandInteractionEvent event) {
        userMessageCounts.clear();
        event.reply("User statistics have been cleared!").queue();
    }

    // Command: Track messages
    private void trackMessage(SlashCommandInteractionEvent event) {
        String userId = event.getUser().getId();
        userMessageCounts.put(userId, userMessageCounts.getOrDefault(userId, 0) + 1);
        event.reply("Message from <@" + userId + "> has been tracked! Total messages: " + userMessageCounts.get(userId)).queue();
    }

    // Placeholder for fetching user activity logs
    private String fetchUserActivity(String userId) {
        // Implement the logic to fetch user activity logs
        // This can be from a database, a file, etc.
        return "User activity data not yet implemented."; // Placeholder response
    }
}
