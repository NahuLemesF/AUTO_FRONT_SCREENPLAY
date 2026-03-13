package org.nahulemes.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import org.nahulemes.ui.TicketsPage;

public class IsTicketsPanelVisible implements Question<Boolean> {

    public static IsTicketsPanelVisible now() {
        return new IsTicketsPanelVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(TicketsPage.TICKETS_GRID).answeredBy(actor);
    }
}
