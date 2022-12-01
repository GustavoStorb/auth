package com.gustavostorb.auth.views.registro;

import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.stream.Stream;

public class RegistrationForm extends FormLayout {

    public RegistrationForm() {

        H3 title = new H3("REGISTRO");
        TextField user = new TextField("Usúario");
        EmailField email = new EmailField("Email");
        Checkbox terms = new Checkbox("Termos e Condições Eu li e aceito");
        PasswordField password = new PasswordField("Senha");
        PasswordField passwordConfirm = new PasswordField("Confirmar senha");

        setRequiredIndicatorVisible(user, email, password, passwordConfirm);

        Span errorMessageField = new Span();

        Button submitButton = new Button("CADASTRAR");
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(title, user, email, password, passwordConfirm, terms, errorMessageField, submitButton);
        
        setMaxWidth("500px");
        setResponsiveSteps(
                new ResponsiveStep("0", 1, ResponsiveStep.LabelsPosition.TOP),
                new ResponsiveStep("490px", 2, ResponsiveStep.LabelsPosition.TOP));

        setColspan(title, 2);
        setColspan(email, 2);
        setColspan(errorMessageField, 2);
        setColspan(submitButton, 2);
    }

    private void setRequiredIndicatorVisible(HasValueAndElement<?, ?>... components) {
        Stream.of(components).forEach(comp -> comp.setRequiredIndicatorVisible(true));
    }

}