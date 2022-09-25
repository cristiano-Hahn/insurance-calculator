package com.cristianohahn.insurance.controller

import com.cristianohahn.insurance.InsuranceApplication
import com.cristianohahn.insurance.controller.RiskProfileControllerTestFixture.aRiskProfile
import com.cristianohahn.insurance.controller.RiskProfileControllerTestFixture.aRiskProfileCalculateCommand
import com.cristianohahn.insurance.service.RiskProfileService
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.listeners.TestListener
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.spring.SpringListener
import io.mockk.coEvery
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration

//@SpringBootTest
//@ContextConfiguration(classes=[InsuranceApplication::class])
//@WebMvcTest(controllers = [RiskProfileController::class])
class RiskProfileControllerTest(applicationContext: ApplicationContext) {

  //  override fun listeners(): List<TestListener> = listOf(SpringListener)

    @MockkBean
    private lateinit var riskProfileService: RiskProfileService

    private val webClient = createWebTestClient(applicationContext)

//    init {
//        describe("Calculate risk profile") {
//            val command = aRiskProfileCalculateCommand()
//            val riskProfile = aRiskProfile()
//            coEvery { riskProfileService.calculate(any()) } returns riskProfile
//
//            webClient
//                .post()
//                .uri {
//                    it.path("/risk_profile/calculate").build()
//                }
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(command)
//                .exchange()
//                .expectStatus()
//                .isOk
//        }
//    }

}