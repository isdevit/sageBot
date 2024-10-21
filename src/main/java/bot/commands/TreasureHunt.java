package bot.commands;

import bot.database.MongoManager;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class TreasureHunt extends ListenerAdapter {
/*
    private final MongoManager mongoManager;

    public TreasureHunt(MongoManager mongoManager) {
        this.mongoManager = mongoManager;
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "start-hunt":
                startHunt(event);
                break;
            case "get-clue":
                getClue(event);
                break;
            case "submit-answer":
                submitAnswer(event);
                break;
            case "view-leaderboard":
                viewLeaderboard(event);
                break;
            case "hint":
                hint(event);
                break;
            case "end-hunt":
                endHunt(event);
                break;
            case "my-progress":
                myProgress(event);
                break;
        }
    }

    // Command: Start hunt
    private void startHunt(SlashCommandInteractionEvent event) {
        try {
            // Logic to start the treasure hunt
            event.reply("The treasure hunt has started! Solve the clues to win.").queue();
            mongoManager.startHunt(event.getGuild().getId()); // Save to MongoDB
        } catch (Exception e) {
            event.reply("An error occurred while starting the hunt.").queue();
        }
    }

    // Command: Get clue
    private void getClue(SlashCommandInteractionEvent event) {
        try {
            String clue = mongoManager.getClue(event.getGuild().getId()); // Fetch clue from MongoDB
            event.reply("Clue: " + clue).queue();
        } catch (Exception e) {
            event.reply("An error occurred while fetching the clue.").queue();
        }
    }

    // Command: Submit answer
    private void submitAnswer(SlashCommandInteractionEvent event) {
        String answer = event.getOption("answer").getAsString();
        try {
            boolean isCorrect = mongoManager.checkAnswer(event.getGuild().getId(), answer); // Check answer in MongoDB
            if (isCorrect) {
                event.reply("Correct answer! You've solved the clue.").queue();
            } else {
                event.reply("Wrong answer. Try again!").queue();
            }
        } catch (Exception e) {
            event.reply("An error occurred while submitting your answer.").queue();
        }
    }

    // Command: View leaderboard
    private void viewLeaderboard(SlashCommandInteractionEvent event) {
        try {
            List<String> leaderboard = mongoManager.getLeaderboard(event.getGuild().getId()); // Fetch leaderboard from MongoDB
            StringBuilder leaderboardMessage = new StringBuilder("**Leaderboard:**\n");
            for (String entry : leaderboard) {
                leaderboardMessage.append(entry).append("\n");
            }
            event.reply(leaderboardMessage.toString()).queue();
        } catch (Exception e) {
            event.reply("An error occurred while fetching the leaderboard.").queue();
        }
    }

    // Command: Ask for a hint
    private void hint(SlashCommandInteractionEvent event) {
        try {
            String hint = mongoManager.getHint(event.getGuild().getId()); // Fetch hint from MongoDB
            event.reply("Hint: " + hint).queue();
        } catch (Exception e) {
            event.reply("An error occurred while fetching the hint.").queue();
        }
    }

    // Command: End hunt
    private void endHunt(SlashCommandInteractionEvent event) {
        try {
            mongoManager.endHunt(event.getGuild().getId()); // Logic to end the hunt and save results to MongoDB
            event.reply("The treasure hunt has ended!").queue();
        } catch (Exception e) {
            event.reply("An error occurred while ending the hunt.").queue();
        }
    }

    // Command: My progress
    private void myProgress(SlashCommandInteractionEvent event) {
        try {
            String progress = mongoManager.getUserProgress(event.getGuild().getId(), event.getUser().getId()); // Fetch user progress
            event.reply("Your progress: " + progress).queue();
        } catch (Exception e) {
            event.reply("An error occurred while fetching your progress.").queue();
        }
    }*/
}
