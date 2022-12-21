# Invoicing API challenge

Spring Boot command line application that lets you sum invoice documents in different currencies via
a file.

## Requirements

- Amazon Corretto 17 JDK

## Usage

### Build application with:

```
./gradlew bootJar
```

### Run with:

```
java -jar invoice-calculator-0.0.1-SNAPSHOT.jar  --filePath=<path to CSV file> --currencyList="<list of currencies and exchange rates> --outputCurrency="<output currency>"
```

### Available params:

- filePath (required) - path to CSV file containing the document records
- currencyList (required) - comma separated list of currencies in ISO 4217 and their exchange rates
- outputCurrency (required) - output currency in ISO 4217
- filterByVat (optional) - filter the results by a customer VAT number

### Example usage:

```
java -jar invoice-calculator-0.0.1-SNAPSHOT.jar  --filePath=data.csv --currencyList="EUR:1,USD:0.987,GBP:0.878" --outputCurrency="GBP"
```
