package biz.meziant.controller.model;

import biz.meziant.model.Source;

import java.time.LocalDateTime;

/**
 * Created by ronan on 17/12/16.
 */
public class SesamResponse {
    private Source from;

    private String dateTime;

    public Source getFrom() {
        return from;
    }

    public void setFrom(Source from) {
        this.from = from;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
