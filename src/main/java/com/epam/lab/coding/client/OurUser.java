package com.epam.lab.coding.client;

import java.io.Serializable;

public class OurUser implements Serializable {

  private String login;
  private String password;
  private String Name;
  private String steamApiKey;
  private int attempts = 10;
  private User user;

  public OurUser() {
  }

  public OurUser(String login, String password, String name, String steamApiKey, User user) {
    this.login = login;
    this.password = password;
    Name = name;
    this.steamApiKey = steamApiKey;
    this.user = user;
  }

  public int getAttempts() {
    return attempts;
  }

  public User getUser() {
    return user;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return Name;
  }

  public String getSteamApiKey() {
    return steamApiKey;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setName(String name) {
    Name = name;
  }

  public void setSteamApiKey(String steamApiKey) {
    this.steamApiKey = steamApiKey;
  }

  public void setAttempts(int attempts) {
    this.attempts = attempts;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
