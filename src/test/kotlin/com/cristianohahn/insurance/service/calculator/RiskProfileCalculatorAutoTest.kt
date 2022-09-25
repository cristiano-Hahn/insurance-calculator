package com.cristianohahn.insurance.service.calculator

import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorAutoTestFixture.aRiskProfileCalculateCommandWithVehicleWithLessThan5Years
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorAutoTestFixture.aRiskProfileCalculateCommandWithVehicleWithLessThan5YearsAndRisk
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorAutoTestFixture.aRiskProfileCalculateCommandWithVehicleWithMoreThan5Years
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorAutoTestFixture.aRiskProfileCalculateCommandWithoutAuto
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RiskProfileCalculatorAutoTest : DescribeSpec() {

    private val riskProfileCalculatorAuto = RiskProfileCalculatorAuto()

    init {
        describe("Calculate disability risk profile") {
            it("Should be 'ineligible' because doesn't have a vehicle") {
                val command = aRiskProfileCalculateCommandWithoutAuto()
                riskProfileCalculatorAuto.calculate(command) shouldBe "ineligible"
            }

            it("Should be 'economic' because have a car with more than 5 years") {
                val command = aRiskProfileCalculateCommandWithVehicleWithMoreThan5Years()
                riskProfileCalculatorAuto.calculate(command) shouldBe "economic"
            }

            it("Should be 'regular' because have a car with less than 5 years") {
                val command = aRiskProfileCalculateCommandWithVehicleWithLessThan5Years()
                riskProfileCalculatorAuto.calculate(command) shouldBe "regular"
            }

            it("Should be 'responsible' because have a car with less than 5 years and 2 points of risk") {
                val command = aRiskProfileCalculateCommandWithVehicleWithLessThan5YearsAndRisk()
                riskProfileCalculatorAuto.calculate(command) shouldBe "responsible"
            }
        }
    }
}