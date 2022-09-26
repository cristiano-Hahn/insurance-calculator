# Insurance risk calculator
The project consists of creating, in the REST standard, an API to calculate risks of insurances based on user information. This project just have one feature that receive the user information, calculate the insurance, and returns the risk profile.

This is part of the Origin backend take home assignment, the original test is available [here](https://github.com/OriginFinancial/origin-backend-take-home-assignment#readme)  

## About The API

The API consist just with one endpoint, that will receive a JSON with user information and calculate the risk profile.

### The request
Request is a POST on  `/risk_profile/calculate`  endpoint. The fields are:

Name | Type | Required
--- | --- |---
age | Integer | true
dependents | Integer | true
house.ownership_status | String | false
income | Float | true
marital_status | String | true
risk_questions | Array of Integer | true
vehicle.year | Integer | false

Example of request:

```bash
curl --location --request POST 'http://localhost:8080/risk_profile/calculate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "age": 20,
    "dependents": "1",
    "income": 6000,
    "marital_status": "single",
    "risk_questions": [0,0,0],
    "vehicle": {
        "year": 2020
    },
    "house": {
        "ownership_status": "mortgaged"
    }
}'
```

### Response
The request is a JSON with the following fields: 

Name | Type | Nullable | Values
--- | --- |--- |---
auto | String | false | `"economic"` , `"regular"` ,  `"responsible"` , `"ineligible"`
disability | String | false | `"economic"` , `"regular"` ,  `"responsible"` , `"ineligible"`
home | String | false | `"economic"` , `"regular"` ,  `"responsible"` , `"ineligible"`
life | String | false | `"economic"` , `"regular"` ,  `"responsible"` , `"ineligible"`

Example of response: 

```JSON
{
  "auto": "economic",
  "disability": "economic",
  "home": "economic",
  "life": "economic"
}
```

## Running it locally

### Installation
Clone the repo
```
git clone https://github.com/cristiano-Hahn/insurance-calculator.git
```

### Execution (With IDE)
Open the project in your preferred IDE and run the main class **InsuranceApplication**.

### Execution (With command line)
1. Download java JDK 17 ([Download Here](https://jdk.java.net/archive/))
2. Set the `JAVA_HOME` environment with the path of your downloaded java
3. Execute the command `./gradlew clean build`, it will build the project and run all the tests
4. Execute the command `./gradlew bootRun`, it will start the service

Optional: You can just run the tests with the `./gradlew test` command

Note: this service will start on port `8080`, if you want to change it, just change the property `server.port` on `application.properties` file.

### Usage

You can just call the API with `cURL` or use the  [postman collection](docs/Insurance_app.postman_collection.json)  to do it :D

## How it was developed?

### Built With
* [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/) - The IDE used
* [Java 17](https://www.java.com/pt-BR/) - Execution platform
* [Spring Boot - 2.7.3](https://spring.io/projects/spring-boot) - Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run"
* [Kotlin](https://kotlinlang.org/) - Language
* [Kotest](https://kotest.io/) - Multi-platform test framework for Kotlin
* [Mockk](https://mockk.io/) - Mocking library for Kotlin

### How is the architecture?
The answer is: Simple! Is a classic MVC application with controller, service and domain layers. For this problem, we don't need to use complex architecture, so my objective was keep it organized and simple.

### Why it is extensible and maintainable?
The application core was developed to be easy to maintain the current algorithms and extend to new kinds of insurances or new features. Some examples of situations are:

Need to change the algorithm of `life` insurance? Easy, just change it on `RiskProfileCalculatorLife` class

Need to change the algorithm of `home` insurance? Easy, just change it on `RiskProfileCalculatorHome` class

Need to change the algorithm that impact all kinds of insurance? Easy, just change it on `RiskProfileCalculator` class, and it will be distributed automatically to all the insurances

Need to add a new kind of insurance? Easy, just create a `RiskProfileCalculatorStuff` class inheriting `RiskProfileCalculator` and apply the new algorithm

## Contact

To contact me use the options:
* E-mail  : cristianohahn.contato@gmail.com
* Linkedin: [Cristiano Hahn](https://www.linkedin.com/in/cristiano-dall-agnol-hahn-78a386128/)