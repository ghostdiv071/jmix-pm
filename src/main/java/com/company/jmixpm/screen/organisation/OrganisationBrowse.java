package com.company.jmixpm.screen.organisation;

import io.jmix.ui.screen.*;
import com.company.jmixpm.entity.Organisation;

@UiController("Organisation.browse")
@UiDescriptor("organisation-browse.xml")
@LookupComponent("organisationsTable")
public class OrganisationBrowse extends StandardLookup<Organisation> {
}