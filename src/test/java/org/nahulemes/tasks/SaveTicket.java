package org.nahulemes.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.nahulemes.ui.TicketFormPage;
import org.nahulemes.ui.TicketsPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SaveTicket implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TicketFormPage.SAVE_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(TicketFormPage.SAVE_BUTTON),
                WaitUntil.the(TicketsPage.TICKETS_GRID, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static SaveTicket now() {
        return Tasks.instrumented(SaveTicket.class);
    }
}
