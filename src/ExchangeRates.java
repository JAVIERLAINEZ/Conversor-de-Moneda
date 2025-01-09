package src;

import java.util.Map;

public class ExchangeRates {
    private Map<String, Double> conversion_rates;

    // Método para obtener las tasas de conversión
    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

    // Método para establecer las tasas de conversión
    public void setConversionRates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
}
