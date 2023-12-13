# Description

This is a demo project which consists in creating a spring annotation using Spring AOP, basically this project "intercepts" the signature from the request and gets the values to create a file using them.
In advance, the objective is to convert any Mexican amount ($) to another currency.


# Considerations

Due to this is a demo project, currency values are taken from a Map, so they are "hard values", if in the future every Mexican $ changes in respect to another currency, it should be updated.


## Installation

Clone this project and open it in your favorite IDE o Text Editor to start

### Eclipse
1. Click File
2. Import
3. Maven
4. Existing Maven Project
5. Browse
6. Click in the app folder
7. Click Select folder button
8. pom.xml will be selected
9. Finish
10. Wait until project is imported to your workspace
11. Run the app as Spring Boot Application

### IntelliJ

1. Open IntelliJ IDEA
2. From the Welcome screen, click Open
3. Navigate to your Maven project and select the top-level folder.
4. Click OK
5. If prompt is opened, Click on Trust in this project
6. Wait until project is imported to your workspace
7. Run the app as Spring Boot Application


## Usage

### Test to get available currencies

```
GET http://localhost:5443/currency
[
    "USD",
    "EUR",
    "GBP"
]
```

### Test to convert any Mexican $ amount to another currency

```
POST http://localhost:5443/currency/EUR?amount=900
{
    "MXN toEUR": 48.6
}
```

# Stack
- Spring Boot
- Maven
- Java

# What else can I do?

1. Create a standard service response
2. Create an Exception handler using RestControllerAdvice to create a standard response to exceptions
3. Handle exceptions properly login the in log files
4. Create a service to get in real time the equivalence from Mexican $ to any other currency in the world
5. Add a feature to convert from any currency to any currency
6. Create a front application to consume this services and to present the information in a kind of currency converter.