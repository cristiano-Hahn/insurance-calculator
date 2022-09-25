package com.cristianohahn.insurance.controller

import com.cristianohahn.insurance.service.RiskService
import com.cristianohahn.insurance.service.command.RiskCalculateCommand
import com.cristianohahn.insurance.model.RiskProfile
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RiskController(
    @Autowired
    val riskService: RiskService
) {

    @PostMapping("/risks/calculate")
    fun calculate(@RequestBody request: RiskCalculateCommand): ResponseEntity<RiskProfile> {
        return ResponseEntity.ok(riskService.calculate(request))
    }
}