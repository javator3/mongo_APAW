package pl.sda.mongo_APAW.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoConnectionExample {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient();

        for (String databeseName : mongoClient.listDatabaseNames()) {
            System.out.println(databeseName);

            MongoDatabase database = mongoClient.getDatabase("local");
//            database.createCollection("Person");
//            database.createCollection("Users");

//            for (String collectionName : database.listCollectionNames()) {
//                System.out.println(collectionName);
//            }

            MongoCollection<Document> users = database.getCollection("Users");
            users.drop();

            for (String collectionName : database.listCollectionNames()) {
                System.out.println(collectionName);
            }
        }


    }
}

