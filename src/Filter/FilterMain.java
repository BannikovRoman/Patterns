package Filter;

import java.util.ArrayList;
import java.util.List;

//Паттерн необходим для фильтрации объектов по определенным полям
public class FilterMain {
    public static void main(String[] args) {
        CarF carF1 = new CarF(150, "green", 4);
        CarF carF2 = new CarF(200, "red", 2);
        CarF carF3 = new CarF(250, "black", 4);

        List<CarF> cars = new ArrayList<>();

        cars.add(carF1);
        cars.add(carF2);
        cars.add(carF3);

        cars = new SpeedFilter().filter(cars);
        for (CarF car : cars) {
            System.out.println(car.toString());
        }
    }
}

//определяем метод фильтр
interface CarFilter {
    List<CarF> filter(List<CarF> cars);
}

//создаем фильтр по максимальной скорости
//аналогично можно создать фильтр по количеству дверей или цвету (это будет новый класс)
class SpeedFilter implements CarFilter {

    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = new ArrayList<>();

        for (CarF car : cars) {
            if(car.getMaxSpeed() > 180) {
                list.add(car);
            }
        }
        return list;
    }
}

//можно применять сразу несколько фильтров в связке AND
class AndFilter implements CarFilter {
    CarFilter filterOne;
    CarFilter filterTwo;

    public AndFilter(CarFilter filterOne, CarFilter filterTwo) {
        this.filterOne = filterOne;
        this.filterTwo = filterTwo;
    }

    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = filterOne.filter(cars);
        return filterTwo.filter(list);
    }
}

//можно применять сразу несколько фильтров в связке OR
class OrFilter implements CarFilter {
    CarFilter filterOne;
    CarFilter filterTwo;

    public OrFilter(CarFilter filterOne, CarFilter filterTwo) {
        this.filterOne = filterOne;
        this.filterTwo = filterTwo;
    }

    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = filterOne.filter(cars);
        List<CarF> list2 = filterTwo.filter(cars);

        for (CarF car : list2) {
            if(!list.contains(car)){
                list.add(car);
            }
        }
        return list;
    }
}

class CarF {
    private int maxSpeed;
    private String color;
    private int door;

    public CarF(int maxSpeed, String color, int door) {
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.door = door;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "CarF{" +
                "maxSpeed=" + maxSpeed +
                ", color='" + color + '\'' +
                ", door=" + door +
                '}';
    }
}