package com.lhjundi.refactoring;

public class ToolItem extends DomainObject{
    private String serialNumber;
    private Tool tool;

    public Tool getTool(){
        return tool;
    }
}
