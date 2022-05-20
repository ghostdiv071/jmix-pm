package com.company.jmixpm.screen.requesttoorganisation;

import io.jmix.ui.screen.*;
import com.company.jmixpm.entity.RequestToOrganisation;

@UiController("RequestToOrganisation.browse")
@UiDescriptor("request-to-organisation-browse.xml")
@LookupComponent("requestToOrganisationsTable")
public class RequestToOrganisationBrowse extends StandardLookup<RequestToOrganisation> {
}