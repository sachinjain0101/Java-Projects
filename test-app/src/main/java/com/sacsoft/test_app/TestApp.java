/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.sacsoft.test_app;

import com.vaadin.Application;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class TestApp extends Application {
	private Window window;
	private VerticalLayout vLayout;
	private HorizontalLayout hLayout;

	private TabSheet tabSheet;

	private Panel panel1;
	private Panel panel2;

	private Button clearMe;

	@Override
	public void init() {
		setTheme("runo");
		window = new Window("TestApp - SaCsOfT");
		setMainWindow(window);
		
		

		window.setTheme(getTheme());

		vLayout = new VerticalLayout();
		vLayout.setSizeFull();
		Label label = new Label("TestApp - SaCsOfT");
		label.setHeight(10,Sizeable.UNITS_PIXELS);
		label.setWidth(null);
		//vLayout.addComponent(label);
		
		GridLayout grid = new GridLayout(4, 4);
		
		for(int i=0;i<grid.getRows();i++){
			for(int j=0;j<grid.getColumns();j++){
				grid.addComponent(new TextField(i+","+j), i, j);
			}	
		}
		
		vLayout.addComponent(grid);
		
		tabSheet = new TabSheet();
		vLayout.addComponent(tabSheet);

		hLayout = new HorizontalLayout();
		hLayout.setSizeFull();
		HorizontalLayout dummy = new HorizontalLayout();
		tabSheet.addTab(hLayout, "HL1");
		tabSheet.addTab(dummy, "HL2");
		// vLayout.addComponent(hLayout);
		// hLayout.setMargin(true);

		panel1 = new Panel("Button Panel");
		panel1.setSizeFull();
		panel2 = new Panel("Message Panel");
		panel2.setSizeFull();

		Button button = new Button("Click Me");
		panel1.addComponent(button);
		hLayout.addComponent(panel1);

		clearMe = new Button("Clear Me");
		panel2.addComponent(clearMe);

		hLayout.addComponent(panel2);

		Tree tree = new Tree("Test Tree");
		tree.setSizeFull();
		String name = "Sachin Jain";
		tree.addItem(name);
		hLayout.addComponent(tree);

		button.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				panel2.addComponent(new Label("Thank you for clicking"));
			}
		});

		window.setContent(vLayout);
		//window.getContent().setSizeFull();

		clearMe.addListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				panel2.removeAllComponents();
				panel2.addComponent(clearMe);
			}
		});

	}

}
