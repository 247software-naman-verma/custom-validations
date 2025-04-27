package com.example.custom_validations.dto;

import com.example.custom_validations.validation.ClassLevelAnnotation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ClassLevelAnnotation
public class Post {

    @JsonProperty("post_name")
    private String postName;

    private String description;

    private List<String> tags;

}
