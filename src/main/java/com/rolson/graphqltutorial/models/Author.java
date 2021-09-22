package com.rolson.graphqltutorial.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Author {
    private final String id;
    private final String firstName;
    private final String lastName;
}
