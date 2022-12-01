package com.gustavostorb.auth.views.registro;

import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import javax.swing.*;
import java.util.stream.Stream;

public class RegistrationForm extends FormLayout {


    public RegistrationForm() {

        H1 title = new H1("REGISTRO");
        title.getStyle().set("font-weight", "bold");
        title.getStyle().set("text-align", "center");
        TextField user = new TextField("Usúario");
        user.setPrefixComponent(VaadinIcon.USER.create());
        EmailField email = new EmailField("Email");
        email.setPrefixComponent(VaadinIcon.ENVELOPE.create());
        Checkbox terms = new Checkbox("Termos e Condições Eu li e aceito");
        PasswordField password = new PasswordField("Senha");
        password.setPrefixComponent(VaadinIcon.LOCK.create());
        PasswordField passwordConfirm = new PasswordField("Confirmar senha");
        passwordConfirm.setPrefixComponent(VaadinIcon.LOCK.create());

        setRequiredIndicatorVisible(user, email, password, passwordConfirm);

        Span errorMessageField = new Span();

        Button submitButton = new Button("CADASTRAR");
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(title , user, email, password, passwordConfirm, terms, errorMessageField, submitButton);
        
        setMaxWidth("500px");
        setResponsiveSteps(
                new ResponsiveStep("0", 1),
                new ResponsiveStep("500px", 2));

        setColspan(title, 2);
        setColspan(user, 2);
        setColspan(email, 2);
        setColspan(terms, 2);
        setColspan(errorMessageField, 2);
        setColspan(submitButton, 2);

    }

    private void setRequiredIndicatorVisible(HasValueAndElement<?, ?>... components) {
        Stream.of(components).forEach(comp -> comp.setRequiredIndicatorVisible(true));
    }

}