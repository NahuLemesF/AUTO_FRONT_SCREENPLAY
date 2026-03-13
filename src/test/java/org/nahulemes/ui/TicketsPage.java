package org.nahulemes.ui;

import net.serenitybdd.screenplay.targets.Target;

public final class TicketsPage {

    public static final Target CREATE_TICKET_BUTTON =
            Target.the("boton crear ticket").locatedBy("//a[@href='/tickets/new']");

    public static final Target TICKETS_GRID =
            Target.the("panel de tickets").locatedBy("//div[contains(@class,'tickets-grid')]");

    private static final Target TICKET_BY_TITLE =
            Target.the("ticket con titulo {0}")
                    .locatedBy("//div[contains(@class,'tickets-grid')]//*[contains(normalize-space(),'{0}')]");

    private TicketsPage() {
    }

    public static Target ticketWithTitle(String ticketTitle) {
        return TICKET_BY_TITLE.of(ticketTitle);
    }
}
