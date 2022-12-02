package com.gustavostorb.auth.views.registro;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;

public class RegistrationFormBinder {

    private final RegistrationForm registrationForm;

    public RegistrationFormBinder(RegistrationForm registrationForm) {
        this.registrationForm = registrationForm;
    }

    public void registerUser() {

        registrationForm.getSubmitButton().addClickListener(event -> {
            Notification notification = Notification.show("Funcionou o botão");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        });
    }
}
