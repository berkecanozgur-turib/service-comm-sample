package org.comm.sample.config.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.comm.sample.dto.SampleRequest;
import org.comm.sample.dto.SampleResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "internal", description = "Internal schema registration - do not use")
@RestController
class SchemaRegistrationController {

    @PostMapping("/internal/schema/sample")
    public SampleResponse configure(@RequestBody SampleRequest req) { return null; }
}