package com.azimka.chapter2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class ReportGeneratorTest {

    @Mock
    private IReportGenerator reportGenerator;

    @Captor
    private ArgumentCaptor<ReportEntity> reportEntityArgumentCaptor;

    @InjectMocks
    private ReportGeneratorService reportGeneratorService;

    @Test
    public void testGeneratorService() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2012, 11, 12);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2013, 5, 7);

        String content = "Some content";

        reportGeneratorService.generateReport(startDate.getTime(), endDate.getTime(), content.getBytes());

        verify(reportGenerator).generateReport(reportEntityArgumentCaptor.capture());

        ReportEntity reportEntity = reportEntityArgumentCaptor.getValue();

        assertEquals(reportEntity.getStartDate().getMonth(), 11);
    }

}
