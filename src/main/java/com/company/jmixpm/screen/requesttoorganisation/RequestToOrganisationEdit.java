package com.company.jmixpm.screen.requesttoorganisation;

import com.company.jmixpm.entity.RequestToOrganisation;
import io.jmix.core.DataManager;
import io.jmix.email.EmailException;
import io.jmix.email.EmailInfo;
import io.jmix.email.EmailInfoBuilder;
import io.jmix.email.Emailer;
import io.jmix.ui.Dialogs;
import io.jmix.ui.action.DialogAction;
import io.jmix.ui.component.Component;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nonnull;

@UiController("RequestToOrganisation.edit")
@UiDescriptor("request-to-organisation-edit.xml")
@EditedEntityContainer("requestToOrganisationDc")
public class RequestToOrganisationEdit extends StandardEditor<RequestToOrganisation> {
    @Autowired
    private DataManager manager;
    @Autowired
    private Dialogs dialogs;
    @Autowired
    private Emailer emailer;
    private boolean justCreated;

    private static final Logger log = LoggerFactory.getLogger(RequestToOrganisation.class);

    @Subscribe
    public void onInitEntity(InitEntityEvent<RequestToOrganisation> event) {
        event.getEntity().setRequestNumber(
                manager.load(RequestToOrganisation.class)
                        .all().list().size() + 1);
        justCreated = true;
    }

    @Subscribe(target = Target.DATA_CONTEXT)
    public void onPostCommit(DataContext.PostCommitEvent event) {
        if (justCreated) {
            dialogs.createOptionDialog()
                    .withCaption("Email")
                    .withMessage("Send the request by email?")
                    .withActions(
                            new DialogAction(DialogAction.Type.YES) {
                                @Override
                                public void actionPerform(@Nonnull Component component) {
                                    try {
                                        sendByEmail();
                                    } catch (EmailException e) {
                                        log.error(e.getMessage());
                                    }
                                }
                            },
                            new DialogAction(DialogAction.Type.NO)
                    )
                    .show();
        }
    }

    private void sendByEmail() throws EmailException {
        var entity = getEditedEntity();
        EmailInfo emailInfo = EmailInfoBuilder.create()
                .setAddresses("ghosttt322@icloud.com")
                .setSubject("Request to organisation №" + entity.getRequestNumber())
                .setFrom(null)
                .setBody(entity.getRequestText())
                .build();
        emailer.sendEmail(emailInfo);
    }


}