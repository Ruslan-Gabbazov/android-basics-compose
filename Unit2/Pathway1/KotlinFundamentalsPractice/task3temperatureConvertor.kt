fun printFinalTemperature(
    initialMeasurement: Double, 
    initialUnit: String, 
    finalUnit: String, 
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement))
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}

fun main() {
    val celsiusToFahrenheit: (Double) -> Double = { temp -> 9 * temp / 5 + 32 }
    val kelvinToCelsius: (Double) -> Double = { temp -> temp - 273.15 }
    val fahrenheitToKelvin: (Double) -> Double = { temp -> 5 * (temp - 32) / 9 + 273.15 }

    printFinalTemperature(27.0, "Celsius", "Fahrenheit", celsiusToFahrenheit)
    printFinalTemperature(350.0, "Kelvin", "Celsius", kelvinToCelsius)
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin", fahrenheitToKelvin)
}
