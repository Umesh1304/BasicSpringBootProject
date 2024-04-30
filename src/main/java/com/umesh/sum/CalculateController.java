package com.umesh.sum;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {

    @PostMapping("/calculate")
    public ResponseEntity<String> calculate(@RequestBody CalculationRequest request) {
        int result;
        switch (request.getOperation()) {
            case "add":
                result = request.getNum1() + request.getNum2();
                break;
            case "sub":
                result = request.getNum1() - request.getNum2();
                break;
            case "mult":
                result = request.getNum1() * request.getNum2();
                break;
            case "divi":
                if (request.getNum2() == 0) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot divide by zero");
                }
                result = request.getNum1() / request.getNum2();
                break;
            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid operation");
        }
        return ResponseEntity.ok("Result: " + result);
    }
}
