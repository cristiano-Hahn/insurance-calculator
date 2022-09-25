package com.cristianohahn.insurance.service.exception

import com.cristianohahn.insurance.service.exception.RiskProfileInformationNotValidExceptionTestFixture.aRiskProfileCalculateCommandWithInvalidAge
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.string.shouldContain
import java.util.*
import javax.validation.Validation

class RiskProfileInformationNotValidExceptionTest : DescribeSpec() {

    init {
        describe("Risk profile information is not valid") {
            it("Should throw an exception with legible message") {
                val command = aRiskProfileCalculateCommandWithInvalidAge()
                Locale.setDefault(Locale.ENGLISH)
                val validationErrors = Validation.buildDefaultValidatorFactory()
                    .validator
                    .validate(command)

                val exception = shouldThrow<RiskProfileInformationNotValidException> {
                    throw RiskProfileInformationNotValidException(validationErrors)
                }

                exception.message shouldContain "Some violations was found in the request. The complete list are"
                exception.message shouldContain "age"
            }
        }
    }
}