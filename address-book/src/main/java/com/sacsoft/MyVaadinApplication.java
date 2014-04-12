package com.sacsoft;

import com.vaadin.Application;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class MyVaadinApplication extends Application
{
	private static final long serialVersionUID = 1L;

    @Override
    public void init()
    {
    	buildMainLayout();
    }

	private void buildMainLayout() {
		setMainWindow(new Window("Address Book Application"));
		VerticalLayout vLayout = new VerticalLayout();
		vLayout.setSizeFull();
		
	}
    
    
}
