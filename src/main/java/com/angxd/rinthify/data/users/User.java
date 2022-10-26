package com.angxd.rinthify.data.users;

import com.google.gson.annotations.SerializedName;

public class User{
    public String username;
    public String name;
    public String email;
    public String bio;
    public String id;
    @SerializedName("github_id")
    public int githubId;
    @SerializedName("avatar_url")
    public String avatarUrl;
    public String created;
    public String role;

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }

    public String getId() {
        return id;
    }

    public int getGithubId() {
        return githubId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getCreated() {
        return created;
    }

    public String getRole() {
        return role;
    }
}
