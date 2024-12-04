package com.lhjundi.factory_method.classes.creator;

import com.lhjundi.factory_method.classes.products.MarkdownreportFormatter;
import com.lhjundi.factory_method.classes.products.ReportFormatter;

public class MarkdownReportFactory extends ReportFactory{
    @Override
    protected ReportFormatter createFormatter() {
        return new MarkdownreportFormatter();
    }
}
