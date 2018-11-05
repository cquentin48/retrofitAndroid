package com.example.lpiem.retrofit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Change {
    String created;

    JSONArray owner;

    String branch;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public JSONArray getOwner() {
        return owner;
    }

    public void setOwner(JSONArray owner) {
        this.owner = owner;
    }

    public JSONObject getAccountId() throws JSONException {
        return (JSONObject) this.owner.get(0);
    }
}