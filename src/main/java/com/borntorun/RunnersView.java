package com.borntorun;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringComponent
@UIScope
@Route("runners")
public class RunnersView extends VerticalLayout {

    private final RunnerService runnerService;

    private final Grid<Runner> grid;

    @Autowired
    public RunnersView(RunnerService runnerService) {
        this.runnerService = runnerService;

        grid = new Grid<>(Runner.class);
        grid.setColumns("name", "age", "gender", "active");

        List<Runner> runners = runnerService.getAllRunners();

        grid.setItems(runners);

        add(grid);
    }
}
