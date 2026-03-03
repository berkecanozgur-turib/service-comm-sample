package org.comm.sample.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Sample response with nested structure")
public record SampleResponse(
    @Schema(description = "Sample ID", example = "1") Long id,
    @Schema(description = "Sample code", example = "SMP001") String code,
    @Schema(description = "Sample title", example = "Sample Title") String title,
    @Schema(description = "Sample details") SampleDetails details,
    @Schema(description = "Sample metadata") SampleMetadata metadata) {

  @Schema(description = "Sample details information")
  public record SampleDetails(
      @Schema(description = "Quantity", example = "100") Integer quantity,
      @Schema(description = "Price", example = "99.99") BigDecimal price,
      @Schema(description = "Total amount", example = "9999.00") BigDecimal totalAmount,
      @Schema(description = "Category", example = "ELECTRONICS") SampleCategory category,
      @Schema(description = "Active status", example = "true") Boolean active,
      @Schema(description = "Start date", example = "2026-03-01") LocalDate startDate) {}

  @Schema(description = "Sample metadata information")
  public record SampleMetadata(
      @Schema(description = "Tags list", example = "[\"tag1\", \"tag2\"]") List<String> tags,
      @Schema(description = "Creation timestamp", example = "2026-03-03T10:30:00")
          LocalDateTime createdAt,
      @Schema(description = "Last update timestamp", example = "2026-03-03T10:30:00")
          LocalDateTime updatedAt,
      @Schema(description = "Created by user", example = "admin") String createdBy) {}
}
