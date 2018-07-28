package com.epam.lab.coding;

public class OurUser {

  private final String login;
  private final String password;
  private final String Name;
  private final String steamApiKey;


  public OurUser(String login, String password, String name, String steamApiKey) {
    this.login = login;
    this.password = password;
    Name = name;
    this.steamApiKey = steamApiKey;
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
}
