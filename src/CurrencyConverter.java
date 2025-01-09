package src;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private APIClient apiClient;
    private Map<String, Double> tasasDeCambio;

    public CurrencyConverter() {
        this.apiClient = new APIClient();
        // Inicializar el mapa de tasas de cambio
        this.actualizarTasasDeCambio();
    }

    private void actualizarTasasDeCambio() {
        try {
            // Obtener las tasas de cambio desde la API
            this.tasasDeCambio = this.apiClient.obtenerTasasDeCambio();
            if (this.tasasDeCambio == null || this.tasasDeCambio.isEmpty()) {
                throw new RuntimeException("Las tasas de cambio no están disponibles.");
            }
        } catch (IOException e) {
            System.out.println("Error al actualizar las tasas de cambio: " + e.getMessage());
        }
    }

    public double convertir(int opcion, double monto) {
        double resultado = 0;
        if (this.tasasDeCambio != null && !this.tasasDeCambio.isEmpty()) {
            switch (opcion) {
                case 1:
                    // Conversión de USD a Peso Argentino
                    resultado = monto * tasasDeCambio.get("ARS");
                    break;
                case 2:
                    // Conversión de Peso Argentino a USD
                    resultado = monto / tasasDeCambio.get("ARS");
                    break;
                case 3:
                    // Conversión de USD a Real Brasileño
                    resultado = monto * tasasDeCambio.get("BRL");
                    break;
                case 4:
                    // Conversión de Real Brasileño a USD
                    resultado = monto / tasasDeCambio.get("BRL");
                    break;
                case 5:
                    // Conversión de USD a Peso Colombiano
                    resultado = monto * tasasDeCambio.get("COP");
                    break;
                case 6:
                    // Conversión de Peso Colombiano a USD
                    resultado = monto / tasasDeCambio.get("COP");
                    break;
            }
        } else {
            System.out.println("Las tasas de cambio no están disponibles. Intente nuevamente más tarde.");
        }
        return resultado;
    }
}
