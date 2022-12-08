package com.gustavostorb.auth.views.registro;

import com.gustavostorb.auth.user.service.TokenService;
import com.gustavostorb.auth.user.service.UserService;
import com.gustavostorb.auth.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Sucesso")
@Route(value = "complete", layout = MainLayout.class)
public class CompleteView extends VerticalLayout {

    public CompleteView() {

        H2 h2 = new H2("Não perca suas credenciais de acesso!");
        H2 h3 = new H2("Token: ");

        setHorizontalComponentAlignment(Alignment.CENTER, h2);
        add(h2);



    }

}