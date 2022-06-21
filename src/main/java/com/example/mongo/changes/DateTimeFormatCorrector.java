package com.example.mongo.changes;

import org.bson.Document;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Component
public class DateTimeFormatCorrector implements DocumentCorrector{

    private static final String NEW_FIELD_NAME = "dateCreated";
    private static final String OLD_FIELD_NAME = "profession";
    private static final String FIELD_DATE = "date";
    @Override
    public Document correct(Document document) {

        Long oldDate = document.getLong(FIELD_DATE);
        LocalDateTime time = LocalDateTime.ofEpochSecond(oldDate, 0, ZonedDateTime.now().getOffset());

        document.append(NEW_FIELD_NAME, time);
        document.remove(OLD_FIELD_NAME);
        return document;
    }
}
