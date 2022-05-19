package com.company.jmixpm.screen.organisation;

import io.jmix.ui.screen.*;
import com.company.jmixpm.entity.Organisation;

@UiController("Organisation.edit")
@UiDescriptor("organisation-edit.xml")
@EditedEntityContainer("organisationDc")
public class OrganisationEdit extends StandardEditor<Organisation> {
}