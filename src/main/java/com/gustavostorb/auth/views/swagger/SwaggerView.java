package com.gustavostorb.auth.views.swagger;

import com.gustavostorb.auth.views.MainLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.History;
import com.vaadin.flow.router.BeforeLeaveEvent;
import com.vaadin.flow.router.BeforeLeaveObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Swagger")
@Route(value = "/swagger-ui/index.html", layout = MainLayout.class)
public class SwaggerView extends VerticalLayout {

    public SwaggerView() {
        UI.getCurrent().setPollInterval(500);
        UI.getCurrent().addPollListener(event -> {
            UI.getCurrent().getPage().executeJs("window.location.reload()");
        });
        setSpacing(false);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }


}