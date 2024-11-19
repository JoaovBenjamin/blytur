package com.example.blytur.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Route("/login")
public class LoginView extends VerticalLayout {

    public LoginView(@AuthenticationPrincipal OAuth2AuthenticationToken authentication) {
        if (authentication != null) {
            // O usuário já está autenticado com o GitHub
            String username = authentication.getPrincipal().getAttribute("login");

            Paragraph welcomeMessage = new Paragraph("Bem-vindo, " + username);
            Button logoutButton = new Button("Logout", e -> {
                getUI().ifPresent(ui -> ui.getPage().setLocation("/logout"));
            });

            add(welcomeMessage, logoutButton);
        } else {
            // Caso o usuário não esteja autenticado, exibe o botão de login
            Button loginButton = new Button("Login com GitHub", e -> {
                getUI().ifPresent(ui -> ui.getPage().setLocation("/oauth2/authorization/github"));
            });
            add(loginButton);
        }
    }
}
