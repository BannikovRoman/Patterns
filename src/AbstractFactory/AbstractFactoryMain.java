package AbstractFactory;

public class AbstractFactoryMain {
    public static void main(String[] args) {
        //создаем фабрики
        Factory carFactory = new AbstractFactory().createFactory("Car");
        Factory tankFactory = new AbstractFactory().createFactory("Tank");

        //производит продукты на фабриках
        Car audi = (Audi) carFactory.create("Audi");
        Car toyota = (Toyota) carFactory.create("Toyota");

        Tank t51 = (T51) tankFactory.create("T51");
        Tank t52 = (T52) tankFactory.create("T52");

        audi.drive();
        toyota.drive();

        t51.drive();
        t52.drive();
    }
}

//Factory Car

interface Car {
    void drive();
}

class Audi implements Car {

    @Override
    public void drive() {
        System.out.println("drive Audi");
    }
}

class Toyota implements Car {

    @Override
    public void drive() {
        System.out.println("drive Toyota");
    }
}

class CarFactory implements Factory {
    public Car create(String typeOfCar) {
        switch (typeOfCar) {
            case "Audi":
                return new Audi();
            case "Toyota":
                return new Toyota();
            default:
                return null;
        }
    }
}

//Factory Tank

interface Tank {
    void drive();
}

class T51 implements Tank {

    @Override
    public void drive() {
        System.out.println("drive T51");
    }
}

class T52 implements Tank {

    @Override
    public void drive() {
        System.out.println("drive T52");
    }
}

class TankFactory implements Factory {
    public Tank create(String typeOfTank) {
        switch (typeOfTank) {
            case "T51":
                return new T51();
            case "T52":
                return new T52();
            default:
                return null;
        }
    }
}

// Abstract Factory

interface Factory<T> {
    T create(String typeofProduct);
}

class AbstractFactory {
    public Factory createFactory(String typeOfFactory){
        switch (typeOfFactory) {
            case "Car" : return new CarFactory();
            case "Tank" : return new TankFactory();
            default : return  null;
        }
    }
}

