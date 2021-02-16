package com.lambdaschool.orders.models;

//ORDNUM primary key, not null Long
//ORDAMOUNT double
//ADVANCEAMOUNT double
//CUSTCODE Long foreign key (one customer to many orders) not null
//ORDERDESCRIPTION String

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    @Column (nullable = false, unique = true)
    private long ordnum;
    private double ordamount;
    private double advanceamount;
    @ManyToOne
    @JoinColumn (name = "custcode", nullable=false)
    private Customer customer;

    private String orderdescription;
    @ManyToMany()
    @JoinTable(name = "orderspayment", joinColumns = @JoinColumn(name = "ordnum"), inverseJoinColumns = @JoinColumn(name = "paymentid"))
    private Set<Payment> payments = new HashSet<>();
    public Order() {

    }
    public Order(double ordamount, double advanceamount, long custcode, String orderdescription){
    this.ordamount = ordamount;
    this.advanceamount = advanceamount;
    this.customer = customer;
    this.orderdescription = orderdescription;
    }

    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }


    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public Set<Payment> getPayments(){
        return payments;
    }
    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }
}
