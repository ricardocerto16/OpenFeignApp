package com.example.feignapp.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.apache.logging.log4j.message.AsynchronouslyFormattable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Photo {

    private Integer albumId;
    private Integer id;
    private String title;
    private String url;
    private String thumbnailUrl;


}
