# DJ Sage Bot

**DJ Sage** is a powerful and feature-rich Discord bot built using Java and the JDA (Java Discord API). It enhances your Discord server with advanced administrative tools, interactive fun commands, event scheduling, reaction roles, user analytics, and an engaging treasure hunt feature.

## 🛠️ Features

### 🎛️ Admin Commands
- **Mute/Unmute**: Manage user participation in voice channels.
- **Kick/Ban**: Remove disruptive members from the server.
- **Clear Messages**: Bulk delete messages from channels for moderation.

### 🎉 Fun Commands
- **Roll Dice**: Simulate rolling a dice.
- **Trivia**: Challenge users with trivia questions.
- **Random Fact**: Share interesting facts.
- **Coin Toss**: Flip a coin for random outcomes.
- **Jokes**: Tell a variety of jokes.
- **Choose**: Let the bot make choices from provided options.
- **Rock, Paper, Scissors**: Play the classic game against the bot.

### 🏆 Treasure Hunt
- **Start Hunt**: Initiate a new treasure hunt.
- **Get Clue**: Retrieve the current clue.
- **Submit Answer**: Submit answers to clues.
- **View Leaderboard**: Display the top participants.
- **Hint**: Request hints for difficult clues.
- **End Hunt**: Conclude the treasure hunt.
- **My Progress**: Check individual progress in the hunt.

### 🎭 Reaction Roles
- **Setup Reaction Role**: Assign roles based on message reactions with customizable emojis and images.
- **Remove Reaction Role Setup**: Remove existing reaction role configurations.
- **Assign/Remove Role**: Self-assign or remove roles.
- **List Roles**: Display all available roles in the server.

### 📊 User Analytics
- **User Stats**: Retrieve statistics for individual users.
- **Top Active Users**: Display the most active members.
- **User Activity**: View detailed activity logs.
- **Clear User Stats**: Reset all user statistics.
- **Track Message**: Monitor the number of messages sent by users.

### 📅 Event Scheduler
- **Schedule Event**: Create and schedule new events.
- **View Events**: List all upcoming events.
- **Cancel Event**: Remove scheduled events.
- **Remind Event**: Set reminders for specific events.
- **Event Info**: Get detailed information about an event.

## 🚀 Installation

### Prerequisites
- **Java 8** or higher
- **Maven** or **Gradle** for dependency management
- **MongoDB** instance for database operations

### Steps

1. **Clone the Repository**
    ```bash
    git clone https://github.com/yourusername/DJSage.git
    cd DJSage
    ```

2. **Install Dependencies**
    - If using **Maven**:
        ```bash
        mvn clean install
        ```
    - If using **Gradle**:
        ```bash
        gradle build
        ```

3. **Configure the Bot**
    - Open `DJBot.java` and replace the placeholder token with your actual Discord bot token:
        ```java
        private static final String TOKEN = "YOUR_BOT_TOKEN_HERE";
        ```

4. **Set Up MongoDB**
    - Ensure MongoDB is running and accessible.
    - Configure the MongoDB URI in `MongoManager.java`:
        ```java
        String uri = "mongodb://localhost:27017"; // Update with your MongoDB URI
        ```

5. **Run the Bot**
    - Execute the JAR file:
        ```bash
        java -jar target/DJSageBot.jar
        ```

## ⚙️ Configuration

- **Bot Token**: Securely store your Discord bot token and never expose it publicly.
- **MongoDB URI**: Ensure your MongoDB instance is correctly configured and accessible.
- **Permissions**: Assign necessary permissions to the bot in your Discord server for optimal functionality.

## 📚 Usage

Once the bot is running and added to your Discord server, you can interact with it using the registered slash commands. Type `/` in your Discord server to see the list of available commands.

### Example Commands

- `/roll-dice` – Roll a dice.
- `/trivia` – Ask a trivia question.
- `/mute @user` – Mute a user.
- `/reaction-role-setup` – Setup a reaction role with custom emoji and image.

## 🗄️ MongoDB Collections

- **users**: Store user information and statistics.
- **commands**: Track custom commands and configurations.
- **reaction_roles**: Manage reaction role settings.
- **treasure_hunts**: Monitor active treasure hunts and participant progress.
- **events**: Handle scheduled events and reminders.
- **analytics**: Collect and analyze user activity data.

## 🤝 Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes. Ensure that your code follows the project's coding standards and includes relevant documentation.

## 📜 License

This project is licensed under the [MIT License](LICENSE).

## 📞 Support

If you encounter any issues or have questions, feel free to open an issue on the [GitHub repository](https://github.com/yourusername/DJSage/issues) or contact the maintainer directly.

---

**Enjoy using DJ Sage Bot to enhance your Discord server experience!** 🎶🤖
