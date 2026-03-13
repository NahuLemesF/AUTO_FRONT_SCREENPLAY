package org.nahulemes.ui;

import net.serenitybdd.screenplay.targets.Target;

public final class TicketFormPage {

    public static final Target TITLE_INPUT =
            Target.the("campo titulo del ticket").locatedBy("//*[@id='ticket-title']");

    public static final Target DESCRIPTION_TEXTAREA =
            Target.the("campo descripcion del ticket").locatedBy("//*[@id='ticket-description']");

    public static final Target SAVE_BUTTON =
            Target.the("boton guardar ticket").locatedBy("//*[contains(@class,'form-button')]");

    private TicketFormPage() {
    }
}
