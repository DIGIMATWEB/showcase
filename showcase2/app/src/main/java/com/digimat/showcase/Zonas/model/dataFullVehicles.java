package com.digimat.showcase.Zonas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class dataFullVehicles {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("terms")
    @Expose
    private String terms;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("game")
    @Expose
    private String game;
    @SerializedName("lat_user")
    @Expose
    private String latUser;
    @SerializedName("longUser")
    @Expose
    private String longUser;
    @SerializedName("fecha")
    @Expose
    private String fecha;

    public dataFullVehicles(String id, String name, String lastname, String email, String country, String terms, String score, String game, String latUser, String longUser, String fecha) {
        super();
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.country = country;
        this.terms = terms;
        this.score = score;
        this.game = game;
        this.latUser = latUser;
        this.longUser = longUser;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getLatUser() {
        return latUser;
    }

    public void setLatUser(String latUser) {
        this.latUser = latUser;
    }

    public String getLongUser() {
        return longUser;
    }

    public void setLongUser(String longUser) {
        this.longUser = longUser;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


}