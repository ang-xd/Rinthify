package com.angxd.data.projects;

import com.angxd.data.misc.License;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class Project{
    public String id;
    public String slug;
    @SerializedName("project_type")
    public String projectType;
    public String team;
    public String title;
    public String description;
    public String body;
    @SerializedName("body_url")
    public Object bodyUrl;
    public Date published;
    public Date updated;
    public Object approved;
    public String status;
    @SerializedName("moderator_message")
    public Object moderatorMessage;
    public License license;
    @SerializedName("client_side")
    public String clientSide;
    @SerializedName("server_side")
    public String serverSide;

    public String getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public String getProjectType() {
        return projectType;
    }

    public String getTeam() {
        return team;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getBody() {
        return body;
    }

    public Object getBodyUrl() {
        return bodyUrl;
    }

    public Date getPublished() {
        return published;
    }

    public Date getUpdated() {
        return updated;
    }

    public Object getApproved() {
        return approved;
    }

    public String getStatus() {
        return status;
    }

    public Object getModeratorMessage() {
        return moderatorMessage;
    }

    public License getLicense() {
        return license;
    }

    public String getClientSide() {
        return clientSide;
    }

    public String getServerSide() {
        return serverSide;
    }

    public int getDownloads() {
        return downloads;
    }

    public int getFollowers() {
        return followers;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public ArrayList<String> getAdditionalCategories() {
        return additionalCategories;
    }

    public ArrayList<String> getVersions() {
        return versions;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getIssuesUrl() {
        return issuesUrl;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public Object getWikiUrl() {
        return wikiUrl;
    }

    public String getDiscordUrl() {
        return discordUrl;
    }

    public ArrayList<Object> getDonationUrl() {
        return donationUrl;
    }

    public ArrayList<Object> getGallery() {
        return gallery;
    }

    public int downloads;
    public int followers;
    public ArrayList<String> categories;
    @SerializedName("additional_categories")
    public ArrayList<String> additionalCategories;
    public ArrayList<String> versions;
    @SerializedName("icon_url")
    public String iconUrl;
    @SerializedName("issues_url")
    public String issuesUrl;
    @SerializedName("source_url")
    public String sourceUrl;
    @SerializedName("wiki_url")
    public Object wikiUrl;
    @SerializedName("discord_url")
    public String discordUrl;
    @SerializedName("donation_urls")
    public ArrayList<Object> donationUrl;
    public ArrayList<Object> gallery;
}
