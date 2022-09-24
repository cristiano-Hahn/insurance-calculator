package com.cristianohahn.insurance.adapters.router

import com.cristianohahn.insurance.core.risk.model.RiskCalculateResult
import com.cristianohahn.insurance.core.risk.RiskService
import com.cristianohahn.insurance.core.risk.command.RiskCalculateCommand
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
    fun calculate(@RequestBody request: RiskCalculateCommand): ResponseEntity<RiskCalculateResult> {
        return ResponseEntity.ok(riskService.calculate(request))
    }
}