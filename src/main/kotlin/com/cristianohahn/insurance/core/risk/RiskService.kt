package com.cristianohahn.insurance.core.risk

import com.cristianohahn.insurance.core.risk.model.RiskCalculateResult
import com.cristianohahn.insurance.core.risk.calculator.RiskAutoCalculator
import com.cristianohahn.insurance.core.risk.calculator.RiskDisabilityCalculator
import com.cristianohahn.insurance.core.risk.calculator.RiskHomeCalculator
import com.cristianohahn.insurance.core.risk.calculator.RiskLifeCalculator
import com.cristianohahn.insurance.core.risk.command.RiskCalculateCommand
import org.springframework.stereotype.Service

@Service
class RiskService(
    private val riskAutoCalculator: RiskAutoCalculator,
    private val riskHomeCalculator: RiskHomeCalculator,
    private val riskLifeCalculator: RiskLifeCalculator,
    private val riskDisabilityCalculator: RiskDisabilityCalculator,
) {
    fun calculate(command: RiskCalculateCommand): RiskCalculateResult {
        return RiskCalculateResult(
            auto = riskAutoCalculator.calculateRiskProfile(command),
            home = riskHomeCalculator.calculateRiskProfile(command),
            life = riskLifeCalculator.calculateRiskProfile(command),
            disability = riskDisabilityCalculator.calculateRiskProfile(command)
        )
    }
}