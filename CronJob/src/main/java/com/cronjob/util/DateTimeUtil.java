package com.cronjob.util;

import org.joda.time.Interval;
import org.joda.time.Period;

import java.util.Date;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/09/30 10:08 PM
 * $Log: DateTimeUtil.java
 */
public class DateTimeUtil {

  public static String getDifference(Date startDate, Date endDate) {

    final Interval interval = new Interval(startDate.getTime(), endDate.getTime());
    final Period period = interval.toPeriod();

    return period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days, " +
        period.getHours() + " hours, " + period.getMinutes() + " minutes, " + period.getSeconds() + " seconds.";

  }


}
