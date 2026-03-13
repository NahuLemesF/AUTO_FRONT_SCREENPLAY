package org.nahulemes.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.nahulemes.ui.TicketsPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class OpenTicketCreationForm implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TicketsPage.CREATE_TICKET_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(TicketsPage.CREATE_TICKET_BUTTON)
        );
    }

    public static OpenTicketCreationForm now() {
        return Tasks.instrumented(OpenTicketCreationForm.class);
    }
}
