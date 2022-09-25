package com.cristianohahn.insurance.controller

import com.cristianohahn.insurance.model.RiskProfile
import com.cristianohahn.insurance.service.RiskProfileService
import com.cristianohahn.insurance.service.command.RiskProfileCalculateCommand
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RiskProfileController(
    val riskProfileService: RiskProfileService
) {

    @PostMapping("/risk_profile/calculate")
    fun calculate(@RequestBody request: RiskProfileCalculateCommand): ResponseEntity<RiskProfile> {
        return ResponseEntity.ok(riskProfileService.calculate(request))
    }
}