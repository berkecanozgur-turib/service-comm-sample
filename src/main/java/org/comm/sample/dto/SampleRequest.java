package org.comm.sample.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Schema(description = "Sample request with various parameter types")
public record SampleRequest(
    @Schema(
            description = "Sample code (unique identifier)",
            example = "SMP001",
            requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Sample code is required")
        @Size(max = 50, message = "Sample code must not exceed 50 characters")
        String code,
    @Schema(description = "Sample title", example = "Sample Title", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Title is required")
        @Size(max = 200, message = "Title must not exceed 200 characters")
        String title,
    @Schema(description = "Quantity value", example = "100", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Quantity is required")
        @Min(value = 1, message = "Quantity must be at least 1")
        @Max(value = 10000, message = "Quantity must not exceed 10000")
        Integer quantity,
    @Schema(description = "Price amount", example = "99.99", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Price is required")
        @DecimalMin(value = "0.01", message = "Price must be greater than 0")
        @Digits(integer = 10, fraction = 2, message = "Price must have max 10 integer and 2 decimal digits")
        BigDecimal price,
    @Schema(description = "Active status", example = "true", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Active status is required")
        Boolean active,
    @Schema(description = "Start date", example = "2026-03-01", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Start date is required")
        @FutureOrPresent(message = "Start date must be today or in the future")
        LocalDate startDate,
    @Schema(description = "Category", example = "ELECTRONICS", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Category is required")
        SampleCategory category,
    @Schema(description = "List of tags", example = "[\"tag1\", \"tag2\"]")
        @Size(max = 10, message = "Maximum 10 tags allowed")
        List<String> tags) {}
