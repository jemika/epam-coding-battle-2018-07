package com.epam.lab.coding.server;

import com.epam.lab.coding.client.OurUser;
import com.epam.lab.coding.client.User;
import com.epam.lab.coding.client.services.AccountService;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl extends RemoteServiceServlet implements AccountService {

  private List<OurUser> userList = new ArrayList<>();

  @Override
  public OurUser login(String userName, String password) {
    OurUser ourUser1 = new OurUser();
    ourUser1.setLogin("login");
    ourUser1.setPassword("123");
    userList.add(ourUser1);
    OurUser ourUser = userList.stream()
        .filter(user -> user.getPassword().equals(password) && user.getLogin().equals(userName))
        .findFirst().get();
    return getUser(ourUser);
  }


  private OurUser getUser(OurUser user) {
    RequestBuilder requestBuilder
        = new RequestBuilder(RequestBuilder.GET,
        "https://api.steampowered.com/ISteamUser/GetPlayerSummaries/v2/?key=0EE6E555212B0399670196862E5A30DE&format=json&steamids=76561198110841214");
    OurUser ourUser = userList.stream()
        .filter(user1 -> user1.getName().equals(user.getName()) && user1.getPassword()
            .equals(user.getPassword())).findFirst().get();
    try {
      requestBuilder.setHeader("Content-Type", "application/json; charset=utf-8");
      requestBuilder.sendRequest(null, new RequestCallback() {
        @Override
        public void onResponseReceived(Request request, Response response) {
          if (response.getStatusCode() == 200) {
            String json = response.getText();
            JsArray<User> array = JsonUtils.safeEval(json);
            ourUser.setUser(array.get(0));
          }
        }
        @Override
        public void onError(Request request, Throwable throwable) {

        }
      });
    } catch (RequestException e) {
      e.printStackTrace();
    }
    return ourUser;
  }
}