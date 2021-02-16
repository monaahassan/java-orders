package com.lambdaschool.orders.models;


//PAYMENTID primary key, not null long
//TYPE String not null

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

@Entity
@GeneratedValue
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private long paymentid;
    @Column (nullable = false)
    private String type;
    @ManyToMany(mappedBy = "payments")
    private Set<Order> orders = new HashSet<>();

    public Payment() {

    }
    public Payment(String type) {
        this.type = type;
    }
    public long getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(long paymentid) {
        this.paymentid = paymentid;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }


}
