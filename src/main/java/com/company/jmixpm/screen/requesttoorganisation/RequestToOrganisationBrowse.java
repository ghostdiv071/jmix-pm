package com.company.jmixpm.screen.requesttoorganisation;

import com.company.jmixpm.entity.RequestToOrganisation;
import io.jmix.core.DataManager;
import io.jmix.ui.component.Table;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("RequestToOrganisation.browse")
@UiDescriptor("request-to-organisation-browse.xml")
@LookupComponent("requestToOrganisationsTable")
public class RequestToOrganisationBrowse extends StandardLookup<RequestToOrganisation> {

    @Autowired
    private DataManager manager;

    @Subscribe("requestToOrganisationsTable.cancelled")
    public void onRequestToOrganisationsTableCancelledClick(Table.Column.ClickEvent<RequestToOrganisation> event) {
        var entity = event.getItem();
        entity.setCancelled(true);
        manager.save(entity);
    }

}