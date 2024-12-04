package com.lhjundi.singleton.refactoring_guru.non_thread_safe;


import static java.util.FormatProcessor.FMT;

public class DemoSingleThread {
    void main(){
        System.out.println(FMT."""
                                If you see the same value, then singleton was reused (yay!)
                                If you see diferente values, then 2 singletons were created (booo!)
                                Result: \n
                        """);
        Singleton singleton = Singleton.getInstance("FOO");
        Singleton anotherSingleton = Singleton.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);

    }

    static class ThreadFoo implements Runnable {

        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable{

        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
}
