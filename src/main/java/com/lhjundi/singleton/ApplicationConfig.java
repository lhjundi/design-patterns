package com.lhjundi.singleton;

import java.util.HashMap;
import java.util.Map;

public class ApplicationConfig {
    private static ApplicationConfig instance;
    private final Map<String, String> configurations;

    //Construtor privado impede a criação ezterna de instâncias
    private ApplicationConfig(){
        configurations = new HashMap<>();
        loadDefaultConfigurations();
    }

    //Método estático para obter a única instância (thread-safe com lazy initialization)
    public static synchronized ApplicationConfig getInstance(){
        if (instance == null){
            instance = new ApplicationConfig();
        }
        return instance;
    }

    private void loadDefaultConfigurations() {
        configurations.put("database.url", "jdbc:mysql://localhot:3306/myapp");
        configurations.put("database.username", "admin");
        configurations.put("app.name", "MyApplication");
        configurations.put("app.version", "1.0.0");
    }

    public String getConfig(String key){
        return configurations.get(key);
    }

    public void setConfig(String key, String value){
        configurations.put(key, value);
    }
}
