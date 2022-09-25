package com.cristianohahn.insurance.service.exception

import com.cristianohahn.insurance.service.command.RiskProfileCalculateCommand
import javax.validation.ConstraintViolation

class RiskProfileInformationNotValidException(violations: Set<ConstraintViolation<RiskProfileCalculateCommand>>) :
    RuntimeException("Some violations was found in the request. The complete list are: " +
            "${
                violations.map {
                    "The field ${it.propertyPath} ${it.message}"
                }
            }"
    )