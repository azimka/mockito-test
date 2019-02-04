package com.azimka.chapter2;

import java.util.Date;

public class ReportGeneratorService {
    private IReportGenerator reportGenerator;

    public void generateReport(Date startDate, Date finishDate, byte[] content) {
        ReportEntity reportEntity = new ReportEntity();

        reportEntity.setStartDate(startDate);
        reportEntity.setEndDate(finishDate);
        reportEntity.setContent(content);

        reportGenerator.generateReport(reportEntity);
    }
}
