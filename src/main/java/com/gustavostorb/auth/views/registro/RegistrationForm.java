package com.gustavostorb.auth.views.registro;

import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.stream.Stream;

public class RegistrationForm extends FormLayout {

    @Id("username")
    private final TextField username = new TextField("Usúario");

    @Id("email")
    private final EmailField email = new EmailField("Email");

    @Id("password")
    private final PasswordField password = new PasswordField("Senha");

    private final PasswordField passwordConfirm = new PasswordField("Confirmar senha");
    private final Checkbox checkbox = new Checkbox();
    private final Span terms = new Span("Termos e Condições Eu li e aceito");
    private final Span error = new Span();
    private final Button submitButton = new Button("CADASTRO");
    private final Dialog dialog = new Dialog();



    public RegistrationForm() {

        H1 title = new H1("REGISTRO");
        title.getStyle().set("margin-bottom","auto");
        title.getStyle().set("font-size", "8vh");;
        title.getStyle().set("font-weight", "bold");
        title.getStyle().set("padding-left", "3vh");
        title.getStyle().set("justify-content", "start");
        Image img = new Image("images/user.png", "placeholder user");
        img.getStyle().set("padding-left", "43vh");
        img.getStyle().set("margin-top", "13vh");
        img.getStyle().set("position", "absolute");
        img.getStyle().set("filter", "invert(100%) sepia(100%) saturate(0%) hue-rotate(233deg) brightness(102%) contrast(101%)");
        img.setMaxWidth("5.3vh");
        img.getStyle().set("justify-content", "end");
        username.getElement().setAttribute("autocomplete", "off");
        email.getElement().setAttribute("autocomplete", "off");
        username.setPrefixComponent(VaadinIcon.USER.create());
        email.setPrefixComponent(VaadinIcon.ENVELOPE.create());
        password.setPrefixComponent(VaadinIcon.LOCK.create());
        passwordConfirm.setPrefixComponent(VaadinIcon.LOCK.create());
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        dialog.getElement().setAttribute("aria-label",
                "System maintenance hint");

        VerticalLayout dialogLayout = createDialogLayout(dialog);
        dialog.add(dialogLayout);

        setRequiredIndicatorVisible(username, email, password, passwordConfirm);
        HorizontalLayout horizontalLayout = new HorizontalLayout(checkbox, terms);
        horizontalLayout.setMaxWidth("100%");
        add(title, img, username, email, password, passwordConfirm, horizontalLayout, error, submitButton);
        terms.addClickListener(e -> dialog.open());
        
        setMaxWidth("500px");
        setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("500px", 2));

        setColspan(title, 2);
        setColspan(username, 2);
        setColspan(email, 2);
        setColspan(horizontalLayout, 2);
        setColspan(error, 2);
        setColspan(submitButton, 2);

    }

    public PasswordField getPasswordField() { return password; }
    public PasswordField getPasswordConfirmField() { return passwordConfirm; }
    public EmailField getEmailField() { return email; }
    public Span getErrorField() { return error; }
    public Button getSubmitButton() { return submitButton; }
    public Checkbox getTerms() { return checkbox; }
    public TextField getUsername() { return username; }

    private void setRequiredIndicatorVisible(HasValueAndElement<?, ?>... components) {
        Stream.of(components).forEach(comp -> comp.setRequiredIndicatorVisible(true));
    }

    private static VerticalLayout createDialogLayout(Dialog dialog) {
        H2 headline = new H2("Termo de Consentimento");
        headline.getStyle().set("margin", "var(--lumo-space-m) 0")
                .set("font-size", "1.5em").set("font-weight", "bold");

        Paragraph paragraph = new Paragraph("O presente \"Termo de Consentimento\" visa registrar a manifestação livre e inequívoca pela\n" +
                "qual o Titular concorda com o tratamento dos seus dados pessoais para a finalidade\n" +
                "específica, em conformidade com a Lei no 13.709 – Lei Geral de Proteção de Dados Pessoais\n" +
                "(LGPD)\n" +
                "Ao manifestar a sua aceitação ao presente termo, o Titular consente e concorda que a <aqui\n" +
                "colocar os dados a qualificação da empresa Eleição Justa em SENAI Florianópolis (CTAI), cep\n" +
                "88032-005. doravante denominada Controladora, tome decisões referentes ao tratamento\n" +
                "dos seus dados pessoais abaixo descritos, necessários à prestação dos serviços ofertados\n" +
                "envolvendo operações como as que se refere à coleta, vamos realizar o controle de\n" +
                "informação dos usuários e seu armazenamento no nosso sistema.\n" +
                "Para fins deste Termo de Consentimento, aplicam-se também as seguintes definições:\n" +
                "• Sites: qualquer página da web sob o domínio da Controladora;\n" +
                "• Cookies: arquivos enviados pelo servidor do site para o computador do Usuário, com a\n" +
                "finalidade de identificar o computador e obter dados de acesso, como páginas navegadas\n" +
                "ou links clicados, permitindo, desta forma,\n" +
                "personalizar a utilização do site, de acordo com o seu perfil;\n" +
                "• IP: abreviatura de Internet Protocol. É um conjunto de números que identifica o\n" +
                "computador do Usuário na Internet;\n" +
                "• Logs: registros de atividades do Usuário efetuadas no site;\n" +
                "• Session ID: identificação da sessão do Usuário no processo de inscrição ou quando\n" +
                "utilizado de alguma forma o site;\n" +
                "• Usuário: todo aquele que passar a usar o site;\n" +
                "• Sistemas: sites e/ou programas de computador que a Controladora utiliza para realizar\n" +
                "seus processos seletivos e de matrícula.\n" +
                "\n" +
                "Obtenção dos dados e informações\n" +
                "Os dados e as informações serão obtidos quando o Usuário:\n" +
                "1. Passar a utilizar o sistema\n" +
                "2. Fazer o cadastro e logar no sistema\n" +
                "\n" +
                "Armazenamento dos Dados e das Informações: todos os dados e todas as informações\n" +
                "coletadas dos Usuários serão incorporados ao banco de dados da Controladora, sendo esta\n" +
                "sua responsável e proprietária. Os dados e as informações coletadas estarão armazenados\n" +
                "em ambiente seguro, observado o estado da técnica disponível, e somente poderão ser\n" +
                "acessados por pessoas qualificadas e autorizadas pela Controladora. Além disso, a\n" +
                "Controladora afirma que não compartilhará, venderá ou apresentará os dados dos Usuários\n" +
                "para terceiros que não sejam seus parceiros diretamente envolvidos em seus processos com\n" +
                "as finalidades neste termo apresentadas.\n" +
                "O Usuário é o proprietário dos dados e está apto a adicionar, excluir ou modificar quaisquer\n" +
                "informações que estiverem ligadas ao seu perfil de usuário no sistema da Controladora. Por\n" +
                "isso, o Usuário declara estar ciente e concorda com a coleta, o armazenamento,\n" +
                "tratamento, processamento e uso das Informações enviadas e/ou transmitidas pelo Usuário\n" +
                "nos termos estabelecidos neste Termo de Consentimento.\n" +
                "\n" +
                "Finalidades do Tratamento dos Dados\n" +
                "\n" +
                "O tratamento dos dados pessoais listados neste termo possui as seguintes finalidades:\n" +
                "A empresa Eleição justa tem como finalidade efetuar efetuar qualquer comunicação\n" +
                "resultante de atividade do próprio sistema ou a identificação do respectivo destinatário;\n" +
                "Dados Pessoais\n" +
                "\n" +
                "A Controladora fica autorizada a tomar decisões referentes ao tratamento e a realizar o\n" +
                "tratamento dos seguintes dados pessoais do Titular:\n" +
                "• Usuário;\n" +
                "• E-mail;\n" +
                "• Senha;\n" +
                "\n" +
                "Compartilhamento de Dados\n" +
                "A Controladora fica autorizada a compartilhar os dados pessoais do Titular com\n" +
                "outros agentes de tratamento de dados, caso seja necessário para as finalidades\n" +
                "listadas neste termo, observados os princípios e as garantias estabelecidas pela Lei\n" +
                "no 13.709.\n" +
                "\n" +
                "Segurança dos Dados\n" +
                "A Controladora responsabiliza-se pela manutenção de medidas de segurança,\n" +
                "técnicas e administrativas aptas a proteger os dados pessoais de acessos não\n" +
                "autorizados e de situações acidentais ou ilícitas de destruição, perda, alteração,\n" +
                "comunicação ou qualquer forma de tratamento inadequado ou ilícito.\n" +
                "Em conformidade ao art. 48 da Lei no 13.709, o Controlador comunicará ao Titular e\n" +
                "à Autoridade Nacional de Proteção de Dados (ANPD) a ocorrência de incidente de\n" +
                "segurança que possa acarretar risco ou dano relevante ao Titular.\n" +
                "\n" +
                "Término do Tratamento dos Dados\n" +
                "\n" +
                "A Controladora poderá manter e tratar os dados pessoais do Titular durante todo o período\n" +
                "em que os mesmos forem pertinentes ao alcance das finalidades listadas neste termo. Dados\n" +
                "pessoais anonimizados, sem possibilidade de associação ao indivíduo, poderão ser mantidos\n" +
                "por período indefinido.\n" +
                "O Titular poderá solicitar via e-mail ou correspondência à Controladora, a qualquer\n" +
                "momento, que sejam eliminados os dados pessoais não anonimizados do Titular. O Titular\n" +
                "fica ciente de que poderá ser inviável à Controladora continuar o fornecimento de produtos\n" +
                "ou serviços ao Titular a partir da eliminação dos dados pessoais.\n" +
                "Direitos do Titular\n" +
                "\n" +
                "O Titular tem direito a obter da Controladora, em relação aos dados por ele tratados, a\n" +
                "qualquer momento e mediante requisição: I – confirmação da existência de tratamento; II –\n" +
                "acesso aos dados; III – correção de dados incompletos, inexatos ou desatualizados; IV –\n" +
                "anonimização, bloqueio ou eliminação de dados desnecessários, excessivos ou tratados em\n" +
                "\n" +
                "desconformidade com o disposto na Lei no 13.709; V – portabilidade dos dados a outro\n" +
                "fornecedor de serviço ou produto, mediante requisição expressa e observados os segredos\n" +
                "comercial e industrial, de acordo com a regulamentação do órgão controlador; VI –\n" +
                "eliminação dos dados pessoais tratados com o consentimento do Titular, exceto nas\n" +
                "hipóteses previstas no art. 16 da Lei no 13.709; VII – informação das entidades públicas e\n" +
                "privadas com as quais a Controladora realizou uso compartilhado de dados; VIII – informação\n" +
                "sobre a possibilidade de não fornecer consentimento e sobre as consequências da negativa;\n" +
                "IX – revogação do consentimento, nos termos do § 5o do art. 8o da Lei no 13.709.\n" +
                "Direito de Revogação do Consentimento\n" +
                "Este consentimento poderá ser revogado pelo usuário, a qualquer momento, por duas\n" +
                "formas de solicitação:\n" +
                "1. E-mail: eleicao_justa@gmail.com.br\n" +
                "2. Correspondência ao controlador – SENAI Florianópolis (CTAI)");
        Button closeButton = new Button("Close");
        closeButton.addClickListener(e -> dialog.close());

        VerticalLayout dialogLayout = new VerticalLayout(headline, paragraph,
                closeButton);
        dialogLayout.setPadding(false);
        dialogLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        dialogLayout.getStyle().set("width", "500px").set("max-width", "100%");
        dialogLayout.setAlignSelf(FlexComponent.Alignment.CENTER, closeButton);
        dialogLayout.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        return dialogLayout;
    }

}