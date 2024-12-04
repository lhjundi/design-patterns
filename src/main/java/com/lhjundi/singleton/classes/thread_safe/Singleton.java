package com.lhjundi.singleton.classes.thread_safe;

public class Singleton {
    private static Singleton instance; //private static self-reference

    private Singleton(){} // restricts the instace construction

    public static Singleton getInstance(){
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

    public void doSomething(){
        //some useful feature
    }
}
