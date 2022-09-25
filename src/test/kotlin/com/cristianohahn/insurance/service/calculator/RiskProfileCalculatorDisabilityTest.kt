package com.cristianohahn.insurance.service.calculator

import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorDisabilityTestFixture.aDefaultRiskProfileCalculateCommand
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorDisabilityTestFixture.aRiskProfileCalculateCommandMarriedWithRisk
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorDisabilityTestFixture.aRiskProfileCalculateCommandMortgaged
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorDisabilityTestFixture.aRiskProfileCalculateCommandWithAge
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorDisabilityTestFixture.aRiskProfileCalculateCommandWithDependents
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorDisabilityTestFixture.aRiskProfileCalculateCommandWithDependentsMortgagedAndRisk
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorDisabilityTestFixture.aRiskProfileCalculateCommandWithIncome
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RiskProfileCalculatorDisabilityTest : DescribeSpec() {

    private val riskProfileCalculatorLife = RiskProfileCalculatorDisability()

    init {
        describe("Calculate disability risk profile") {
            it("Should be 'ineligible' because age is more or equal than 60") {
                val command = aRiskProfileCalculateCommandWithAge(60)
                riskProfileCalculatorLife.calculate(command) shouldBe "ineligible"
            }

            it("Should be 'ineligible' because income is 0") {
                val command = aRiskProfileCalculateCommandWithIncome(0)
                riskProfileCalculatorLife.calculate(command) shouldBe "ineligible"
            }

            it("Should be 'economic' because doesn't have any dependent, isn't married and haven't a mortgaged house") {
                val command = aDefaultRiskProfileCalculateCommand()
                riskProfileCalculatorLife.calculate(command) shouldBe "economic"
            }

            it("Should be 'regular' because have dependents") {
                val command = aRiskProfileCalculateCommandWithDependents()
                riskProfileCalculatorLife.calculate(command) shouldBe "regular"
            }

            it("Should be 'economic' because is married despite have a risk") {
                val command = aRiskProfileCalculateCommandMarriedWithRisk()
                riskProfileCalculatorLife.calculate(command) shouldBe "economic"
            }

            it("Should be 'regular' because have a mortgaged house") {
                val command = aRiskProfileCalculateCommandMortgaged()
                riskProfileCalculatorLife.calculate(command) shouldBe "regular"
            }

            it("Should be 'responsible' because have a dependent, have a mortgaged house and have a risk") {
                val command = aRiskProfileCalculateCommandWithDependentsMortgagedAndRisk()
                riskProfileCalculatorLife.calculate(command) shouldBe "responsible"
            }
        }
    }
}