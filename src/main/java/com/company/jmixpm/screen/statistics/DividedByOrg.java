package com.company.jmixpm.screen.statistics;

import io.jmix.charts.component.PieChart;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

@UiController("DividedByOrg")
@UiDescriptor("divided-by-org.xml")
public class DividedByOrg extends Screen {

//    @Autowired
//    private PieChart chart;
//
//    @Autowired
//    private EntityManager manager;
//
//    @Subscribe
//    public void onInit(InitEvent event) {
//        var query = manager.createQuery(
//                "select Organisation.name, count(RequestToOrganisation.organisation)" +
//                "from RequestToOrganisation" +
//                "join Organisation on Organisation.id = RequestToOrganisation .organisation" +
//                "group by Organisation.name");
//        var dataProvider = new ;
//    }

}
