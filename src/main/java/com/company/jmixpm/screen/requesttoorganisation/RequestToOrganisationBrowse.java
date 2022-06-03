package com.company.jmixpm.screen.requesttoorganisation;

import com.company.jmixpm.entity.RequestToOrganisation;
import io.jmix.ui.component.Table;
import io.jmix.ui.screen.*;

@UiController("RequestToOrganisation.browse")
@UiDescriptor("request-to-organisation-browse.xml")
@LookupComponent("requestToOrganisationsTable")
public class RequestToOrganisationBrowse extends StandardLookup<RequestToOrganisation> {

    @Subscribe("requestToOrganisationsTable.cancelled")
    public void onRequestToOrganisationsTableCancelledClick(Table.Column.ClickEvent<RequestToOrganisation> event) {
        event.getItem().setCancelled(true);
    }

}