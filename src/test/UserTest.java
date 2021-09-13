package test;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import java.util.Arrays;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-31-08
 */
public class UserTest {

    private MongoDatabase connectMongoDB(String name, String databaseName, char[] pswd){
        MongoCredential credential = MongoCredential.createCredential(name,databaseName,pswd);
        MongoClientOptions customClientOptions = new MongoClientOptions.Builder().connectionsPerHost(100000).build();
        MongoClient mongoClient = new MongoClient(new ServerAddress("localhost",27017), credential,customClientOptions);
        MongoDatabase db = mongoClient.getDatabase("wechat");
        return db;
    }

    private MongoCollection<Document> getDBcollection(MongoDatabase db,String setName){
        MongoIterable<String> cols = db.listCollectionNames();
        for(String c : cols){
            System.out.println("collectionName: " + c);
        }
        MongoCollection<Document> col = db.getCollection(setName);
        if (col != null)
            return col;
        else
            return null;
    }

    private void insertCollection(MongoCollection<Document> col, String username,String password){
        Document doc =new Document();
        doc.put("usename", username);
        doc.put("password", password);
        col.insertOne(doc);
    }

    private void findColByColName(MongoCollection<Document> doc)
    {
        FindIterable<Document> mydoc = doc.find();
        for (Document d : mydoc)
        {
            System.out.println(d.toJson());
            System.out.println(d.toString());
        }
    }

    public static void main(String[] args)
    {
        UserTest mo = new UserTest();
        MongoDatabase db = mo.connectMongoDB("root","wechat","tiger".toCharArray());
        if(db!=null){
            MongoCollection<Document> doc = mo.getDBcollection(db, "t_users");
            if(doc!=null){
                mo.insertCollection(doc, "chener", "123");
                mo.findColByColName(doc);
            }
        }
    }
}
