O Chain of Responsibility é um padrão comportamental que permite passar requisições ao longo de uma cadeia de handlers (manipuladores). Cada handler decide se processa a requisição ou a passa para o próximo handler da cadeia.

Quando usar:
- Quando você tem diversos objetos que podem tratar uma requisição, mas o handler específico só é conhecido em tempo de execução
- Quando você quer passar uma requisição para vários objetos sem especificar explicitamente o receptor
- Quando a ordem de tratamento é importante

Exemplo prático - Sistema de aprovação de despesas corporativas onde diferentes níveis gerenciais podem aprovar valores diferentes:

```java
// Interface base para os handlers
public interface ExpenseHandler {
    void setNextHandler(ExpenseHandler handler);
    void handleExpense(ExpenseRequest request);
}

// Classe que representa a requisição
public record ExpenseRequest(String description, double amount) {}

// Handler abstrato base
public abstract class AbstractExpenseHandler implements ExpenseHandler {
    protected ExpenseHandler nextHandler;
    protected double approvalLimit;
    
    protected AbstractExpenseHandler(double approvalLimit) {
        this.approvalLimit = approvalLimit;
    }
    
    @Override
    public void setNextHandler(ExpenseHandler handler) {
        this.nextHandler = handler;
    }
    
    @Override
    public void handleExpense(ExpenseRequest request) {
        if (request.amount() <= approvalLimit) {
            approve(request);
        } else if (nextHandler != null) {
            nextHandler.handleExpense(request);
        } else {
            deny(request);
        }
    }
    
    protected abstract void approve(ExpenseRequest request);
    protected abstract void deny(ExpenseRequest request);
}

// Implementações concretas dos handlers
public class TeamLeader extends AbstractExpenseHandler {
    public TeamLeader() {
        super(1000.0); // Pode aprovar até $1000
    }
    
    @Override
    protected void approve(ExpenseRequest request) {
        System.out.println("Team Leader aprovou despesa de $" + request.amount() + 
                         " para " + request.description());
    }
    
    @Override
    protected void deny(ExpenseRequest request) {
        System.out.println("Despesa negada - necessita aprovação superior");
    }
}

public class ProjectManager extends AbstractExpenseHandler {
    public ProjectManager() {
        super(5000.0); // Pode aprovar até $5000
    }
    
    @Override
    protected void approve(ExpenseRequest request) {
        System.out.println("Project Manager aprovou despesa de $" + request.amount() + 
                         " para " + request.description());
    }
    
    @Override
    protected void deny(ExpenseRequest request) {
        System.out.println("Despesa negada - necessita aprovação superior");
    }
}

public class Director extends AbstractExpenseHandler {
    public Director() {
        super(10000.0); // Pode aprovar até $10000
    }
    
    @Override
    protected void approve(ExpenseRequest request) {
        System.out.println("Director aprovou despesa de $" + request.amount() + 
                         " para " + request.description());
    }
    
    @Override
    protected void deny(ExpenseRequest request) {
        System.out.println("Despesa negada - valor excede limite máximo de aprovação");
    }
}

// Exemplo de uso
public class Main {
    public static void main(String[] args) {
        // Criar a cadeia de responsabilidade
        TeamLeader teamLeader = new TeamLeader();
        ProjectManager projectManager = new ProjectManager();
        Director director = new Director();
        
        teamLeader.setNextHandler(projectManager);
        projectManager.setNextHandler(director);
        
        // Criar algumas requisições de despesa
        ExpenseRequest request1 = new ExpenseRequest("Material de escritório", 800.0);
        ExpenseRequest request2 = new ExpenseRequest("Equipamento de TI", 4500.0);
        ExpenseRequest request3 = new ExpenseRequest("Treinamento da equipe", 8000.0);
        ExpenseRequest request4 = new ExpenseRequest("Reforma do escritório", 15000.0);
        
        // Processar as requisições
        teamLeader.handleExpense(request1);    // Aprovado pelo Team Leader
        teamLeader.handleExpense(request2);    // Aprovado pelo Project Manager
        teamLeader.handleExpense(request3);    // Aprovado pelo Director
        teamLeader.handleExpense(request4);    // Negado - excede limite máximo
    }
}
```

Neste exemplo:

1. Temos uma cadeia de handlers para aprovar despesas
2. Cada handler tem um limite de aprovação diferente
3. Se um handler não pode aprovar, passa para o próximo
4. Se nenhum handler pode aprovar, a despesa é negada

A implementação segue os princípios:

1. Encapsulamento da lógica de tratamento em classes separadas
2. Encadeamento flexível dos handlers em tempo de execução
3. Tratamento transparente para o cliente - ele só precisa conhecer o primeiro handler
4. Facilidade para adicionar novos handlers sem modificar o código existente

Este padrão é útil em diversos cenários como:
- Sistemas de logging com diferentes níveis
- Middleware em frameworks web
- Sistemas de autenticação e autorização
- Filtros de processamento de dados
- Sistemas de validação em cascata

O Chain of Responsibility ajuda a desacoplar o código e torna o sistema mais flexível para mudanças, permitindo alterar a ordem dos handlers ou adicionar novos handlers sem impactar o código existente.