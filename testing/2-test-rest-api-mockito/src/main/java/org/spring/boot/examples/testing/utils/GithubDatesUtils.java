package org.spring.boot.examples.testing.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class GithubDatesUtils {

    public static final DateTimeFormatter GITHUB_DATE_FORMAT = DateTimeFormatter.ofPattern("yyy-MM-dd'T'hh:mm:ss'Z'");

    /**
     * dates that we will receive from github are on the UTC zone id so we will transform them to our local zone id (system zone id)
     *
     * @param dateTime
     * @return
     */
    public static LocalDateTime getLocalDateTime(LocalDateTime dateTime) {

        return dateTime
                .atZone(ZoneOffset.UTC)
                .withZoneSameInstant(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}
