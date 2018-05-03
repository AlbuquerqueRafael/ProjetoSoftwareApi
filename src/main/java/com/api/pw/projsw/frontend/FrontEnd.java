package com.api.pw.projsw.frontend;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.Column;
import java.io.Serializable;

@Entity
@Table (name = "frontend")
public class FrontEnd implements Serializable {

  private static final long serialVersionUID = -1785131699037567362L;

	@Id
  private String id;

  @Column(nullable = false)
  @JsonProperty(access = Access.WRITE_ONLY)
  private String secret;

  protected FrontEnd () {
	}

	public FrontEnd (String id, String secret) {
    this.id = id;
    this.secret = secret;
	}

	public String getSecret () {
	  return this.secret;
  }

  public String getId () {
	  return this.id;
  }

  public String toString () {
    return this.secret;
  }

  @Override
  public boolean equals (Object auxObj) {
    if (!(auxObj instanceof FrontEnd)) {
      return false;
    }

    FrontEnd auxFrontEnd = (FrontEnd) auxObj;

    return this.id.equals(auxFrontEnd.getId()) && this.secret.equals(auxFrontEnd.getSecret());
  }
}