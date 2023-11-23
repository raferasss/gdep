package com.raferasss.gdep.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DependencyDTO {
    private String id;
    private String group;
    private String artifact;
    private String latestVersion;

    // construtores, getters e setters

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("g")
    public String getGroup() {
        return group;
    }

    @JsonProperty("a")
    public String getArtifact() {
        return artifact;
    }

    @JsonProperty("latestVersion")
    public String getLatestVersion() {
        return latestVersion;
    }
}