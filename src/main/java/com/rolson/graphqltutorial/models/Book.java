package com.rolson.graphqltutorial.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private final String id;
    private final String name;
    private final int pageCount;
    private final String authorId;
}
