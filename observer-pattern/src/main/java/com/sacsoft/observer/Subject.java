package com.sacsoft.observer;
 
public interface Subject {
 
  public void registerListener(Listener listener);
 
  public void notifyListener();
 
  public void unRegisterListener(Listener listener);
 
  public Object getUpdate();
 
}

