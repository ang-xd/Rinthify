package com.angxd.util;

import com.angxd.ModrinthApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class RequestSender {
    private final HttpClient httpClient;
    private final String apiKey;
    private final ModrinthApi modrinthApi;
    public RequestSender(HttpClient httpClient, String apiKey, ModrinthApi modrinthApi) {
        this.httpClient = httpClient;
        this.apiKey = apiKey;
        this.modrinthApi = modrinthApi;
    }

    public void post(String endpoint, HttpRequest.BodyPublisher bodyPublisher) throws IOException, InterruptedException {
        HttpRequest.Builder reqBuilder = HttpRequest.newBuilder()
                .uri(URI.create(modrinthApi.BASE_URL + endpoint))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .header("Authorization", this.apiKey)
                .POST(bodyPublisher);
        HttpRequest req = reqBuilder.build();
        httpClient.send(req, HttpResponse.BodyHandlers.ofString());
    }

    public void del(String endpoint) throws IOException, InterruptedException {
        HttpRequest.Builder reqBuilder = HttpRequest.newBuilder()
                .uri(URI.create(modrinthApi.BASE_URL + endpoint))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .header("Authorization", this.apiKey)
                .DELETE();
        HttpRequest req = reqBuilder.build();
        httpClient.send(req, HttpResponse.BodyHandlers.ofString());
    }

    public String get(String endpoint, boolean auth) throws IOException, InterruptedException {
        HttpRequest.Builder reqBuilder = HttpRequest.newBuilder()
                .uri(URI.create(modrinthApi.BASE_URL + endpoint))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .GET();
        if(auth) reqBuilder.header("Authorization", this.apiKey);
        HttpRequest req = reqBuilder.build();

        HttpResponse<String> response =
                httpClient.send(req, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
