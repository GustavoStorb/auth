package com.gustavostorb.auth.views.registro;

import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;


import java.util.stream.Stream;

public class RegistrationForm extends FormLayout {

    private final H1 title = new H1("REGISTRO");
    private final TextField user = new TextField("Usúario");
    private final EmailField email = new EmailField("Email");
    private final PasswordField password = new PasswordField("Senha");
    private final PasswordField passwordConfirm = new PasswordField("Confirmar senha");
    private final Checkbox terms = new Checkbox("Termos e Condições Eu li e aceito");
    private final Span error = new Span();
    private final Button submitButton = new Button("CADASTRAR");
    private final Image img = new Image("images/user.png", "placeholder user");

    public RegistrationForm() {

        title.getStyle().set("margin-bottom","auto");
        title.getStyle().set("font-size", "8vh");;
        title.getStyle().set("font-weight", "bold");
        title.getStyle().set("padding-left", "3vh");
        title.getStyle().set("justify-content", "start");
        img.getStyle().set("padding-left", "43vh");
        img.getStyle().set("margin-top", "120px");
        img.getStyle().set("position", "absolute");
        img.getStyle().set("filter", "invert(100%) sepia(100%) saturate(0%) hue-rotate(233deg) brightness(102%) contrast(101%)");
        img.setMaxWidth("50px");
        img.getStyle().set("justify-content", "end");
        user.setPrefixComponent(VaadinIcon.USER.create());
        email.setPrefixComponent(VaadinIcon.ENVELOPE.create());
        password.setPrefixComponent(VaadinIcon.LOCK.create());
        passwordConfirm.setPrefixComponent(VaadinIcon.LOCK.create());
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        setRequiredIndicatorVisible(user, email, password, passwordConfirm);
        add(title, img , user, email, password, passwordConfirm, terms, error, submitButton);
        
        setMaxWidth("500px");
        setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("500px", 2));

        setColspan(title, 2);
        setColspan(user, 2);
        setColspan(email, 2);
        setColspan(terms, 2);
        setColspan(error, 2);
        setColspan(submitButton, 2);

    }

    public void testButton(){
        getSubmitButton().addClickListener(event -> {
            System.out.println("Teste");
        });
    }
    public TextField getUserField() { return user; }
    public PasswordField getPasswordField() { return password; }
    public PasswordField getPasswordConfirmField() { return passwordConfirm; }

    public EmailField getEmailField() { return email; }
    public Span getErrorField() { return error; }
    public Button getSubmitButton() { return submitButton; }

    private void setRequiredIndicatorVisible(HasValueAndElement<?, ?>... components) {
        Stream.of(components).forEach(comp -> comp.setRequiredIndicatorVisible(true));
    }

}