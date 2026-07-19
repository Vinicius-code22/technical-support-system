package org.example.entity;

public class Customer {
    private Integer id;
    private String name;
    private String phone;
    private String cpf;

    public Customer(String cpf, String name, String phone) {
        this.cpf = cpf;
        this.name = name;
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
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

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cpf='" + cpf + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
