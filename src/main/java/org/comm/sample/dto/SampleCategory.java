package org.comm.sample.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Sample category enumeration")
public enum SampleCategory {
  ELECTRONICS,
  CLOTHING,
  FOOD,
  BOOKS,
  SPORTS,
  OTHER
}
