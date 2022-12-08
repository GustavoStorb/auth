package com.gustavostorb.auth.views.inicio;

import com.gustavostorb.auth.user.repository.UserRepository;
import com.gustavostorb.auth.user.service.TokenService;
import com.gustavostorb.auth.user.service.UserService;
import com.gustavostorb.auth.views.MainLayout;
import com.gustavostorb.auth.views.registro.RegistrationForm;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;

@PageTitle("Inicio")
@Route(value = "", layout = MainLayout.class)
public class InicioView extends VerticalLayout {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    public InicioView() {
        addClassName("inicio-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(
                new H2("Bem vindo ao sistema"),
                new Paragraph("Para utilizar o sistema, você deve possuir uma token de autorização."),
                new Paragraph("Caso não possua uma conta, clique no botão abaixo para se registrar."),
                new Button("Registrar", e -> UI.getCurrent().navigate("register"))
        );
    }


}
