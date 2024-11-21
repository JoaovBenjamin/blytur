package com.example.blytur.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.blytur.domain.leitura.Leitura;
import com.example.blytur.domain.leitura.LeituraService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@Component
public class LeituraView extends VerticalLayout {

    @Autowired
    LeituraService leituraService;

    private Grid<Leitura> grid = new Grid<>(Leitura.class);

    public LeituraView(LeituraService leituraService) {

        grid.setColumns("id", "turbina", "producao");
        grid.setEmptyStateText("nenhuma leitura cadastrada atualmente");
        grid.setItems(leituraService.findAll());

        add(grid);
    }

}