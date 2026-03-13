package org.nahulemes.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import org.nahulemes.ui.TicketsPage;

public class IsTicketVisibleInList implements Question<Boolean> {

    private final String ticketTitle;

    public IsTicketVisibleInList(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    public static IsTicketVisibleInList called(String ticketTitle) {
        return new IsTicketVisibleInList(ticketTitle);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(TicketsPage.ticketWithTitle(ticketTitle)).answeredBy(actor);
    }
}
