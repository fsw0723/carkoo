package com.carkoo.dataaccess;


import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDB {
    private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(MongoDB.class.getName());
    private static final MongoDB INSTANCE = new MongoDB();

    private final Datastore datastore;
    public static final String DB_NAME = "carkoo";

    public MongoDB() {
        try {
            MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
            mongoClient.setWriteConcern(WriteConcern.SAFE);
            datastore = new Morphia().mapPackage("com.carkoo.model")
                    .createDatastore(mongoClient, DB_NAME);
            datastore.ensureIndexes();
            LOG.info("Connection to database '" + DB_NAME + "' initialized");
        } catch (Exception e) {
            throw new RuntimeException("Error initializing MongoDB", e);
        }
    }

    public static MongoDB instance() {
        return INSTANCE;
    }

    public Datastore getDatabase() {
        return datastore;
    }
}