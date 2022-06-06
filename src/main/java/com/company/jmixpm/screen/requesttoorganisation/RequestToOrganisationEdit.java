package com.company.jmixpm.screen.requesttoorganisation;

import com.company.jmixpm.entity.RequestToOrganisation;
import io.jmix.core.DataManager;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("RequestToOrganisation.edit")
@UiDescriptor("request-to-organisation-edit.xml")
@EditedEntityContainer("requestToOrganisationDc")
public class RequestToOrganisationEdit extends StandardEditor<RequestToOrganisation> {
    @Autowired
    private DataManager manager;

    @Subscribe
    public void onInitEntity(InitEntityEvent<RequestToOrganisation> event) {
        event.getEntity().setRequestNumber(
                manager.load(RequestToOrganisation.class)
                        .all().list().size() + 1);
    }

}