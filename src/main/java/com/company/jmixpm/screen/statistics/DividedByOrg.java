package com.company.jmixpm.screen.statistics;

import io.jmix.charts.component.PieChart;
import io.jmix.core.DataManager;
import io.jmix.core.entity.KeyValueEntity;
import io.jmix.ui.data.impl.ListDataProvider;
import io.jmix.ui.data.impl.MapDataItem;
import io.jmix.ui.data.impl.SimpleDataItem;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@UiController("DividedByOrganisation")
@UiDescriptor("divided-by-org.xml")
public class DividedByOrg extends Screen {

    @Autowired
    private PieChart pie3dChart;

    @Autowired
    private DataManager dataManager;

    @Subscribe
    public void onInit(InitEvent event) {
        ListDataProvider provider = new ListDataProvider();
        List<MapDataItem> items = new ArrayList<>();
        for (KeyValueEntity value : loadData()) {
            items.add(new MapDataItem(Map.of(value.getValue("name"), value.getValue("count"))));
        }
        provider.addItems(items);
        pie3dChart.setDataProvider(provider);
    }

    List<KeyValueEntity> loadData() {
        return dataManager.loadValues("select o.name, count(r.organisation) " +
                        "from RequestToOrganisation r " +
                        "join Organisation o " +
                        "group by o.name")
                .properties("name", "count")
                .list();
    }

    static class Value {
        private final String name;
        private final Integer count;

        public Value(String name, Integer count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public Integer getCount() {
            return count;
        }
    }
}
