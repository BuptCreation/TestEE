package utils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.concurrent.LinkedBlockingQueue;

public class MongoHelper {

    static final String DBName = "BuptCreation";
    static final String ServerAddress = "47.94.108.20";
    static final int PORT = 27017;

    private MongoHelper() {
    }

    private static MongoClient mongoClient = new MongoClient(ServerAddress, PORT);

    // 模拟连接池(阻塞队列)
    private static LinkedBlockingQueue<MongoDatabase> mongoDatabases = new LinkedBlockingQueue<MongoDatabase>(10);

    static {
        initMongoDatabases();
    }

    private static void initMongoDatabases() {
        for (int i = 0; i < 10; i++) {
            MongoDatabase mDatabase = mongoClient.getDatabase(DBName);
            mongoDatabases.add(mDatabase);
        }
    }

    public static void closeMongoClient(MongoDatabase mongoDatabase) {
        mongoDatabases.add(mongoDatabase);
    }

    public static MongoDatabase getMongoDataBase() {
        try {
            MongoDatabase mDatabase = mongoDatabases.take();
            return mDatabase;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
