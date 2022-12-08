package com.gustavostorb.auth.views.inicio;

import com.gustavostorb.auth.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Inicio")
@Route(value = "/home", layout = MainLayout.class)
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
