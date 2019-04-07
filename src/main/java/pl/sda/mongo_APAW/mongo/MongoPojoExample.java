package pl.sda.mongo_APAW.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoPojoExample {

    public static void main(String[] args) {
        CodecRegistry codecRegistry = fromRegistries(
                MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(codecRegistry)
                .build();
        com.mongodb.client.MongoClient mongoClient = MongoClients.create(settings);

        MongoCollection<User> collection = mongoClient.getDatabase("new").getCollection("uzytkownicy", User.class);

        for (User user : collection.find()) {
            System.out.println(user);
        }

//        collection.insertOne(new User("abc", "cde", 134));

//        collection.deleteOne(Filters.eq("name", "Andy1"));

//        collection.deleteMany(Filters.eq("name", "Andy2"));

//        collection.insertOne(new User("dwe", "fert", 432));


    }
}
