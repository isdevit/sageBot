package bot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Role;

import java.util.List;

public class ReactionRoles extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "assign-role":
                assignRole(event);
                break;
            case "remove-role":
                removeRole(event);
                break;
            case "list-roles":
                listRoles(event);
                break;
            case "reaction-role-setup":
                reactionRoleSetup(event);
                break;
            case "remove-reaction-role-setup":
                removeReactionRoleSetup(event);
                break;
        }
    }

    // Command: Assign role based on reaction
    private void assignRole(SlashCommandInteractionEvent event) {
        String roleId = event.getOption("role-id").getAsString(); // Fetch role ID from the command option
        Role role = event.getGuild().getRoleById(roleId);
        try {
            if (role != null) {
                event.getGuild().addRoleToMember(event.getUser(), role).queue(
                        success -> event.reply("Role assigned successfully!").queue(),
                        failure -> event.reply("Failed to assign role: " + failure.getMessage()).queue()
                );
            } else {
                event.reply("Role not found!").queue();
            }
        } catch (Exception e) {
            event.reply("An error occurred while assigning the role.").queue();
        }
    }

    // Command: Remove role based on reaction
    private void removeRole(SlashCommandInteractionEvent event) {
        String roleId = event.getOption("role-id").getAsString(); // Fetch role ID from the command option
        Role role = event.getGuild().getRoleById(roleId);
        try {
            if (role != null) {
                event.getGuild().removeRoleFromMember(event.getUser(), role).queue(
                        success -> event.reply("Role removed successfully!").queue(),
                        failure -> event.reply("Failed to remove role: " + failure.getMessage()).queue()
                );
            } else {
                event.reply("Role not found!").queue();
            }
        } catch (Exception e) {
            event.reply("An error occurred while removing the role.").queue();
        }
    }

    // Command: List available roles
    private void listRoles(SlashCommandInteractionEvent event) {
        try {
            StringBuilder rolesList = new StringBuilder();
            List<Role> roles = event.getGuild().getRoles();
            if (roles.isEmpty()) {
                event.reply("No roles available.").queue();
                return;
            }
            for (Role role : roles) {
                rolesList.append(role.getName()).append(" (ID: ").append(role.getId()).append(")\n");
            }
            event.reply("Available Roles:\n" + rolesList.toString()).queue();
        } catch (Exception e) {
            event.reply("An error occurred while listing roles.").queue();
        }
    }

    // Command: Reaction role setup
    private void reactionRoleSetup(SlashCommandInteractionEvent event) {
        event.reply("Reaction Role setup initiated! Please add reactions to the message to assign roles.").queue();
        // Logic for setting up reaction roles can be added here
    }

    // Command: Remove reaction role setup
    private void removeReactionRoleSetup(SlashCommandInteractionEvent event) {
        event.reply("Reaction Role setup removal initiated! Please confirm the removal of the reaction roles.").queue();
        // Logic for removing reaction roles can be added here
    }
}
