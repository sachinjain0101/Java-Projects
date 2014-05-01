package com.sacsoft.observer;
 
import java.util.ArrayList;
import java.util.List;
 
public class Blog implements Subject {
 
  List<Listener> listenersList;
  private boolean stateChange;
 
  public Blog() {
    this.listenersList = new ArrayList<Listener>();
    stateChange = false;
  }
 
  public void registerListener(Listener listener) {
    listenersList.add(listener);
  }
 
  public void unRegisterListener(Listener listener) {
    listenersList.remove(listener);
  }
 
  public void notifyListener() {
 
    if (stateChange) {
      for (Listener listener : listenersList) {
        listener.update();
      }
    }
  }
 
  public Object getUpdate() {
    Object changedState = null;
    // should have logic to send the
    // state change to querying listener
    if (stateChange) {
      changedState = "Listener Design Pattern";
    }
    return changedState;
  }
 
  public void postNewArticle() {
    stateChange = true;
    notifyListener();
  }

}
