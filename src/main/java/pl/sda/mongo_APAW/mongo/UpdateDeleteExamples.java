package pl.sda.mongo_APAW.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

public class UpdateDeleteExamples {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient();
        MongoCollection<Document> collection = mongoClient.getDatabase("new").getCollection("uzytkownicy");

        UpdateResult updateResult = collection.updateOne(Filters.eq("name", "Any4"),
                new Document("$set", new Document("age", 40))
                );

        System.out.println(updateResult.getModifiedCount());


        UpdateResult updateMany = collection.updateMany(Filters.eq("age", 5),
                new Document("$set", new Document("name", "dorosły")));
        System.out.println(updateMany.getModifiedCount());

        DeleteResult deleteResult = collection.deleteMany(Filters.eq("age", 99));
        System.out.println(deleteResult.getDeletedCount());


    }
}
