package com.example.blytur.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.blytur.domain.turbina.Turbina;
import com.example.blytur.domain.turbina.TurbinaService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@Component
public class TurbinaView extends VerticalLayout {

    @Autowired
    TurbinaService turbinaService;
    private Grid<Turbina> grid = new Grid<>(Turbina.class);

    public TurbinaView(TurbinaService turbinaService) {

        grid.setColumns("id", "versao", "capacidade");
        grid.setEmptyStateText("nenhuma turbina cadastrada");
        grid.setItems(turbinaService.findAll());

        add(grid);

    }

}