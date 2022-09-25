package com.cristianohahn.insurance.service

import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorAuto
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorDisability
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorHome
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorLife
import com.cristianohahn.insurance.service.command.RiskProfileCalculateCommand
import com.cristianohahn.insurance.service.exception.RiskProfileInformationNotValidException
import com.cristianohahn.insurance.model.RiskProfile
import org.springframework.stereotype.Service
import java.util.*
import javax.validation.Validation


@Service
class RiskProfileService(
    private val riskProfileCalculatorAuto: RiskProfileCalculatorAuto,
    private val riskProfileCalculatorHome: RiskProfileCalculatorHome,
    private val riskProfileCalculatorLife: RiskProfileCalculatorLife,
    private val riskProfileCalculatorDisability: RiskProfileCalculatorDisability,
) {

    fun calculate(command: RiskProfileCalculateCommand): RiskProfile {
        validateInformation(command)
        return RiskProfile(
            auto = riskProfileCalculatorAuto.calculate(command),
            home = riskProfileCalculatorHome.calculate(command),
            life = riskProfileCalculatorLife.calculate(command),
            disability = riskProfileCalculatorDisability.calculate(command)
        )
    }

    private fun validateInformation(command: RiskProfileCalculateCommand) {
        Locale.setDefault(Locale.ENGLISH)
        val validationErrors = Validation.buildDefaultValidatorFactory()
            .validator
            .validate(command)

        if (validationErrors.isNotEmpty()) {
            throw RiskProfileInformationNotValidException(validationErrors)
        }
    }
}