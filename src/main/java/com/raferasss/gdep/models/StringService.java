package com.raferasss.gdep.models;

import org.springframework.stereotype.Service;

@Service
public class StringService {
    private String minhaString;
    public void setMinhaString(String minhaString) {
        this.minhaString = minhaString;
    }

    public String getMinhaString() {
        return minhaString;
    }
}
