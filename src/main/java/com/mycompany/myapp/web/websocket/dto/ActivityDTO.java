package com.mycompany.myapp.web.websocket.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

/**
 * DTO for storing a user's activity.
 */
@Setter
@Getter
public class ActivityDTO {

    private String sessionId;

    private String userLogin;

    private String ipAddress;

    private String page;

    private Instant time;

    // prettier-ignore
    @Override
    public String toString() {
        return "ActivityDTO{" +
            "sessionId='" + sessionId + '\'' +
            ", userLogin='" + userLogin + '\'' +
            ", ipAddress='" + ipAddress + '\'' +
            ", page='" + page + '\'' +
            ", time='" + time + '\'' +
            '}';
    }
}
