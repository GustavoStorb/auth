package com.gustavostorb.auth.views.swagger;

import com.gustavostorb.auth.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Swagger")
@Route(value = "swagger", layout = MainLayout.class)
public class SwaggerView extends VerticalLayout {

    public SwaggerView() {
        setSpacing(false);


        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
