package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @OneToOne(mappedBy = "car")
    private User user;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }
//
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return series == car.series && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, series);
    }
}
