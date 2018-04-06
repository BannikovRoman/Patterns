package Factory;

public class FactoryMain {
    /*public static void main(String[] args) {
        Factory factory = new Factory();

        Audi audi = (Audi) factory.create("Audi");
        Toyota toyota = (Toyota) factory.create("Toyota");

        audi.drive();
        toyota.drive();
    }*/
}

/*
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

class Factory {
    public Car create(String typeOfCar){
        switch (typeOfCar) {
            case "Audi" : return new Audi();
            case "Toyota" : return new Toyota();
            default : return null;
        }
    }
}*/
