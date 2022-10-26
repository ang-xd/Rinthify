package com.angxd.rinthify.util;

import com.angxd.rinthify.ModrinthApi;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class Endpoint {
    public ModrinthApi modrinthApi;

    public Endpoint(ModrinthApi modrinthApi) {
        this.modrinthApi = modrinthApi;
    }

    public String get(String endpoint, boolean auth) {
        try {
            modrinthApi.requestSender.get(endpoint, auth);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return endpoint;
    }

    public void post(String endpoint, HttpRequest.BodyPublisher bodyPublisher)  {
        try {
            modrinthApi.requestSender.post(endpoint, bodyPublisher);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void del(String endpoint) {
        try {
            modrinthApi.requestSender.del(endpoint);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T deserialize(String json, Class<T> tClass) {
        return ModrinthApi.GSON.fromJson(json, tClass);
    }


}
