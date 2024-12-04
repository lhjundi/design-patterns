package com.lhjundi.factory_method.classes;

import com.lhjundi.factory_method.classes.creator.CSVReportFactory;
import com.lhjundi.factory_method.classes.creator.MarkdownReportFactory;
import com.lhjundi.factory_method.classes.creator.ReportFactory;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public class Principal {
    void main() throws IOException{
        List<Reportable> content = List.of(
                new Header("Name", "Code", "Day", "Start Time", "End Time"),
                new Course("Object-Oriented Programming", "PROO", DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(11, 30)),
                new Course("Object-Oriented Design", "APOO", DayOfWeek.WEDNESDAY, LocalTime.of(8, 0), LocalTime.of(9, 40)),
                new Course("Software Testing", "VVTS", DayOfWeek.WEDNESDAY, LocalTime.of(9, 50), LocalTime.of(11, 30))
        );

        ReportFactory csvReport = new CSVReportFactory();
        csvReport.export(content, "report.csv");

        ReportFactory markdownReport = new MarkdownReportFactory();
        markdownReport.export(content, "report.md");
    }
}
