# Padrão Singleton em Java

## Descrição
O padrão Singleton garante que uma classe tenha apenas uma instância e fornece um ponto de acesso global a ela. É especialmente útil para gerenciar recursos compartilhados ou estados globais da aplicação.

## Casos de Uso
Use o Singleton quando precisar:
- Gerenciar um recurso compartilhado
- Controlar acesso concorrente a recursos
- Manter estado global na aplicação de forma controlada

## Exemplos Comuns de Uso
- Gerenciadores de conexão com banco de dados
- Sistemas de cache
- Gerenciadores de logs
- Pools de recursos (threads, conexões)
- Spoolers de impressão
- Configurações da aplicação

## Cuidados na Utilização
O padrão deve ser usado com moderação devido a:
1. Dificuldade em testes unitários por manter estado global
2. Necessidade de cuidados especiais com thread safety
3. Possível acoplamento forte entre classes
4. Risco de violar o princípio da responsabilidade única

## Implementações

### 1. Singleton Básico (não thread-safe)
```java
public class BasicSingleton {
    private static BasicSingleton instance;
    
    private BasicSingleton() {}
    
    public static BasicSingleton getInstance() {
        if (instance == null) {
            instance = new BasicSingleton();
        }
        return instance;
    }
}
```

### 2. Thread-Safe com Sincronização
```java
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton() {}
    
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
```

### 3. Inicialização Estática (thread-safe)
```java
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    
    private EagerSingleton() {}
    
    public static EagerSingleton getInstance() {
        return instance;
    }
}
```

### 4. Double-Checked Locking (otimizado para multi-thread)
```java
public class OptimizedSingleton {
    private static volatile OptimizedSingleton instance;
    
    private OptimizedSingleton() {}
    
    public static OptimizedSingleton getInstance() {
        OptimizedSingleton result = instance;
        if (result == null) {
            synchronized (OptimizedSingleton.class) {
                result = instance;
                if (result == null) {
                    instance = result = new OptimizedSingleton();
                }
            }
        }
        return result;
    }
}
```

### 5. Usando Enum (mais seguro)
```java
public enum EnumSingleton {
    INSTANCE;
    
    private Map<String, String> configurations = new HashMap<>();
    
    public void setConfig(String key, String value) {
        configurations.put(key, value);
    }
    
    public String getConfig(String key) {
        return configurations.get(key);
    }
}
```

## Passos para Implementação
1. Criar campo estático privado para armazenar a instância
2. Tornar o construtor privado
3. Criar método estático público para retornar a instância
4. Implementar sincronização se necessário (ambiente multi-thread)

## Considerações Adicionais
- Use implementação básica para aplicações single-thread
- Evite inicialização estática se precisar de lazy loading
- Use Double-Checked Locking ou Holder Class para melhor performance multi-thread
- Considere fazer a classe final
- Implemente Serializable se necessário
- Sobrescreva o método clone() para prevenir clonagem
- Considere usar enum como alternativa mais segura