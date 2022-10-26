package com.angxd;

import com.angxd.endpoints.ProjectsEndpoint;
import com.angxd.endpoints.UsersEndpoint;
import com.angxd.util.RequestSender;
import com.google.gson.Gson;
import org.jetbrains.annotations.Nullable;

import java.net.http.HttpClient;

public class ModrinthApi {
    public final String BASE_URL;
    public static final Gson GSON = new Gson();
    public final RequestSender SENDER;
    public final ProjectsEndpoint PROJECTS;
    public final UsersEndpoint USERS;
    private final String apiKey;

    public ModrinthApi(String apiKey, boolean staging) {
        this.apiKey = apiKey;
        this.BASE_URL = staging ? "https://staging-api.modrinth.com/v2/" : "https://api.modrinth.com/v2/";

        this.SENDER = new RequestSender(HttpClient.newHttpClient(), apiKey, this);
        this.PROJECTS = new ProjectsEndpoint(this);
        this.USERS = new UsersEndpoint(this);
    }


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String apiKey;
        private boolean stagingApi = false;
        private Builder() {
        }

        public Builder apiKey(@Nullable String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder useStagingApi() {
            this.stagingApi = true;
            return this;
        }

        public ModrinthApi build() {
            ModrinthApi api = new ModrinthApi(apiKey, stagingApi);
            return api;
        }
    }
}
