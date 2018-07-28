package com.epam.lab.coding.client;

import com.google.gwt.core.client.JavaScriptObject;

public class User extends JavaScriptObject {

  protected User() {}

  public final native int getId()/*-{ return this.id; }-*/;
  public final native String getLogin()/*-{ return this.login; }-*/;
  public final native String getUrl()/*-{ return this.url; }-*/;
  public final native String getType()/*-{ return this.type; }-*/;
}

