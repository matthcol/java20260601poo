package org.example.demo;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DemoTemporal {

    @Test
    void demoDate(){
        // Java 1.0
        Date d = new Date();
        System.out.println(d); // Mon Jun 01 15:56:45 CEST 2026
        System.out.println(d.getYear()); // deprecated : use calendar or toolbox
    }

    @Test
    void demoCalendar(){
        // Java 1.1
        Calendar d = Calendar.getInstance();
        System.out.println(d);
        System.out.println("year: " + d.get(Calendar.YEAR));
        System.out.println("month: " + (d.get(Calendar.MONTH) + 1));

        Date d0 = new Date();
        d.setTime(d0);
        System.out.println("year: " + d.get(Calendar.YEAR));
    }

    @Test
    void demoJava8(){
        // ISO 8601 : package java.time
        LocalDate d1 = LocalDate.of(2024, 2, 29);
        LocalDate d2 = LocalDate.now();
        LocalDateTime dt1 = LocalDateTime.now();
        LocalTime t1 = LocalTime.now();
        ZonedDateTime zdt1 = ZonedDateTime.now();
        ZonedDateTime zdt2 = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d2.getMonthValue());
        System.out.println(dt1);
        System.out.println(t1);
        System.out.println(zdt1);
        System.out.println(zdt2);

        List<String> tzNames = List.of(
                "Europe/Paris",
                "Asia/Tokyo",
                "Pacific/Auckland",
                "America/Los_Angeles",
                "Pacific/Honolulu",
                "Pacific/Marquesas",
                "Pacific/Pago_Pago",
                "Pacific/Apia"
        );
        for (String tzName: tzNames){
            ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of(tzName));
            System.out.println(MessageFormat.format(
                    "{0} : {1}",
                    tzName,
                    zdt
            ));
        }
    }

    @Test
    void demoFormatJava8(){
        LocalDateTime dt = LocalDateTime.of(2028, 2, 29, 12, 30);
        System.out.println(dt); // ISO Format
        System.out.println(dt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println(dt.format(DateTimeFormatter.ofPattern("eeee dd MMMM yyyy HH:mm:ss")));

        Locale locale = Locale.getDefault();
        System.out.println(locale); // fr_FR
        Locale.setDefault(Locale.of("ja", "JP"));
        System.out.println(dt.format(DateTimeFormatter.ofPattern("eeee dd MMMM yyyy HH:mm:ss")));
    }

    @Test
    void demoFormatCalendar(){
        Calendar d = Calendar.getInstance();
        System.out.println(d);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(formatter.format(d.getTime()));
    }
}
