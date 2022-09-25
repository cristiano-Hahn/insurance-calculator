package com.cristianohahn.insurance.core.risk

import com.cristianohahn.insurance.core.risk.calculator.RiskAutoCalculator
import com.cristianohahn.insurance.core.risk.calculator.RiskDisabilityCalculator
import com.cristianohahn.insurance.core.risk.calculator.RiskHomeCalculator
import com.cristianohahn.insurance.core.risk.calculator.RiskLifeCalculator
import com.cristianohahn.insurance.core.risk.command.RiskCalculateCommand
import com.cristianohahn.insurance.core.risk.exception.CalculateRiskInformationNotValidException
import com.cristianohahn.insurance.core.risk.model.RiskCalculateResult
import org.springframework.stereotype.Service
import java.util.*
import javax.validation.Validation


@Service
class RiskService(
    private val riskAutoCalculator: RiskAutoCalculator,
    private val riskHomeCalculator: RiskHomeCalculator,
    private val riskLifeCalculator: RiskLifeCalculator,
    private val riskDisabilityCalculator: RiskDisabilityCalculator,
) {
    fun calculate(command: RiskCalculateCommand): RiskCalculateResult {
        validateInformation(command)
        return RiskCalculateResult(
            auto = riskAutoCalculator.calculateRiskProfile(command),
            home = riskHomeCalculator.calculateRiskProfile(command),
            life = riskLifeCalculator.calculateRiskProfile(command),
            disability = riskDisabilityCalculator.calculateRiskProfile(command)
        )
    }

    private fun validateInformation(command: RiskCalculateCommand) {
        Locale.setDefault(Locale.ENGLISH)
        val validationErrors = Validation.buildDefaultValidatorFactory()
            .validator
            .validate(command)

        if (validationErrors.isNotEmpty()) {
            throw CalculateRiskInformationNotValidException(validationErrors)
        }
    }
}