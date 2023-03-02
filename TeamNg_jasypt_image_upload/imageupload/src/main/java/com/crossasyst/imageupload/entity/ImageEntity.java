package com.crossasyst.imageupload.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "image")
@Getter
@Setter
public class ImageEntity {
    @Id
    @SequenceGenerator(name = "seq_image_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_image_id")
    private Long id;

    private String name;

    private Long size;

    @Lob
    private byte[] data;

}
