package com.beauty1nside.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
  
  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  
  /**
   * 시작일을 LocalDateTime으로 변환하여 "yyyy-MM-dd HH:mm:ss" 형식으로 반환
   */
  public static String formatStartOfDay(String dateStr) {
    if (dateStr == null || dateStr.isEmpty()) {
      return null;
    }
    LocalDate startDate = LocalDate.parse(dateStr);
    LocalDateTime startOfDay = startDate.atStartOfDay();
    return startOfDay.format(FORMATTER);
  }
  
  /**
   * 종료일을 LocalDateTime으로 변환하여 "yyyy-MM-dd HH:mm:ss" 형식으로 반환
   */
  public static String formatEndOfDay(String dateStr) {
    if (dateStr == null || dateStr.isEmpty()) {
      return null;
    }
    LocalDate endDate = LocalDate.parse(dateStr);
    LocalDateTime endOfDay = endDate.atTime(23, 59, 59);
    return endOfDay.format(FORMATTER);
  }
}
