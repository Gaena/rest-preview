package com.gaena.restpreview.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {

    private Long id;
    private LocalDateTime created;

}
