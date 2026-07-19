package org.example.entity;

import java.time.LocalDate;

public class ServiceOrder {
    private Integer id;
    private Integer customerId;
    private LocalDate date;
    private String model;
    private String password;
    private String repair;
    private String description;
    private Double price;
    private Status status;

    public ServiceOrder(Integer customerId, LocalDate date, String description, String model, String password, Double price, String repair, Status status) {
        this.customerId = customerId;
        this.date = date;
        this.description = description;
        this.model = model;
        this.password = password;
        this.price = price;
        this.repair = repair;
        this.status = status;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public String getPassword() {
        return password;
    }

    public Double getPrice() {
        return price;
    }

    public String getRepair() {
        return repair;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ServiceOrder{" +
                "customerId=" + customerId +
                ", id=" + id +
                ", date=" + date +
                ", model='" + model + '\'' +
                ", password='" + password + '\'' +
                ", repair='" + repair + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
