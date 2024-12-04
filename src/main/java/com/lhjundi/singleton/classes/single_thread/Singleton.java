package com.lhjundi.singleton.classes.single_thread;

public class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}
