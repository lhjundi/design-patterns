package com.lhjundi.factory_method.classes.creator;

import com.lhjundi.factory_method.classes.products.ReportFormatter;
import com.lhjundi.factory_method.classes.Reportable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class ReportFactory {

    public <T extends Reportable> void export(List<T> data, String destination) throws IOException{
        ReportFormatter formatter = createFormatter(); //Factory method call
        String output = formatter.format(data);
        File file = new File(destination);
        try(FileWriter writer = new FileWriter(file)){
            writer.write(output);
        }
    }
    protected abstract ReportFormatter createFormatter(); // Factory method
}
