package com.stm.msystem.controller;

import com.stm.msystem.entity.Fee;
import com.stm.msystem.entity.FeeRequest;
import com.stm.msystem.service.FeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class FeeController {

    private FeeService feeService;

    public FeeController(FeeService feeService) {
        this.feeService = feeService;
    }

    @PostMapping("/fee")
    public ResponseEntity<Fee> saveFee(@RequestBody FeeRequest fee) throws Exception {
        return ResponseEntity.ok(feeService.createFee(fee));
    }

}
