package com.knoldus.RESTful.web.service.with.Spring.Webflux.entity;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private UUID id;
    private String title;
    private String content;
}

