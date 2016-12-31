package com.yilan.shiro;

import org.apache.shiro.authc.AuthenticationToken;

import java.util.Map;

/**
 * Created by zhujiahao on 2016-12-28.
 */
public class StatelessToken implements AuthenticationToken {
  private String username;
  private Map<String, ?> params;
  private String clientDigest;

  public StatelessToken(String username, Map<String, ?> params, String clientDigest) {
    this.username = username;
    this.params = params;
    this.clientDigest = clientDigest;
  }

  public String getUsername() {
      return username;
  }

  public StatelessToken setUsername(String username) {
    this.username = username;
    return this;
  }

  public Map<String, ?> getParams() {
      return params;
  }

  public StatelessToken setParams(Map<String, ?> params) {
    this.params = params;
    return this;
  }

  public String getClientDigest() {
      return clientDigest;
  }

  public StatelessToken setClientDigest(String clientDigest) {
    this.clientDigest = clientDigest;
    return this;
  }

  public Object getPrincipal() {  return username;}
  public Object getCredentials() {  return clientDigest;}
}
