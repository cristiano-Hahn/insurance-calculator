package com.cristianohahn.insurance

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class InsuranceApplication

fun main(args: Array<String>) {
	runApplication<InsuranceApplication>(*args)
}
