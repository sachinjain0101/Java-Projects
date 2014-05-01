package com.sacsoft.observer;
 
public class ObserverDesignPattern {
  public static void main(String args[]) {
    Blog blog = new Blog();
    User user1 = new User();
    User user2 = new User();
    blog.registerListener(user1);
    blog.registerListener(user2);
    user1.setSubject(blog);
    user2.setSubject(blog);
   
    System.out.println(user1.getArticle());   
    blog.postNewArticle();
    System.out.println(user1.getArticle());
  }
 
}