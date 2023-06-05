package com.cjt.apigateway.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiRouteInfo {

    private String routeId;
    private String pathPattern;
    private String targetUri;

    // Getters and setters
}

