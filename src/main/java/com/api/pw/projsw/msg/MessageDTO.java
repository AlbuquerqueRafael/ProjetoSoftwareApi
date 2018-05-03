package com.api.pw.projsw.msg;

import java.time.LocalDateTime;

import com.api.pw.projsw.frontend.FrontEnd;

public class MessageDTO {

  private final static String INIT_URL = "http://150.165.85.16:9900/api/msgs/";
  private Long id;
  private String title;
  private String msg;
  private String author;
  private String url;
  private LocalDateTime created_at;
  private String frontend;

  protected MessageDTO () {
  }

  public MessageDTO (Long id, String title, String msg, String author, LocalDateTime created_at, 
                     FrontEnd frontend) {
    this.id = id;
    this.title = title;
    this.msg = msg;
    this.author = author;
    this.created_at = created_at;
    this.frontend = frontend.getId();
    this.url = INIT_URL + id;
  }

  public String getTitle () {
    return this.title;
  }

  public String getMsg () {
    return this.msg;
  }

  public String getAuthor () {
    return this.author;
  }

  public Long getId () {
    return this.id;
  }

  public LocalDateTime getCreated_At () {
    return this.created_at;
  }

  public String getFrontend () {
    return this.frontend;
  }

  public String getUrl () {
    return this.url;
  }

}