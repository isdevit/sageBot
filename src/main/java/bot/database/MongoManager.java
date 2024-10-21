package bot.database;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoManager {

    private final MongoClient mongoClient;
    private final MongoDatabase database;

    public MongoManager() {
        // Replace with your MongoDB connection string
        String uri = "mongodb://localhost:27017/"; // Replace with your MongoDB URI
        mongoClient = MongoClients.create(uri);
        database = mongoClient.getDatabase("DJBotDB"); // Use your database name
    }

    // Getters for collections
    public MongoCollection<Document> getUsersCollection() {
        return database.getCollection("users");
    }

    public MongoCollection<Document> getCommandsCollection() {
        return database.getCollection("commands");
    }

    public MongoCollection<Document> getReactionRolesCollection() {
        return database.getCollection("reaction_roles");
    }

    public MongoCollection<Document> getTreasureHuntsCollection() {
        return database.getCollection("treasure_hunts");
    }

    public MongoCollection<Document> getEventsCollection() {
        return database.getCollection("events");
    }

    public MongoCollection<Document> getAnalyticsCollection() {
        return database.getCollection("analytics");
    }

    // Method to close the MongoDB connection
    public void close() {
        mongoClient.close();
    }
}
