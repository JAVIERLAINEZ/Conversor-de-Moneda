package src;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import com.google.gson.Gson;

public class APIClient {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/0c0748a4bee3d49fd0bd6f2a/latest/USD";

    public Map<String, Double> obtenerTasasDeCambio() throws IOException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return parsearTasasDeCambio(response.body()).getConversionRates();
        } catch (InterruptedException | IOException e) {
            throw new IOException("Error al conectar con la API: " + e.getMessage());
        }
    }

    private ExchangeRates parsearTasasDeCambio(String responseBody) {
        Gson gson = new Gson();
        // Deserializar la respuesta JSON en un objeto ExchangeRates
        return gson.fromJson(responseBody, ExchangeRates.class);
    }
}
