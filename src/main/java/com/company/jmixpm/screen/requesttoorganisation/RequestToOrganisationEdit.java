package com.company.jmixpm.screen.requesttoorganisation;

import io.jmix.ui.screen.*;
import com.company.jmixpm.entity.RequestToOrganisation;

@UiController("RequestToOrganisation.edit")
@UiDescriptor("request-to-organisation-edit.xml")
@EditedEntityContainer("requestToOrganisationDc")
public class RequestToOrganisationEdit extends StandardEditor<RequestToOrganisation> {
}