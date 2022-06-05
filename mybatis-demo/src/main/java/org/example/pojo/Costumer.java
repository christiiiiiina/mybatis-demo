package org.example.pojo;

import java.util.List;

/**
 * @author Administrator
 */
public class Costumer {

    private Integer id;

    private String name;

    private Integer age;

    private List<Orders> ordersList;

    public Costumer() {
    }

    public Costumer(Integer id, String name, Integer age, List<Orders> ordersList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ordersList = ordersList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ordersList=" + ordersList +
                '}';
    }
}
