package com.lhjundi.factory_method.classes.products;

import com.lhjundi.factory_method.classes.Reportable;

import java.util.List;
import java.util.stream.Collectors;

public class CSVReportFormatter implements ReportFormatter {
    @Override
    public <T extends Reportable> String format(List<T> content) {
        return content.stream()
                .map(Reportable::toReport)
                .map(row -> String.join(";", row))
                .collect(Collectors.joining("\n"));
    }
}
