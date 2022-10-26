package com.angxd.rinthify;

import com.angxd.rinthify.endpoints.ModrinthEndpoints;
import com.angxd.rinthify.endpoints.ProjectsEndpoint;
import com.angxd.rinthify.endpoints.UsersEndpoint;
import com.angxd.rinthify.endpoints.VersionsEndpoint;
import com.angxd.rinthify.util.RequestSender;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.Nullable;

import java.net.http.HttpClient;

public class ModrinthApi {
    public final String baseUrl;
    public final RequestSender requestSender;
    private final ModrinthEndpoints endpoints;
    public static final Gson GSON = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()
            .create();

    public ModrinthApi(String apiKey, String userAgent, boolean staging) {
        this.baseUrl = staging ? "https://staging-api.modrinth.com/v2/" : "https://api.modrinth.com/v2/";
        this.requestSender = new RequestSender(HttpClient.newHttpClient(), apiKey, userAgent, this);
        this.endpoints = new ModrinthEndpoints(this);
    }

    public ModrinthEndpoints getEndpoints() {
        return endpoints;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String apiKey;
        private String userAgent = "User-Agent: github.com/ang-xd/Rinthify (Modrinth API Wrapper)";
        private boolean stagingApi = false;
        private Builder() {
        }

        /**
         * Your API key can be found at https://modrinth.com/settings/security
         */
        public Builder apiKey(@Nullable String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        /**
         * This will make all requests go to Modrinth's staging server instead of production
         */
        public Builder useStagingApi() {
            this.stagingApi = true;
            return this;
        }
        /**
         * If you want to use a custom user agent, use this
         */
        public Builder userAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        public ModrinthApi build() {
            ModrinthApi api = new ModrinthApi(apiKey, userAgent, stagingApi);
            return api;
        }
    }
}
