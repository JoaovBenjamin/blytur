package com.example.blytur.view;

import com.example.blytur.domain.Matricula;
import com.example.blytur.domain.MatriculaService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TableView extends VerticalLayout {
    
    @Autowired
    MatriculaService matriculaService;
    private Grid<Matricula> grid = new Grid<>(Matricula.class);

    public TableView(MatriculaService matriculaService){

        grid.setColumns("id", "name", "status" );
        grid.setEmptyStateText("nenhuma matrícula cadastrada atualmente");
        grid.setItems(matriculaService.findAll());

        add(grid);
        this.matriculaService = matriculaService;
    }

}