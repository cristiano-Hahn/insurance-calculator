package com.cristianohahn.insurance.service.calculator

import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorHomeTestFixture.aRiskProfileCalculateCommandWithMortgagedAndRisk
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorHomeTestFixture.aRiskProfileCalculateCommandWithMortgagedHouse
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorHomeTestFixture.aRiskProfileCalculateCommandWithOwnedHouse
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorHomeTestFixture.aRiskProfileCalculateCommandWithoutHouse
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RiskProfileCalculatorHomeTest : DescribeSpec() {

    private val riskProfileCalculatorHome = RiskProfileCalculatorHome()

    init {
        describe("Calculate disability risk profile") {
            it("Should be 'ineligible' because doesn't have a house") {
                val command = aRiskProfileCalculateCommandWithoutHouse()
                riskProfileCalculatorHome.calculate(command) shouldBe "ineligible"
            }

            it("Should be 'economic' because have a mortgaged house") {
                val command = aRiskProfileCalculateCommandWithMortgagedHouse()
                riskProfileCalculatorHome.calculate(command) shouldBe "regular"
            }

            it("Should be 'economic' because have an owned house") {
                val command = aRiskProfileCalculateCommandWithOwnedHouse()
                riskProfileCalculatorHome.calculate(command) shouldBe "economic"
            }

            it("Should be 'responsible' because have a mortgaged house and 2 points of risk") {
                val command = aRiskProfileCalculateCommandWithMortgagedAndRisk()
                riskProfileCalculatorHome.calculate(command) shouldBe "responsible"
            }
        }
    }
}