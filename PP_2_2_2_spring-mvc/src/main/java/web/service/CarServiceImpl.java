package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.Car;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{


    private List<Car> cars;

    public CarServiceImpl() {
        cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Supra", 1500));
        cars.add(new Car("Subaru", "Impreza", 300));
        cars.add(new Car("Nissan", "Skyline", 500));
        cars.add(new Car("Nissan", "370z", 400));
        cars.add(new Car("Porsche", "911", 420));
    }

    public List<Car> outWithParam(Integer count){

        if (count == null || count >= 5) {
            return cars;
        } else if (count == 0) {
            throw new IllegalArgumentException("Count cannot be negative.");
        } else {
            return cars.stream()
                    .limit(count)
                    .collect(Collectors.toList());
        }
    }
}