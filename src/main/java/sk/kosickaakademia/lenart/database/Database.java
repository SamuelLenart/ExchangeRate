package sk.kosickaakademia.lenart.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Database {
    private static MongoClient client = MongoClient.create();

    public void test(){
        MongoDatabase database = client.getDatabase("test");
        MongoCollection<Document> toys = database.getCollection("test21");
        Document toy = new Document("name", "yoyo").append("ages", new Document());
        toys.insertOne(toy);
    }
    /*private static final MongoClient mongoClient = new MongoClient();
    private static final MongoDatabase database = mongoClient.getDatabase("test");;
    private static MongoCollection<Document> test = database.getCollection("currency");
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public <T> void add(String from, String to, double value, T result){
        test = database.getCollection("currency");
        JSONObject object = new JSONObject();
        object.put("datetime", format.format(new Date()));
        object.put("value", value);
        object.put("from", from);
        object.put("to", to);
        object.put("result", result);
        System.out.println(object);
        Document doc = Document.parse(object.toJSONString());
        test.insertOne(doc);
    }*/
}
