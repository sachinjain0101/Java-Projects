package com.sacsoft.test_app;

import org.hibernate.Session;

import com.vaadin.Application;
import com.vaadin.data.hbnutil.HbnContainer.SessionManager;
import com.vaadin.service.ApplicationContext.TransactionListener;
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
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class TestApp extends Application implements SessionManager{
	private Window window;
	private VerticalLayout vLayout;
	private HorizontalLayout hLayout;

	private TabSheet tabSheet;

	private Panel buttonPanel;
	private Panel messagePanel;

	private Button clearMe;

	@Override
	public void init() {
		setTheme("runo");
		getContext().addTransactionListener(new TransactionListener() {
			
			public void transactionStart(Application application, Object transactionData) {
				// TODO Auto-generated method stub
				
			}
			
			public void transactionEnd(Application application, Object transactionData) {
				if(application == TestApp.this){
					//closeSession();
				}
				
			}
		});
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
		hLayout.setSizeUndefined();
		HorizontalLayout dummy = new HorizontalLayout();
		
		tabSheet.addTab(hLayout, "HL1");
		tabSheet.addTab(dummy, "HL2");
		// vLayout.addComponent(hLayout);
		// hLayout.setMargin(true);

		VerticalSplitPanel vSplitPanel  = new VerticalSplitPanel();
		
		Panel mainPanel = new Panel("Main Panel");
		mainPanel.setContent(vSplitPanel);

		Tree tree = new Tree("Test Tree");
		tree.setSizeFull();
		String name = "Sachin Jain";
		tree.addItem(name);
		vSplitPanel.setFirstComponent(tree);
		
		buttonPanel = new Panel("Button Panel");
		buttonPanel.setSizeFull();
		Button button = new Button("Click Me");
		buttonPanel.addComponent(button);

		vSplitPanel.setSecondComponent(buttonPanel);
		
		button.addListener(new Button.ClickListener() {
			int counter = 0;
			public void buttonClick(ClickEvent event) {
				counter++;
				messagePanel.addComponent(new Label("Thank you for clicking : "+counter));
			}
		});
		
		
		
		messagePanel = new Panel("Message Panel");
		//panel2.setSizeFull();
		clearMe = new Button("Clear Me");
		messagePanel.addComponent(clearMe);
		messagePanel.setScrollable(true);
		messagePanel.setScrollTop(200);
		messagePanel.setSizeUndefined();
		//panel2.getContent().setHeight(200, Sizeable.UNITS_PIXELS);
		vLayout.addComponent(messagePanel);


		window.setContent(vLayout);
		//window.getContent().setSizeFull();

		clearMe.addListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				messagePanel.removeAllComponents();
				messagePanel.addComponent(clearMe);
			}
		});

	}

	public Session getSession() {
		Session currentSession =
	}

}
