//package com.cjt.apigateway.controller;
//
//import com.cjt.apigateway.model.ApiRouteInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/routes")
//public class DynamicRouteController {
//
//    @Autowired
//    private RouteLocatorBuilder routeLocatorBuilder;
//
//    @PostMapping
//    public ResponseEntity<String> registerRoute(@RequestBody ApiRouteInfo routeInfo) {
//        try {
//            RouteLocatorBuilder.Builder routesBuilder = routeLocatorBuilder.routes();
//
//            // Construct the route using the provided information
//            routesBuilder.route(routeInfo.getRouteId(), r ->
//                    r.path(routeInfo.getPathPattern())
//                            .uri(routeInfo.getTargetUri()));
//
//            // Refresh the route definition
//            DynamicRouteLocator dynamicRouteLocator = (DynamicRouteLocator) routeLocatorBuilder.build();
//            dynamicRouteLocator.refresh();
//
//            return ResponseEntity.ok("Route registered successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering route");
//        }
//    }
//}
