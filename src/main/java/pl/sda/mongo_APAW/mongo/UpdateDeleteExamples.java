package pl.sda.mongo_APAW.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.types.ObjectId;

public class UpdateDeleteExamples {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient();
        MongoCollection<Document> collection = mongoClient.getDatabase("new").getCollection("uzytkownicy");

//        UpdateResult updateResult = collection.updateOne(Filters.eq("name", "Any4"),
//                new Document("$set", new Document("age", 40))
//                );
//
//        System.out.println(updateResult.getModifiedCount());
//
//
//        UpdateResult updateMany = collection.updateMany(Filters.eq("age", 5),
//                new Document("$set", new Document("name", "dorosły")));
//        System.out.println(updateMany.getModifiedCount());
//
//        DeleteResult deleteResult = collection.deleteMany(Filters.eq("age", 99));
//        System.out.println(deleteResult.getDeletedCount());

        //usuń wszystkich którzy mają na imię Adam

//        DeleteResult deleteResult1 = collection.deleteMany(Filters.eq("name", "Adam"));
//        System.out.println(deleteResult1.getDeletedCount());

        // usuń dokument o podanym id przez użytkownika


//        removeId("5ca878fcd51fa9781515a6e6", collection);
    setAgeById("5ca876cb50d1b503d38fe893", collection);

    }

    static void removeId (String id, MongoCollection<Document> collection){

        DeleteResult deleteResult2 = collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
        System.out.println(deleteResult2.getDeletedCount());
    }

    // ustaw wiek 150 dla elementu o id podanym przez użytkowniks

    static void setAgeById (String id, MongoCollection<Document> collection){

        UpdateResult updateResult3 = collection.updateOne(Filters.eq("_id", new ObjectId(id)), new Document("$set", new Document("age", 150)));
        System.out.println(updateResult3.getModifiedCount());

    }
}
