# DJ Sage Bot

**DJ Sage** is a simple Discord bot built using Java and JDA (Java Discord API). It offers a some common  commands for server moderation, fun activities, event management, user analytics, and more.

## Features

- **Admin Commands**: Manage your server with ease using commands like mute, unmute, kick, ban, and message clearing.
- **Fun Commands**: Engage users with games such as dice roll, trivia, coin toss, and Rock, Paper, Scissors.
- **Treasure Hunt**: Organize treasure hunts with dynamic clues and leaderboards.
- **Reaction Roles**: Allow users to self-assign roles by reacting to messages.
- **Event Scheduler**: Schedule events, set reminders, and view upcoming events.
- **User Analytics**: Track user activity, statistics, and generate reports for server admins.

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/DJSage.git
    ```

2. Install dependencies with Maven.

3. Add your Discord bot token to the `DJBot.java` file:
    ```java
    private static final String TOKEN = "YOUR_BOT_TOKEN";
    ```

4. Run the bot using:
    ```bash
    mvn clean package
    java -jar target/DJSageBot.jar
    ```

## MongoDB Setup

The bot uses MongoDB to store user statistics, event data, and treasure hunt progress. Ensure you have MongoDB installed and configure your connection in `MongoManager.java`.

## Commands Overview

- **Admin Commands**: `mute`, `unmute`, `kick`, `ban`, `clear`
- **Fun Commands**: `roll-dice`, `trivia`, `random-fact`, `coin-toss`, `rps`
- **Treasure Hunt**: `start-hunt`, `get-clue`, `submit-answer`, `view-leaderboard`
- **Reaction Roles**: `reaction-role-setup`, `assign-role`, `remove-role`
- **Event Scheduler**: `schedule-event`, `view-events`, `cancel-event`, `remind-event`
- **User Analytics**: `user-stats`, `top-active-users`, `track-message`

## Contributing

Feel free to contribute by submitting pull requests or opening issues. Make sure to follow the project's coding standards and include clear commit messages.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

