package com.api.pw.projsw.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.api.pw.projsw.frontend.FrontEnd;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table (name = "message")
public class Message implements Serializable {

  private static final long serialVersionUID = -1785131699037567362L;

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String msg;

  @Column(nullable = false)
  private String author;

  @CreatedDate
  @CreationTimestamp
  private LocalDateTime created_at;

  @ManyToOne
  private FrontEnd credentials;

  protected Message () {
  }

  public Message (String title, String msg, String author, LocalDateTime created_at, FrontEnd credentials) {
    this.title = title;
    this.msg = msg;
    this.author = author;
    this.created_at = created_at;
    this.credentials = credentials;
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

  public LocalDateTime getCreated_At (){
    return this.created_at;
  }

  public FrontEnd getCredentials () {
    return this.credentials;
  }

}