package com.example.blytur.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.blytur.domain.casa.Casa;
import com.example.blytur.domain.casa.CasaService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@Component
public class CasaView extends VerticalLayout {

    @Autowired
    CasaService casaService;

    private Grid<Casa> grid = new Grid<>(Casa.class);

    public CasaView(CasaService casaService) {

        grid.setColumns("id", "endereco", "cep", "matricula");
        grid.setEmptyStateText("nenhuma casa cadastrada atualmente");
        grid.setItems(casaService.findAll());

        add(grid);
    }

}