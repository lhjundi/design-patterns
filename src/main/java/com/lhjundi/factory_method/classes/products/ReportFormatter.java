package com.lhjundi.factory_method.classes.products;

import com.lhjundi.factory_method.classes.Reportable;

import java.util.List;

public interface ReportFormatter {
    //implementação da abstração da classe produto, ou seja, o formatador de relatorios
    <T extends Reportable> String format(List<T> content);
}
