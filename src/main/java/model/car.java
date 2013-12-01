package model;

import com.google.code.morphia.annotations.Entity;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Car {

    @NotEmpty
    private String name;
    private String location;
    private String information;
    private double price;
}
