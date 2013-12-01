package dataaccess;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;
import model.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDAO extends BasicDAO<Car, String> {

    protected CarDAO(Mongo mongo, Morphia morphia, String dbName) {
        super(mongo, morphia, dbName);
    }

    public List<Car> findAll(){
       return ds.find(Car.class).asList();
    }
}
