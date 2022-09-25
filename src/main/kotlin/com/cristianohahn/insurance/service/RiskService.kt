package com.cristianohahn.insurance.service

import com.cristianohahn.insurance.service.calculator.RiskCalculatorAuto
import com.cristianohahn.insurance.service.calculator.RiskCalculatorDisability
import com.cristianohahn.insurance.service.calculator.RiskCalculatorHome
import com.cristianohahn.insurance.service.calculator.RiskCalculatorLife
import com.cristianohahn.insurance.service.command.RiskCalculateCommand
import com.cristianohahn.insurance.service.exception.CalculateRiskInformationNotValidException
import com.cristianohahn.insurance.model.RiskProfile
import org.springframework.stereotype.Service
import java.util.*
import javax.validation.Validation


@Service
class RiskService(
    private val riskCalculatorAuto: RiskCalculatorAuto,
    private val riskCalculatorHome: RiskCalculatorHome,
    private val riskCalculatorLife: RiskCalculatorLife,
    private val riskCalculatorDisability: RiskCalculatorDisability,
) {
    fun calculate(command: RiskCalculateCommand): RiskProfile {
        validateInformation(command)
        return RiskProfile(
            auto = riskCalculatorAuto.calculateRiskProfile(command),
            home = riskCalculatorHome.calculateRiskProfile(command),
            life = riskCalculatorLife.calculateRiskProfile(command),
            disability = riskCalculatorDisability.calculateRiskProfile(command)
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