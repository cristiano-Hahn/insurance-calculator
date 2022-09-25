package com.cristianohahn.insurance.service.calculator.base

import com.cristianohahn.insurance.service.calculator.base.RiskProfileCalculatorTestFixture.aRiskProfileCalculateCommandWith3Risks
import com.cristianohahn.insurance.service.calculator.base.RiskProfileCalculatorTestFixture.aRiskProfileCalculateCommandWithAge
import com.cristianohahn.insurance.service.calculator.base.RiskProfileCalculatorTestFixture.aRiskProfileCalculateCommandWithIncomeMoreThan200000
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RiskProfileCalculatorTest : DescribeSpec() {

    private val riskProfileCalculator = RiskProfileCalculatorMock()

    init {
        describe("Calculate default points") {
            it("Should return 3 because have 3 risk questions") {
                val command = aRiskProfileCalculateCommandWith3Risks()
                riskProfileCalculator.calculatePoints(command) shouldBe 3
            }

            it("Should return -1 because income is more than 200000") {
                val command = aRiskProfileCalculateCommandWithIncomeMoreThan200000()
                riskProfileCalculator.calculatePoints(command) shouldBe -1
            }

            it("Should return -1 because age is les than 40") {
                val command = aRiskProfileCalculateCommandWithAge(39)
                riskProfileCalculator.calculatePoints(command) shouldBe -1
            }

            it("Should return -2 because age is les than 30") {
                val command = aRiskProfileCalculateCommandWithAge(29)
                riskProfileCalculator.calculatePoints(command) shouldBe -2
            }
        }

        describe("Calculate profile description based on risk points") {
            it("Should be economic") {
                riskProfileCalculator.getProfileDescription(0) shouldBe "economic"
            }
            it("Should be regular") {
                riskProfileCalculator.getProfileDescription(1) shouldBe "regular"
                riskProfileCalculator.getProfileDescription(2) shouldBe "regular"
            }
            it("Should be responsible") {
                riskProfileCalculator.getProfileDescription(3) shouldBe "responsible"
            }
        }
    }
}