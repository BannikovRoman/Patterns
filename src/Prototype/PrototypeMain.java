package Prototype;

//Prototype - это объект, который умеет себя клонировать
public class PrototypeMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cache cache = new Cache();
        cache.setStudent(new Student());

        Student student = cache.getStudent();
    }
}

class Student implements Cloneable {
    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}

//класс, который хранит студентов
class Cache {
    private Student student;

    //возвращается не сам объект, а его клон
    public Student getStudent() throws CloneNotSupportedException {
        return student.clone();
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}