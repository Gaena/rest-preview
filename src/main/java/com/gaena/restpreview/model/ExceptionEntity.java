package com.gaena.restpreview.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionEntity {

    private int code;
    private String description;
}
