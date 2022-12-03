package com.gustavostorb.auth.views.swagger;

import com.gustavostorb.auth.views.MainLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Swagger")
@Route(value = "swagger", layout = MainLayout.class)
public class SwaggerView extends VerticalLayout {

    public SwaggerView() {
        setSpacing(false);
        UI.getCurrent().getPage().executeJs("window.location.href = '/swagger-ui/'");
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }
}