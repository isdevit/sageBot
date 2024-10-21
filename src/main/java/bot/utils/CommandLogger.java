package bot.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommandLogger {

    public static void log(String message) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[" + time + "] " + message);
    }
}
