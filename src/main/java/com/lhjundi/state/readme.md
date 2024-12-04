## O padrão State é útil quando:
1. O comportamento de um objeto precisa mudar baseado em seu estado interno
2. Você tem múltiplas condicionais que dependem do estado do objeto
3. As transições entre estados seguem regras específicas

Um exemplo clássico é uma máquina de vendas (vending machine) que tem diferentes comportamentos dependendo de seu estado atual.

```java
// Interface que define os comportamentos possíveis em qualquer estado
public interface VendingMachineState {
    void insertCoin(int amount);
    void selectProduct(String product);
    void dispenseProduct();
}

// Estado: Máquina vazia aguardando moedas
public class NoMoneyState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public NoMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        vendingMachine.addMoney(amount);
        vendingMachine.setState(new HasMoneyState(vendingMachine));
        System.out.println("Moeda inserida: $" + amount);
    }

    @Override
    public void selectProduct(String product) {
        System.out.println("Por favor, insira moedas primeiro");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Por favor, insira moedas primeiro");
    }
}

// Estado: Máquina com dinheiro aguardando seleção
public class HasMoneyState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        vendingMachine.addMoney(amount);
        System.out.println("Moeda adicional inserida: $" + amount);
    }

    @Override
    public void selectProduct(String product) {
        if (vendingMachine.getCurrentMoney() >= vendingMachine.getProductPrice(product)) {
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setState(new DispensingState(vendingMachine));
            System.out.println("Produto selecionado: " + product);
        } else {
            System.out.println("Dinheiro insuficiente para " + product);
        }
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Por favor, selecione um produto primeiro");
    }
}

// Estado: Máquina dispensando produto
public class DispensingState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("Aguarde, dispensando produto");
    }

    @Override
    public void selectProduct(String product) {
        System.out.println("Aguarde, dispensando produto");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Dispensando: " + vendingMachine.getSelectedProduct());
        vendingMachine.resetMoney();
        vendingMachine.setState(new NoMoneyState(vendingMachine));
    }
}

// A classe contexto que mantém o estado atual
public class VendingMachine {
    private VendingMachineState state;
    private int currentMoney;
    private String selectedProduct;
    private Map<String, Integer> prices;

    public VendingMachine() {
        this.state = new NoMoneyState(this);
        this.currentMoney = 0;
        this.prices = new HashMap<>();
        prices.put("Coca", 5);
        prices.put("Snack", 3);
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public void insertCoin(int amount) {
        state.insertCoin(amount);
    }

    public void selectProduct(String product) {
        state.selectProduct(product);
    }

    public void dispenseProduct() {
        state.dispenseProduct();
    }

    // Métodos auxiliares
    public void addMoney(int amount) {
        currentMoney += amount;
    }

    public void resetMoney() {
        currentMoney = 0;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public int getProductPrice(String product) {
        return prices.getOrDefault(product, 0);
    }

    public String getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(String product) {
        this.selectedProduct = product;
    }
}
```

Exemplo de uso:

```java
public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        
        // Tentativa de selecionar sem dinheiro
        machine.selectProduct("Coca"); // Saída: Por favor, insira moedas primeiro
        
        // Inserindo dinheiro
        machine.insertCoin(3); // Saída: Moeda inserida: $3
        
        // Tentativa com dinheiro insuficiente
        machine.selectProduct("Coca"); // Saída: Dinheiro insuficiente para Coca
        
        // Inserindo mais dinheiro
        machine.insertCoin(2); // Saída: Moeda adicional inserida: $2
        
        // Selecionando produto com dinheiro suficiente
        machine.selectProduct("Coca"); // Saída: Produto selecionado: Coca
        
        // Dispensando produto
        machine.dispenseProduct(); // Saída: Dispensando: Coca
        
        // Máquina volta ao estado inicial
        machine.selectProduct("Snack"); // Saída: Por favor, insira moedas primeiro
    }
}
```

Este exemplo demonstra como o padrão State:
1. Elimina condicionais complexas que dependeriam do estado
2. Encapsula cada comportamento em classes separadas
3. Facilita a adição de novos estados
4. Torna as transições de estado explícitas e controladas
5. Mantém o código organizado e mais fácil de manter

O padrão é especialmente útil quando você tem um objeto que precisa se comportar de maneira diferente dependendo de seu estado interno, e o número de estados é conhecido e finito.