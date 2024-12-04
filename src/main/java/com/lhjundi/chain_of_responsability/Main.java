package com.lhjundi.chain_of_responsability;

public class Main {
    void main(){

        //Criar a cadeia de responsabilidade
        TeamLeader teamLeader = new TeamLeader();
        ProjectManager projectManager = new ProjectManager();
        Director director = new Director();

        teamLeader.setNextHandler(projectManager);
        projectManager.setNextHandler(director);

        // Criar algumas requisições de despesa
        ExpenseRequest request1 = new ExpenseRequest("Material de escritório", 800);
        ExpenseRequest request2 = new ExpenseRequest("Equipamento de TI", 4500.0);
        ExpenseRequest request3 = new ExpenseRequest("Treinamento da equipe", 8000.0);
        ExpenseRequest request4 = new ExpenseRequest("Reforma do escritório", 15000.0);

        // Processar as requisições
        teamLeader.handleExpense(request1);     // Aprovado pelo Team Leader
        teamLeader.handleExpense(request2);     // Aprovado pelo Project Manager
        teamLeader.handleExpense(request3);     // Aprovado pelo Director
        teamLeader.handleExpense(request4);     // Negado - excede limite máximo

    }
}
