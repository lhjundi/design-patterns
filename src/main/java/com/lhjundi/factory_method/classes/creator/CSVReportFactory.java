package com.lhjundi.factory_method.classes.creator;

import com.lhjundi.factory_method.classes.products.CSVReportFormatter;
import com.lhjundi.factory_method.classes.products.ReportFormatter;

public class CSVReportFactory extends ReportFactory{
    @Override
    protected ReportFormatter createFormatter() {
        return new CSVReportFormatter();
    }
}
