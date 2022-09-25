package com.cristianohahn.insurance.service

import com.cristianohahn.insurance.service.RiskProfileServiceTestFixture.aDefaultRiskProfileCalculateCommand
import com.cristianohahn.insurance.service.RiskProfileServiceTestFixture.aRiskProfileCalculateCommandWithInvalidAge
import com.cristianohahn.insurance.service.RiskProfileServiceTestFixture.aRiskProfileCalculateCommandWithInvalidDependents
import com.cristianohahn.insurance.service.RiskProfileServiceTestFixture.aRiskProfileCalculateCommandWithInvalidIncome
import com.cristianohahn.insurance.service.RiskProfileServiceTestFixture.aRiskProfileCalculateCommandWithInvalidMaritalStatus
import com.cristianohahn.insurance.service.RiskProfileServiceTestFixture.aRiskProfileCalculateCommandWithInvalidOwnershipStatus
import com.cristianohahn.insurance.service.RiskProfileServiceTestFixture.aRiskProfileCalculateCommandWithInvalidVehicleYear
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorAuto
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorDisability
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorHome
import com.cristianohahn.insurance.service.calculator.RiskProfileCalculatorLife
import com.cristianohahn.insurance.service.exception.RiskProfileInformationNotValidException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class RiskProfileServiceTest : DescribeSpec() {


    private val riskProfileCalculatorAuto = mockk<RiskProfileCalculatorAuto>()
    private val riskProfileCalculatorHome = mockk<RiskProfileCalculatorHome>()
    private val riskProfileCalculatorLife = mockk<RiskProfileCalculatorLife>()
    private val riskProfileCalculatorDisability = mockk<RiskProfileCalculatorDisability>()

    private val riskProfileService = RiskProfileService(
        riskProfileCalculatorAuto = riskProfileCalculatorAuto,
        riskProfileCalculatorHome = riskProfileCalculatorHome,
        riskProfileCalculatorLife = riskProfileCalculatorLife,
        riskProfileCalculatorDisability = riskProfileCalculatorDisability
    )


    init {
        describe("Calculate risk profile") {
            context("Validations") {
                it("Should throw exception because age is not valid") {
                    val command = aRiskProfileCalculateCommandWithInvalidAge()
                    val exception = shouldThrow<RiskProfileInformationNotValidException> {
                        riskProfileService.calculate(command)
                    }
                    exception.message shouldContain "age"
                }

                it("Should throw exception because dependents is not valid") {
                    val command = aRiskProfileCalculateCommandWithInvalidDependents()
                    val exception = shouldThrow<RiskProfileInformationNotValidException> {
                        riskProfileService.calculate(command)
                    }
                    exception.message shouldContain "dependents"
                }
                it("Should throw exception because income is not valid") {
                    val command = aRiskProfileCalculateCommandWithInvalidIncome()
                    val exception = shouldThrow<RiskProfileInformationNotValidException> {
                        riskProfileService.calculate(command)
                    }
                    exception.message shouldContain "income"
                }
                it("Should throw exception because marital status is not valid") {
                    val command = aRiskProfileCalculateCommandWithInvalidMaritalStatus()
                    val exception = shouldThrow<RiskProfileInformationNotValidException> {
                        riskProfileService.calculate(command)
                    }
                    exception.message shouldContain "maritalStatus"
                }
                it("Should throw exception because ownership status is not valid") {
                    val command = aRiskProfileCalculateCommandWithInvalidOwnershipStatus()
                    val exception = shouldThrow<RiskProfileInformationNotValidException> {
                        riskProfileService.calculate(command)
                    }
                    exception.message shouldContain "ownershipStatus"
                }
                it("Should throw exception because year of vehicle is not valid") {
                    val command = aRiskProfileCalculateCommandWithInvalidVehicleYear()
                    val exception = shouldThrow<RiskProfileInformationNotValidException> {
                        riskProfileService.calculate(command)
                    }
                    exception.message shouldContain "year"
                }
            }

            context("Calculate risk") {
                it("Should calculate risk profile calling other services") {
                    val command = aDefaultRiskProfileCalculateCommand()
                    every { riskProfileCalculatorAuto.calculate(any()) } returns "economic"
                    every { riskProfileCalculatorHome.calculate(any()) } returns "regular"
                    every { riskProfileCalculatorLife.calculate(any()) } returns "responsible"
                    every { riskProfileCalculatorDisability.calculate(any()) } returns "ineligible"

                    val riskProfile = riskProfileService.calculate(command)

                    riskProfile.auto shouldBe "economic"
                    riskProfile.home shouldBe "regular"
                    riskProfile.life shouldBe "responsible"
                    riskProfile.disability shouldBe "ineligible"

                    verify { riskProfileCalculatorAuto.calculate(command) }
                    verify { riskProfileCalculatorHome.calculate(command) }
                    verify { riskProfileCalculatorLife.calculate(command) }
                    verify { riskProfileCalculatorDisability.calculate(command) }

                    confirmVerified(
                        riskProfileCalculatorAuto,
                        riskProfileCalculatorHome,
                        riskProfileCalculatorLife,
                        riskProfileCalculatorDisability
                    )
                }
            }
        }
    }
}