package com.lhjundi.factory_method.classes;

public record Header(String... columns) implements Reportable {
    @Override
    public String[] toReport() {
        return columns;
    }
}
