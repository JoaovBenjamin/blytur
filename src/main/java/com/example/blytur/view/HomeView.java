package com.example.blytur.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.blytur.chat.ChatService;
import com.example.blytur.domain.casa.CasaService;
import com.example.blytur.domain.leitura.LeituraService;
import com.example.blytur.domain.matricula.MatriculaService;
import com.example.blytur.domain.turbina.TurbinaService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.Route;

@Route("")
@Component
@Scope("prototype")

public class HomeView extends VerticalLayout {

    @Autowired
    MatriculaService matriculaService1;
    @Autowired
    ChatService chatService1;
    @Autowired
    TurbinaService turbinaService1;
    @Autowired
    CasaService casaService;
    @Autowired
    LeituraService leituraService;

    public HomeView(LeituraService leituraService,CasaService casaService,MatriculaService matriculaService, ChatService chatService, TurbinaService turbinaService) {

        add(new H1("Assistente Blytúr"));

        TabSheet tabSheet = new TabSheet();
        tabSheet.add("Chat", new ChatView(chatService));
        tabSheet.add("Matrículas", new TableView(matriculaService));
        tabSheet.add("Turbina", new TurbinaView(turbinaService));
        tabSheet.add("Casa", new CasaView(casaService));
        tabSheet.add("Leituras", new LeituraView(leituraService));

        tabSheet.setHeightFull();
        tabSheet.setWidthFull();

        setHeightFull();
        setWidthFull();

        add(tabSheet);
        this.chatService1 = chatService;
        this.matriculaService1 = matriculaService;
        this.turbinaService1 = turbinaService;
        this.casaService = casaService;
        this.leituraService=leituraService;
    }
}