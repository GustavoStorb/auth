package com.gustavostorb.auth.views.registro;

import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.stream.Stream;

public class RegistrationForm extends FormLayout {

    @Id("username")
    private final TextField username = new TextField("Usúario");

    @Id("email")
    private final EmailField email = new EmailField("Email");

    @Id("password")
    private final PasswordField password = new PasswordField("Senha");

    private final PasswordField passwordConfirm = new PasswordField("Confirmar senha");
    private final Checkbox terms = new Checkbox("Termos e Condições Eu li e aceito");
    private final Span error = new Span();
    private final Button submitButton = new Button("CADASTRO");

    public RegistrationForm() {

        H1 title = new H1("REGISTRO");
        title.getStyle().set("margin-bottom","auto");
        title.getStyle().set("font-size", "8vh");;
        title.getStyle().set("font-weight", "bold");
        title.getStyle().set("padding-left", "3vh");
        title.getStyle().set("justify-content", "start");
        Image img = new Image("images/user.png", "placeholder user");
        img.getStyle().set("padding-left", "43vh");
        img.getStyle().set("margin-top", "13vh");
        img.getStyle().set("position", "absolute");
        img.getStyle().set("filter", "invert(100%) sepia(100%) saturate(0%) hue-rotate(233deg) brightness(102%) contrast(101%)");
        img.setMaxWidth("5.3vh");
        img.getStyle().set("justify-content", "end");
        username.getElement().setAttribute("autocomplete", "off");
        email.getElement().setAttribute("autocomplete", "off");
        username.setPrefixComponent(VaadinIcon.USER.create());
        email.setPrefixComponent(VaadinIcon.ENVELOPE.create());
        password.setPrefixComponent(VaadinIcon.LOCK.create());
        passwordConfirm.setPrefixComponent(VaadinIcon.LOCK.create());
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        setRequiredIndicatorVisible(username, email, password, passwordConfirm);
        add(title, img, username, email, password, passwordConfirm, terms, error, submitButton);
        
        setMaxWidth("500px");
        setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("500px", 2));

        setColspan(title, 2);
        setColspan(username, 2);
        setColspan(email, 2);
        setColspan(terms, 2);
        setColspan(error, 2);
        setColspan(submitButton, 2);

    }

    public PasswordField getPasswordField() { return password; }
    public PasswordField getPasswordConfirmField() { return passwordConfirm; }
    public EmailField getEmailField() { return email; }
    public Span getErrorField() { return error; }
    public Button getSubmitButton() { return submitButton; }
    public Checkbox getTerms() { return terms; }
    public TextField getUsername() { return username; }

    private void setRequiredIndicatorVisible(HasValueAndElement<?, ?>... components) {
        Stream.of(components).forEach(comp -> comp.setRequiredIndicatorVisible(true));
    }

}