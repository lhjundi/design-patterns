package com.lhjundi.singleton.head_first;

import com.lhjundi.singleton.refactoring_guru.thread_safe.Singleton;

public class ChocolateBoiler {

    private volatile static ChocolateBoiler uniqueInstance;

    private boolean empty;
    private boolean boiled;

    private ChocolateBoiler(){ //initialized only when empty
        empty = true;
        boiled = false;
    }

    public static ChocolateBoiler getUniqueInstance(){
        if (uniqueInstance == null){
            synchronized (Singleton.class){
                if (uniqueInstance == null)
                    uniqueInstance = new ChocolateBoiler();
            }
        }
        return uniqueInstance;
    }

    public void fill(){
        if (isEmpty()){
            empty = false;
            boiled = false;
        }
    }

    public void drain(){
        if (!isEmpty() && isBoiled())
            empty = true;
    }

    public void boil(){
        if (!isEmpty() && !isBoiled())
            boiled = true;
    }

    public boolean isEmpty(){
        return empty;
    }


    public boolean isBoiled(){
        return boiled;
    }
}
