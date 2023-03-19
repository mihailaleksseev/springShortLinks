package com.example.demo.controller;

import com.example.demo.dto.LinkRequestDto;
import com.example.demo.dto.LinkResponseDto;
import com.example.demo.service.LinkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/link", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Link controller", description = "Link controller")
@RequiredArgsConstructor
public class LinkController {

    private final LinkService linkService;

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Short link generated successfully"),
        @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @Operation(summary = "Generate short url")
    @PostMapping
    public ResponseEntity<LinkResponseDto> create(@Valid @RequestBody LinkRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(
                linkService.generate(dto)
        );
    }

}
