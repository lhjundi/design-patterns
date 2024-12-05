package com.lhjundi.observer;

import java.util.ArrayList;
import java.util.List;

// Classe que representa um pedido (subject concreto)
public class Order implements OrderSubject{
    private String status;
    private final List<OrderObserver> observers = new ArrayList<>();

    public void setStatus(String status){
        this.status = status;
        notifyObservers();
    }

    @Override
    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (OrderObserver observer : observers){
            observer.update(this);
        }
    }

    public String getStatus(){
        return status;
    }
}
