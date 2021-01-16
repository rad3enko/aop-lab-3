package ru.sut.ism91z.radchenko.model;

public class Customer {

    private Long id;
    private String name;
    private String personalUrl;
    private String city;
    private boolean admin;

    public Customer(Long id, String name, String personalUrl, String city, boolean admin) {
        this.id = id;
        this.name = name;
        this.personalUrl = personalUrl;
        this.city = city;
        this.admin = admin;
    }

    @Override
    public String toString() {
        return  "id = " + this.id.toString() + "\n" +
                "name = " + (this.name == null ? "null" : this.name) + "\n" +
                "personalUrl = " + (this.personalUrl == null ? "null" : this.personalUrl) + "\n" +
                "city = " + (this.city == null ? "null" : this.city) + "\n" +
                "isAdmin = " + (this.admin ? "true" : "false");
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPersonalUrl() {
        return personalUrl;
    }

    public String getCity() {
        return city;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonalUrl(String personalUrl) {
        this.personalUrl = personalUrl;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
