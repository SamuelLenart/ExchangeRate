package sk.kosickaakademia.lenart.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Database {
    private static final MongoClient mongoClient = new MongoClient();
    private static MongoDatabase database;
    private static MongoCollection<Document> test;
    private static Document docs;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void writeData(double value, String[] to){
        database = mongoClient.getDatabase("DBrate");
        test = database.getCollection("conversion");
        JSONObject object = new JSONObject();
        object.put("value", value);
        object.put("to", to);
        object.put("datetime", format.format(new Date()));
        docs = Document.parse(object.toJSONString());
        test.insertOne(docs);
    }
    public void test(){
        database=mongoClient.getDatabase("testDB");
        test = database.getCollection("test");
        docs=new Document("name","samuel").append("ages",new Document("age","20"));
        test.insertOne(docs);
    }
}
