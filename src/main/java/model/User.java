package model;

public class User {
    private long id;
    private String name;
    private int age;
    private int money;

    public User(String name, int age, int money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public User(long id, String name, int age, int money) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public User(){}

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getMoney() {
        return money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
