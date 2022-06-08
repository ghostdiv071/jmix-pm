package com.company.jmixpm.screen.requesttoorganisation;

import com.company.jmixpm.entity.RequestToOrganisation;
import com.company.jmixpm.entity.User;
import io.jmix.core.DataManager;
import io.jmix.ui.Dialogs;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.Table;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@UiController("RequestToOrganisation.browse")
@UiDescriptor("request-to-organisation-browse.xml")
@LookupComponent("requestToOrganisationsTable")
public class RequestToOrganisationBrowse extends StandardLookup<RequestToOrganisation> {

    @Autowired
    private DataManager manager;

    @Autowired
    private Dialogs dialogs;

    @Subscribe("requestToOrganisationsTable.cancelled")
    public void onRequestToOrganisationsTableCancelledClick(Table.Column.ClickEvent<RequestToOrganisation> event) {
        var entity = event.getItem();
        entity.setCancelled(true);
        manager.save(entity);
    }

    @Subscribe("mailingListBtn")
    public void onMailingListBtnClick(Button.ClickEvent event) {
        var mailingList = manager.load(User.class)
                .query("select distinct u " +
                        "from User u " +
                        "join u.requestToOrganisations r ")
                .list()
                .stream()
                .map(User::getUsername)
                .collect(Collectors.toList());

        dialogs.createMessageDialog()
                .withCaption("Mailing List")
                .withMessage(String.valueOf(mailingList))
                .show();
    }

}