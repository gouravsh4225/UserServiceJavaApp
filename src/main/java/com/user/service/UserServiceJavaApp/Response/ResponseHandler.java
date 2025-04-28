package com.user.service.UserServiceJavaApp.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(boolean success, Object data, HttpStatus status) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("success", success);
        map.put("timestamp", LocalDateTime.now());
        map.put(success ? "data" : "error", data);

        return new ResponseEntity<>(map, status);
    }
}
