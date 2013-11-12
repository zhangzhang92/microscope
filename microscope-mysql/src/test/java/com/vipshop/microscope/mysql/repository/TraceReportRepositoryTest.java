package com.vipshop.microscope.mysql.repository;

import org.testng.annotations.Test;

import com.vipshop.microscope.common.util.CalendarUtil;
import com.vipshop.microscope.mysql.domain.TraceReport;
import com.vipshop.microscope.mysql.factory.MySQLRepositorys;

public class TraceReportRepositoryTest {
	
	TraceReportRepository mySQLTemplate = MySQLRepositorys.TRACE_REPORT;
	
	@Test
	public void testCreate() {
		String sql = "CREATE TABLE t1(id int not null,name char(20))";
		mySQLTemplate.create(sql);
	}
	
	@Test
	public void testSave() {
		CalendarUtil calendarUtil = new CalendarUtil();
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					TraceReport traceReport = new TraceReport();
					traceReport.setId(TraceReport.makeId(calendarUtil, "example"));
					traceReport.setYear(calendarUtil.currentYear());
					traceReport.setMonth(calendarUtil.currentMonth());
					traceReport.setWeek(calendarUtil.currentWeek());
					traceReport.setDay(calendarUtil.currentDay() + j);
					traceReport.setHour(i + 1);
					traceReport.setType("Type-id" + j2);
					traceReport.setName("example-id-" + i);
					traceReport.setTotalCount(100);
					traceReport.setFailureCount(10);
					traceReport.setFailurePrecent(0.1f);
					traceReport.setMin(10);
					traceReport.setMax(100);
					traceReport.setAvg(12);
					traceReport.setTps(13);
					traceReport.setStartTime(System.currentTimeMillis());
					traceReport.setEndTime(System.currentTimeMillis() + 100000);
					mySQLTemplate.save(traceReport);
				}
			}
		}
	}
	
	@Test
	public void testfind() {
		System.out.println(mySQLTemplate.findTraceReport());;
	}
	
	@Test
	public void exist() {
		System.out.println(mySQLTemplate.exist("trace/queryconditon"));
	}
}