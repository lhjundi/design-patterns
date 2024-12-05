package com.lhjundi.observer;

public interface OrderSubject {
    // Interface para o subject

    void attach(OrderObserver observer);
    void detach(OrderObserver observer);
    void notifyObservers();
}
