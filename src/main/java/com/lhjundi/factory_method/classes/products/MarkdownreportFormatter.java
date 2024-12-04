package com.lhjundi.factory_method.classes.products;

import com.lhjundi.factory_method.classes.Reportable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MarkdownreportFormatter implements ReportFormatter {
    @Override
    public <T extends Reportable> String format(List<T> content) {
        if (content == null || content.isEmpty()) return "";

        String[] firstElement = content.getFirst().toReport();
        String headerRow = generateRow(firstElement);
        String separatorRow = generateSeparatorRow(firstElement.length);
        String dataRows = content.stream().skip(1)
                .map(Reportable::toReport)
                .map(MarkdownreportFormatter::generateRow)
                .collect(Collectors.joining("\n"));
        return String.join("\n", headerRow, separatorRow, dataRows);
    }

    private static String generateRow(String[] row){
        return STR." | \{String.join(" | ", row)} | ";
    }

    private static String generateSeparatorRow(int columnCount){
        return STR." | \{IntStream
                .range(0, columnCount)
                .mapToObj(u -> "---")
                .collect(Collectors.joining(" | "))} | ";
    }
}
