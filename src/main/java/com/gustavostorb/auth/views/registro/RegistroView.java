package com.gustavostorb.auth.views.registro;

import com.gustavostorb.auth.user.service.UserService;
import com.gustavostorb.auth.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Registro")
@Route(value = "register", layout = MainLayout.class)
public class RegistroView extends VerticalLayout {

    public RegistroView(UserService userService) {

        RegistrationForm registrationForm = new RegistrationForm();
        setHorizontalComponentAlignment(Alignment.CENTER, registrationForm);

        add(registrationForm);

        RegistrationFormBinder registrationFormBinder = new RegistrationFormBinder(registrationForm, userService);
        registrationFormBinder.addBindingAndValidation();
    }

}
