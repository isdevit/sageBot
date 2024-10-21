package bot.commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class AdminCommands extends ListenerAdapter {

    // Command: Mute user
    public void onSlashCommand(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "mute":
                mute(event);
                break;
            case "unmute":
                unmute(event);
                break;
            case "kick":
                kick(event);
                break;
            case "ban":
                ban(event);
                break;
            case "clear":
                clearMessages(event);
                break;
            case "add-role":
                addRole(event);
                break;
            case "remove-role":
                removeRole(event);
                break;
        }
    }

    // Mute command logic
    private void mute(SlashCommandInteractionEvent event) {
        try {
            Member memberToMute = event.getOption("user").getAsMember();
            Role muteRole = event.getGuild().getRolesByName("Muted", true).get(0);

            if (memberToMute != null && muteRole != null) {
                event.getGuild().addRoleToMember(memberToMute, muteRole).queue(
                        success -> event.reply("User muted successfully!").queue(),
                        failure -> event.reply("Failed to mute the user: " + failure.getMessage()).queue()
                );
            } else {
                event.reply("User or Muted role not found!").queue();
            }
        } catch (Exception e) {
            event.reply("An error occurred while muting the user.").queue();
        }
    }

    // Unmute command logic
    private void unmute(SlashCommandInteractionEvent event) {
        try {
            Member memberToUnmute = event.getOption("user").getAsMember();
            Role muteRole = event.getGuild().getRolesByName("Muted", true).get(0);

            if (memberToUnmute != null && muteRole != null) {
                event.getGuild().removeRoleFromMember(memberToUnmute, muteRole).queue(
                        success -> event.reply("User unmuted successfully!").queue(),
                        failure -> event.reply("Failed to unmute the user: " + failure.getMessage()).queue()
                );
            } else {
                event.reply("User or Muted role not found!").queue();
            }
        } catch (Exception e) {
            event.reply("An error occurred while unmuting the user.").queue();
        }
    }

    // Kick command logic
    private void kick(SlashCommandInteractionEvent event) {
        try {
            Member memberToKick = event.getOption("user").getAsMember();

            if (memberToKick != null) {
                event.getGuild().kick(memberToKick).queue(
                        success -> event.reply("User kicked successfully!").queue(),
                        failure -> event.reply("Failed to kick the user: " + failure.getMessage()).queue()
                );
            } else {
                event.reply("User not found!").queue();
            }
        } catch (Exception e) {
            event.reply("An error occurred while kicking the user.").queue();
        }
    }

    // Ban command logic
    private void ban(SlashCommandInteractionEvent event) {
        try {
            Member memberToBan = event.getOption("user").getAsMember();

            if (memberToBan != null) {
                event.getGuild().ban(memberToBan, 0).queue(
                        success -> event.reply("User banned successfully!").queue(),
                        failure -> event.reply("Failed to ban the user: " + failure.getMessage()).queue()
                );
            } else {
                event.reply("User not found!").queue();
            }
        } catch (Exception e) {
            event.reply("An error occurred while banning the user.").queue();
        }
    }

    // Clear messages command logic
    private void clearMessages(SlashCommandInteractionEvent event) {
        try {
            int messageCount = event.getOption("amt").getAsInt();
            MessageChannel channel = event.getChannel();

            channel.getIterableHistory().takeAsync(messageCount).thenAccept(messages -> {
                channel.purgeMessages(messages);
                event.reply("Cleared " + messages.size() + " messages.").queue();
            }).exceptionally(throwable -> {
                event.reply("An error occurred while clearing messages.").queue();
                return null;
            });
        } catch (Exception e) {
            event.reply("Failed to clear messages.").queue();
        }
    }

    // Command to add a role to a user
    private void addRole(SlashCommandInteractionEvent event) {
        try {
            Member targetMember = event.getOption("user").getAsMember();
            Role roleToAdd = event.getOption("role").getAsRole();

            if (targetMember != null && roleToAdd != null) {
                event.getGuild().addRoleToMember(targetMember, roleToAdd).queue(
                        success -> event.reply("Role added successfully!").queue(),
                        failure -> event.reply("Failed to add role: " + failure.getMessage()).queue()
                );
            } else {
                event.reply("User or role not found!").queue();
            }
        } catch (Exception e) {
            event.reply("An error occurred while adding the role.").queue();
        }
    }

    // Command to remove a role from a user
    private void removeRole(SlashCommandInteractionEvent event) {
        try {
            Member targetMember = event.getOption("user").getAsMember();
            Role roleToRemove = event.getOption("role").getAsRole();

            if (targetMember != null && roleToRemove != null) {
                event.getGuild().removeRoleFromMember(targetMember, roleToRemove).queue(
                        success -> event.reply("Role removed successfully!").queue(),
                        failure -> event.reply("Failed to remove role: " + failure.getMessage()).queue()
                );
            } else {
                event.reply("User or role not found!").queue();
            }
        } catch (Exception e) {
            event.reply("An error occurred while removing the role.").queue();
        }
    }
}
