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
            return modrinthApi.requestSender.get(endpoint, auth);
        } catch (IOException e) {
            modrinthApi.sendException(e);
        } catch (InterruptedException e) {
            modrinthApi.sendException(e);
        }
        modrinthApi.sendException(new RuntimeException("Could not send get request"));
        return null;
    }

    public void post(String endpoint, HttpRequest.BodyPublisher bodyPublisher)  {
        try {
            modrinthApi.requestSender.post(endpoint, bodyPublisher);
        } catch (IOException e) {
            modrinthApi.sendException(e);
        } catch (InterruptedException e) {
            modrinthApi.sendException(e);
        }
    }

    public void del(String endpoint) {
        try {
            modrinthApi.requestSender.del(endpoint);
        } catch (IOException e) {
            modrinthApi.sendException(e);
        } catch (InterruptedException e) {
            modrinthApi.sendException(e);
        }
    }

    public <T> T deserialize(String json, Class<T> tClass) {
        try
        {
            return ModrinthApi.GSON.fromJson(json, tClass);
        }catch (Exception e) {
            modrinthApi.sendException(e);
        }
        modrinthApi.sendException(new RuntimeException("Could not deserialize JSON"));
        return null;
    }
}
