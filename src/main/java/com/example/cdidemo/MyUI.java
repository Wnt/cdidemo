package com.example.cdidemo;

import javax.inject.Inject;

import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@CDIUI("")
public class MyUI extends UI {

	@Inject
	private Greeting greeting;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();

		final TextField name = new TextField();
		name.setCaption("Type your name here:");

		Button button = new Button("Click Me");
		button.addClickListener(e -> {
			layout.addComponent(new Label(greeting.getText()));
		});

		layout.addComponents(name, button);

		setContent(layout);
	}
	// We donät need this as we'r using the CDI servlet
	// @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported =
	// true)
	// @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	// public static class MyUIServlet extends VaadinServlet {
	// }
}
