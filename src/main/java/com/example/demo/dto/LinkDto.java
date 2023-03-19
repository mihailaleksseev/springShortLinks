package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkDto {

    @NotBlank
    @Schema(description = "Link param description")
    private String link;

}
