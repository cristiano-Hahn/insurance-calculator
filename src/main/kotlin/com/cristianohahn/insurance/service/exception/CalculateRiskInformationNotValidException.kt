package com.cristianohahn.insurance.service.exception

import com.cristianohahn.insurance.service.command.RiskCalculateCommand
import javax.validation.ConstraintViolation

class CalculateRiskInformationNotValidException(violations: Set<ConstraintViolation<RiskCalculateCommand>>) :
    RuntimeException("Some violations was found in the request. The complete list are: " +
            "${
                violations.map {
                    "The field ${it.propertyPath} ${it.message}"
                }
            }"
    ) {
}