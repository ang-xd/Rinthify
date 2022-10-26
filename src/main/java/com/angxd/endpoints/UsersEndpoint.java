package com.angxd.endpoints;

import com.angxd.ModrinthApi;
import com.angxd.data.users.User;
import com.angxd.util.Endpoint;

import java.io.IOException;

public class UsersEndpoint extends Endpoint {

    public UsersEndpoint(ModrinthApi modrinthApi) {
        super(modrinthApi);
    }

    public User getUser(String username) {
        try {
            User user = ModrinthApi.GSON.fromJson(modrinthApi.SENDER.get("user/" + username, false), User.class);
            return user;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public User getAuthenticatedUser() {
        try {
            User user = ModrinthApi.GSON.fromJson(modrinthApi.SENDER.get("user", true), User.class);
            return user;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
