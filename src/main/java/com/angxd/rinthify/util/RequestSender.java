package com.angxd.rinthify.util;

import com.angxd.rinthify.ModrinthApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class RequestSender {
    private final HttpClient httpClient;
    private final String apiKey;
    private final String userAgent;
    private final ModrinthApi modrinthApi;
    public RequestSender(HttpClient httpClient, String apiKey, String userAgent, ModrinthApi modrinthApi) {
        this.httpClient = httpClient;
        this.apiKey = apiKey;
        this.userAgent = userAgent;
        this.modrinthApi = modrinthApi;
    }

    private HttpRequest.Builder getBuilder(String endpoint) {
        return HttpRequest.newBuilder()
                .uri(URI.create(modrinthApi.baseUrl + endpoint))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .header("User-Agent", userAgent);
    }
    public void post(String endpoint, HttpRequest.BodyPublisher bodyPublisher) throws IOException, InterruptedException {
        HttpRequest req = getBuilder(endpoint)
                .header("Authorization", this.apiKey)
                .POST(bodyPublisher).build();
        httpClient.send(req, HttpResponse.BodyHandlers.ofString());
    }

    public void del(String endpoint) throws IOException, InterruptedException {
        HttpRequest req = getBuilder(endpoint)
                .header("Authorization", this.apiKey)
                .DELETE().build();
        httpClient.send(req, HttpResponse.BodyHandlers.ofString());
    }

    public String get(String endpoint, boolean auth) throws IOException, InterruptedException {

        HttpRequest.Builder reqBuilder = getBuilder(endpoint)
                .GET();

        if(auth) reqBuilder.header("Authorization", this.apiKey);

        HttpRequest req = reqBuilder.build();

        HttpResponse<String> response =
                httpClient.send(req, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
