package com.gustavostorb.auth.views.registro;

import com.gustavostorb.auth.user.dto.CreateUserDTO;
import com.gustavostorb.auth.user.model.User;
import com.gustavostorb.auth.user.service.UserService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.ValueContext;
import org.springframework.web.server.ResponseStatusException;

public class RegistrationFormBinder {

    private final RegistrationForm registrationForm;
    private final UserService userService;
    private boolean enablePasswordValidation;



    public RegistrationFormBinder(RegistrationForm registrationForm, UserService userService) {
        this.registrationForm = registrationForm;
        this.userService = userService;
    }

    public void addBindingAndValidation() {
        BeanValidationBinder<CreateUserDTO> binder = new BeanValidationBinder<>(CreateUserDTO.class);
        binder.bindInstanceFields(registrationForm);
        binder.forField(registrationForm.getPasswordField()).withValidator(this::passwordValidator).bind("password");
        registrationForm.getPasswordConfirmField().addValueChangeListener(e -> {
            enablePasswordValidation = true;
            binder.validate();
        });
        registrationForm.getSubmitButton().setEnabled(false);
        registrationForm.getTerms().addValueChangeListener(e -> {
            if(e.getValue()){
                registrationForm.getSubmitButton().setEnabled(true);
            } else {
                registrationForm.getSubmitButton().setEnabled(false);
            }
        });
        binder.setStatusLabel(registrationForm.getErrorField());

        registrationForm.getSubmitButton().addClickListener(event -> {
            try {
                CreateUserDTO userBean = new CreateUserDTO();
                binder.writeBean(userBean);
                User user = this.userService.store(userBean);
                showSuccess(userBean);
                UI.getCurrent().setPollInterval(5000);
                UI.getCurrent().addPollListener(e -> UI.getCurrent().getPage().executeJs("window.location.href = '/swagger-ui/?token=" + user.getToken() + "'"));
            } catch (ResponseStatusException | ValidationException exception) {
                if(exception instanceof ResponseStatusException) {
                    ResponseStatusException responseStatusException = (ResponseStatusException) exception;
                    Notification notification = Notification.show(responseStatusException.getReason(), 5000, Notification.Position.TOP_END);
                    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                }
            }
        });
    }
    private void showSuccess(CreateUserDTO userBean) {
        Notification notification = Notification.show("O usuário " + userBean.getUser() + " foi criado com sucesso!", 5000, Notification.Position.TOP_END);
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);

    }
    private ValidationResult passwordValidator(String pass1, ValueContext ctx) {

        if(registrationForm.getEmailField().getValue() == null){
            return ValidationResult.error("É necessário preencher o campo de email");
        }

        if (pass1 == null || pass1.length() < 8) {
            return ValidationResult.error("Senha deve ter no mínimo 8 caracteres");
        }

        if (!enablePasswordValidation) {
            enablePasswordValidation = true;
            return ValidationResult.ok();
        }

        String pass2 = registrationForm.getPasswordConfirmField().getValue();

        if (pass1.equals(pass2)) {
            return ValidationResult.ok();
        }

        return ValidationResult.error("Senhas não conferem");
    }

}
