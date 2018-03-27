package com.timeline.model.DTO;

public class DetailReplyDTO {
  private Integer ID;

  private Integer DetailID;

  private String Title;

  private String Content;

  private Integer AuthorID;

  public Integer getID() {
    return ID;
  }

  public void setID(Integer ID) {
    this.ID = ID;
  }

  public Integer getDetailID() {
    return DetailID;
  }

  public void setDetailID(Integer detailID) {
    DetailID = detailID;
  }

  public String getTitle() {
    return Title;
  }

  public void setTitle(String title) {
    Title = title;
  }

  public String getContent() {
    return Content;
  }

  public void setContent(String content) {
    Content = content;
  }

  public Integer getAuthorID() {
    return AuthorID;
  }

  public void setAuthorID(Integer authorID) {
    AuthorID = authorID;
  }
}