package io.github.demirmustafa.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by mustafa on 4/29/17.
 */
@Document
public class Blogger{

    @Id
    private String id;
    private String name;
    private String surname;
    private String username;
    private String blogAddress;
    private String blogHostedOn;
    @TextIndexed
    private String interests;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBlogAddress() {
        return blogAddress;
    }

    public void setBlogAddress(String blogAddress) {
        this.blogAddress = blogAddress;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getBlogHostedOn() {
        return blogHostedOn;
    }

    public void setBlogHostedOn(String blogHostedOn) {
        this.blogHostedOn = blogHostedOn;
    }
}
