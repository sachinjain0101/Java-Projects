package com.sacsoft.observer;
 
public class User implements Listener {
 
  private String article;
  private Subject blog;
 
  public void setSubject(Subject blog) {
    this.blog = blog;
    article = "No New Article!";
  }
 
  public void update() {
    System.out.println("State change reported by Subject.");
    article = (String) blog.getUpdate();
  }
 
  public String getArticle() {
    return article;
  }
}