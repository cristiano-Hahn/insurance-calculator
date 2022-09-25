package com.cristianohahn.insurance.service.calculator

import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorLifeTestFixture.aDefaultRiskProfileCalculateCommand
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorLifeTestFixture.aRiskProfileCalculateCommandMarried
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorLifeTestFixture.aRiskProfileCalculateCommandWithAge
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorLifeTestFixture.aRiskProfileCalculateCommandWithDependents
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorLifeTestFixture.aRiskProfileCalculateCommandWithDependentsMarriedAndRisk
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RiskProfileCalculatorLifeTest : DescribeSpec() {

    private val riskProfileCalculatorLife = RiskProfileCalculatorLife()

    init {
        describe("Calculate life risk profile"){
            it("Should be 'ineligible' because age is more or equal than 60"){
                val command = aRiskProfileCalculateCommandWithAge(60)
                riskProfileCalculatorLife.calculate(command) shouldBe "ineligible"
            }

            it("Should be 'economic' because doesn't have any dependent and isn't married"){
                val command = aDefaultRiskProfileCalculateCommand()
                riskProfileCalculatorLife.calculate(command) shouldBe "economic"
            }

            it("Should be 'regular' because have dependents"){
                val command = aRiskProfileCalculateCommandWithDependents()
                riskProfileCalculatorLife.calculate(command) shouldBe "regular"
            }

            it("Should be 'regular' because is married"){
                val command = aRiskProfileCalculateCommandMarried()
                riskProfileCalculatorLife.calculate(command) shouldBe "regular"
            }

            it("Should be 'responsible' because is married, have a dependent and have a risk question"){
                val command = aRiskProfileCalculateCommandWithDependentsMarriedAndRisk()
                riskProfileCalculatorLife.calculate(command) shouldBe "responsible"
            }
        }
    }
}