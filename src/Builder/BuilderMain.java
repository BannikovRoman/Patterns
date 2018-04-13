package Builder;

public class BuilderMain {
    public static void main(String[] args) {
        SportCar sportCar = new SportCar.Builder("Audi").setColor("green").setSpeed(250).build();
        System.out.println(sportCar.toString());
    }
}

class SportCar {
    private String name;
    private String color;
    private int speed;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "SportCar{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", speed=" + speed +
                '}';
    }

    private SportCar(Builder builder) {
        this.name = builder.name;
        this.color = builder.color;
        this.speed = builder.speed;
    }

    //если у объекта множество переменных и чтобы не создавать огромное количество
    //конструкторов, то будем использовать Builder
    static class Builder {
        private String name;
        private String color;
        private int speed;

        //в Builder необходим конструктор только для обязательных полей
        //в моем случае это поле name
        public Builder(String name) {
            this.name = name;
        }

        //setter необходимы для остальных полей
        //они должны возвращать Builder
        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setSpeed(int speed) {
            this.speed = speed;
            return this;
        }

        //метод, который создает SportCar
        public SportCar build() {
            return new SportCar(this);
        }
    }
}