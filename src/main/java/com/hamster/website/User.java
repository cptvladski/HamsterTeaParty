package com.hamster.website;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection="users")
public class User {
    @Id
    public String _id;

    public String userName;

    public String email;

    public String firstName;

    public String lastName;

    public Integer age;

    public String country;

    public String city;

    public String favoriteSite;

    public List<Integer> jokeIds;

    public String passwd;

    public String phone;

    public Integer coins;

    public User(String _id, String userName, String email, String firstName, String lastName, Integer age, String country, String city, String favoriteSite, List<Integer> jokeIds, String passwd, String phone, Integer coins) {
        this._id = _id;
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
        this.city = city;
        this.favoriteSite = favoriteSite;
        this.jokeIds = jokeIds;
        this.passwd = passwd;
        this.phone = phone;
        this.coins = coins;
    }


    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "_id='" + _id + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", favoriteSite='" + favoriteSite + '\'' +
                ", jokeIds=" + jokeIds +
                ", passwd='" + passwd + '\'' +
                ", phone='" + phone + '\'' +
                ", coins=" + coins +
                '}';
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public User() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFavoriteSite() {
        return favoriteSite;
    }

    public void setFavoriteSite(String favoriteSite) {
        this.favoriteSite = favoriteSite;
    }

    public List<Integer> getJokeIds() {
        return jokeIds;
    }

    public void setJokeIds(List<Integer> jokeIds) {
        this.jokeIds = jokeIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(_id, user._id) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(age, user.age) &&
                Objects.equals(country, user.country) &&
                Objects.equals(city, user.city) &&
                Objects.equals(favoriteSite, user.favoriteSite) &&
                Objects.equals(jokeIds, user.jokeIds) &&
                Objects.equals(passwd, user.passwd) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(coins, user.coins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, userName, email, firstName, lastName, age, country, city, favoriteSite, jokeIds);
    }

}
