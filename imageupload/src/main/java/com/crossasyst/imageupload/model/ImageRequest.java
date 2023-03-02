package com.crossasyst.imageupload.model;

import lombok.Data;

import javax.persistence.Lob;

@Data
public class ImageRequest {

    private String name;

    private Long size;


    private byte[] data;
}
