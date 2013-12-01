package dataaccess;

import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;
import model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MorphiaConfig {
        @Value("${mongodb.connection.db}")
        private String appDbName;

        @Value("${mongodb.connection.host}")
        private String dbHost;

        @Value("${mongodb.connection.port}")
        private int dbPort;

        @Value("${mongodb.connection.connections_per_host:40}")
        private int connectionsPerHost;

        @Value("${mongodb.connection.thread_multiplier:1500}")
        private int threadMultiplier;

        @SuppressWarnings("UnusedDeclaration")
        // Autowired in MongoCouponRepository
        @Bean
        public String dbName()
        {
            return appDbName;
        }

        @Bean
        public Mongo mongo() throws UnknownHostException, MongoException
        {
            Mongo m;
            MongoOptions options = new MongoOptions();
            options.connectionsPerHost = connectionsPerHost;
            options.threadsAllowedToBlockForConnectionMultiplier = threadMultiplier;
            Logger logger = LoggerFactory.getLogger(this.getClass());
            logger.info("MONGODB: Instantiating MongoDB bean");
            if (dbHost.contains(",")) {
                logger.info("MONGODB: Attempting to use replica set configuration");
                m = new Mongo(replicaSets(), options);
                logger.info("MONGODB: Replica set configuration used successfully");
            } else {
                m = new Mongo(new ServerAddress(dbHost, dbPort), options);
            }

            logger.info("MONGODB: MongoDB bean created successfully");
            return m;
        }

        protected List<ServerAddress> replicaSets() throws UnknownHostException
        {
            return addServers(dbHost.split(","));
        }

        private List<ServerAddress> addServers(String[] hosts) throws UnknownHostException
        {
            List<ServerAddress> addresses = new ArrayList<ServerAddress>();
            for (String host : hosts) {
                addresses.add(new ServerAddress(host.trim(), dbPort));
            }
            return addresses;
        }

        @Bean
        public Morphia morphia()
        {

            Logger logger = LoggerFactory.getLogger(this.getClass());
            logger.info("MORPHIA: Instantiating MongoDB bean");

            Morphia morphia = new Morphia();
            morphia.map(Car.class);

            logger.info("MORPHIA: Morphia bean created successfully");

            return morphia;
        }




}
