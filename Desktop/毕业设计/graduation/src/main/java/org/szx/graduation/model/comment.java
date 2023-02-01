package org.szx.graduation.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class comment {
    private long id;
    private String content;
    private long userId;
    private comment children;
    private String scenicspotId;
    private LocalDateTime gmtCreated;
}
