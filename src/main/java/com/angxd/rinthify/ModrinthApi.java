package com.angxd.rinthify;

import com.angxd.rinthify.endpoints.ModrinthEndpoints;
import com.angxd.rinthify.endpoints.ProjectsEndpoint;
import com.angxd.rinthify.endpoints.UsersEndpoint;
import com.angxd.rinthify.endpoints.VersionsEndpoint;
import com.angxd.rinthify.util.RequestSender;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.Nullable;

import java.beans.ExceptionListener;
import java.net.http.HttpClient;
import java.util.function.Consumer;

public class ModrinthApi {
    public final String baseUrl;
    public final RequestSender requestSender;
    private final ModrinthEndpoints endpoints;
    @Nullable
    private final Consumer<Exception> exceptionListener;
    public static final Gson GSON = new GsonBuilder()
            .create();

    public ModrinthApi(String apiKey, String userAgent, boolean staging, Consumer<Exception> exceptionListener) {
        this.baseUrl = staging ? "https://staging-api.modrinth.com/v2/" : "https://api.modrinth.com/v2/";
        this.requestSender = new RequestSender(HttpClient.newHttpClient(), apiKey, userAgent, this);
        this.endpoints = new ModrinthEndpoints(this);
        this.exceptionListener = exceptionListener;
    }

    public ModrinthEndpoints getEndpoints() {
        return endpoints;
    }

    public void sendException(Exception e) {
        if(this.exceptionListener != null) this.exceptionListener.accept(e);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String apiKey;
        private String userAgent = "User-Agent: github.com/ang-xd/Rinthify (Modrinth API Wrapper)";
        private boolean stagingApi = false;
        @Nullable
        private Consumer<Exception> exceptionListener;
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

        public Builder exceptionListener(Consumer<Exception> listener) {
            this.exceptionListener = listener;
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
            ModrinthApi api = new ModrinthApi(apiKey, userAgent, stagingApi, exceptionListener);
            return api;
        }
    }
}
