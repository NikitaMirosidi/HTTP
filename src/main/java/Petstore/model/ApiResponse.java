package Petstore.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {
    private int code;
    private String type;
    private String message;
}