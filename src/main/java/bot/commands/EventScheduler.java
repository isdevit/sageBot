package bot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.Member;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class EventScheduler extends ListenerAdapter {

    private final Map<String, ScheduledEvent> events = new HashMap<>();

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "schedule-event":
                scheduleEvent(event);
                break;
            case "view-events":
                viewEvents(event);
                break;
            case "cancel-event":
                cancelEvent(event);
                break;
            case "remind-event":
                remindEvent(event);
                break;
            case "event-info":
                eventInfo(event);
                break;
        }
    }

    // Command: Schedule an event
    private void scheduleEvent(SlashCommandInteractionEvent event) {
        String title = event.getOption("title").getAsString();
        String dateTimeStr = event.getOption("date-time").getAsString();
        LocalDateTime dateTime;

        try {
            dateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ISO_DATE_TIME);
            ScheduledEvent scheduledEvent = new ScheduledEvent(title, dateTime);
            events.put(title, scheduledEvent);
            event.reply("Event scheduled: **" + title + "** at **" + dateTime + "**").queue();
        } catch (Exception e) {
            event.reply("Error scheduling event: " + e.getMessage()).queue();
        }
    }

    // Command: View scheduled events
    private void viewEvents(SlashCommandInteractionEvent event) {
        if (events.isEmpty()) {
            event.reply("No scheduled events.").queue();
            return;
        }

        StringBuilder response = new StringBuilder("Scheduled Events:\n");
        for (ScheduledEvent scheduledEvent : events.values()) {
            response.append("**").append(scheduledEvent.getTitle()).append("** at **")
                    .append(scheduledEvent.getDateTime().format(DateTimeFormatter.ISO_DATE_TIME)).append("**\n");
        }

        event.reply(response.toString()).queue();
    }

    // Command: Cancel an event
    private void cancelEvent(SlashCommandInteractionEvent event) {
        String title = event.getOption("title").getAsString();
        if (events.remove(title) != null) {
            event.reply("Event **" + title + "** has been canceled.").queue();
        } else {
            event.reply("Event **" + title + "** not found.").queue();
        }
    }

    // Command: Remind about an event
    private void remindEvent(SlashCommandInteractionEvent event) {
        String title = event.getOption("title").getAsString();
        ScheduledEvent scheduledEvent = events.get(title);

        if (scheduledEvent != null) {
            LocalDateTime now = LocalDateTime.now();
            if (now.isBefore(scheduledEvent.getDateTime())) {
                long secondsUntilEvent = java.time.Duration.between(now, scheduledEvent.getDateTime()).getSeconds();
                event.reply("Reminder set for **" + scheduledEvent.getTitle() + "** in " + secondsUntilEvent + " seconds.").queue();
            } else {
                event.reply("Event **" + scheduledEvent.getTitle() + "** has already started or ended.").queue();
            }
        } else {
            event.reply("Event **" + title + "** not found.").queue();
        }
    }

    // Command: Get event info
    private void eventInfo(SlashCommandInteractionEvent event) {
        String title = event.getOption("title").getAsString();
        ScheduledEvent scheduledEvent = events.get(title);

        if (scheduledEvent != null) {
            event.reply("Event: **" + scheduledEvent.getTitle() + "**\nTime: **"
                    + scheduledEvent.getDateTime().format(DateTimeFormatter.ISO_DATE_TIME) + "**").queue();
        } else {
            event.reply("Event **" + title + "** not found.").queue();
        }
    }

    // Inner class to represent a scheduled event
    private static class ScheduledEvent {
        private final String title;
        private final LocalDateTime dateTime;

        public ScheduledEvent(String title, LocalDateTime dateTime) {
            this.title = title;
            this.dateTime = dateTime;
        }

        public String getTitle() {
            return title;
        }

        public LocalDateTime getDateTime() {
            return dateTime;
        }
    }
}
