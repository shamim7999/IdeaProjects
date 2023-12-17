package com.springcore;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Pepsi implements InitializingBean, DisposableBean {
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        System.out.println("Setting Pepsi Parameters.");
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pepsi{" +
                "price=" + price +
                '}';
    }

    public void afterPropertiesSet() throws Exception {
        /// eta init() er kaj kore.. init() er logic ekhaneo boshate pari
        System.out.println("Taking Pepsi: init");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Throw the botttle: destroy");
    }
}
