package bot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Random;

public class FunCommands extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "roll-dice":
                rollDice(event);
                break;
            case "trivia":
                trivia(event);
                break;
            case "random-fact":
                randomFact(event);
                break;
            case "coin-toss":
                coinToss(event);
                break;
            case "joke":
                joke(event);
                break;
            case "choose":
                choose(event);
                break;
            case "rps":
                rockPaperScissors(event);
                break;
        }
    }

    // Command: Roll a dice
    private void rollDice(SlashCommandInteractionEvent event) {
        try {
            int dice = new Random().nextInt(6) + 1;
            event.reply("You rolled a " + dice + "!").queue();
        } catch (Exception e) {
            event.reply("An error occurred while rolling the dice.").queue();
        }
    }

    // Command: Trivia
    private void trivia(SlashCommandInteractionEvent event) {
        try {
            event.reply("Trivia: What is the capital of France? (Hint: It's Paris!)").queue();
        } catch (Exception e) {
            event.reply("Failed to fetch trivia question.").queue();
        }
    }

    // Command: Random fact
    private void randomFact(SlashCommandInteractionEvent event) {
        try {
            event.reply("Random Fact: Honey never spoils!").queue();
        } catch (Exception e) {
            event.reply("Failed to fetch random fact.").queue();
        }
    }

    // Command: Coin toss
    private void coinToss(SlashCommandInteractionEvent event) {
        try {
            String result = new Random().nextBoolean() ? "Heads" : "Tails";
            event.reply("The coin landed on: " + result).queue();
        } catch (Exception e) {
            event.reply("An error occurred during the coin toss.").queue();
        }
    }

    // Command: Joke
    private void joke(SlashCommandInteractionEvent event) {
        try {
            event.reply("Why don’t skeletons fight each other? They don’t have the guts!").queue();
        } catch (Exception e) {
            event.reply("Failed to deliver a joke.").queue();
        }
    }

    // Command: Choose between options
    private void choose(SlashCommandInteractionEvent event) {
        try {
            String[] options = event.getOptionsByName("options").get(0).getAsString().split(",");
            String choice = options[new Random().nextInt(options.length)];
            event.reply("I choose: " + choice).queue();
        } catch (Exception e) {
            event.reply("Please provide valid options for me to choose from.").queue();
        }
    }

    // Command: Rock, Paper, Scissors
    private void rockPaperScissors(SlashCommandInteractionEvent event) {
        try {
            String[] choices = {"Rock", "Paper", "Scissors"};
            String botChoice = choices[new Random().nextInt(choices.length)];
            event.reply("I choose " + botChoice + "!").queue();
        } catch (Exception e) {
            event.reply("An error occurred while playing Rock, Paper, Scissors.").queue();
        }
    }
}
