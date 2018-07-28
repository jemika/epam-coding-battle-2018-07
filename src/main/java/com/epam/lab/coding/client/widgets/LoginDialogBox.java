package com.epam.lab.coding.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import java.util.function.BiConsumer;

public class LoginDialogBox extends DialogBox {


  public LoginDialogBox(BiConsumer<String, String> onLoginButtonClickAction) {
    TextBox userNameField = new TextBox();
    PasswordTextBox passwordField = new PasswordTextBox();
    Button loginButton = new Button("Login");
    loginButton.addClickHandler(event -> onLoginButtonClickAction.accept(userNameField.getText(), passwordField.getText()));

    VerticalPanel verticalPanel = new VerticalPanel();
    verticalPanel.add(userNameField);
    verticalPanel.add(passwordField);
    verticalPanel.add(loginButton);

    setText("Login form");
    setAnimationEnabled(true);
    add(verticalPanel);
  }
}

