package com.gustavostorb.auth.views.inicio;

import com.gustavostorb.auth.user.model.User;
import com.gustavostorb.auth.user.service.UserService;
import com.gustavostorb.auth.views.MainLayout;
import com.gustavostorb.auth.views.registro.RegistrationFormBinder;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.awt.*;

@PageTitle("Inicio")
@Route(value = "", layout = MainLayout.class)
public class InicioView extends VerticalLayout {

    public InicioView() {
        setSpacing(false);
        add(new H2("Usuário: "));
        add(new Paragraph("Token: "));
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
