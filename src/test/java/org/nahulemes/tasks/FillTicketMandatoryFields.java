package org.nahulemes.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.nahulemes.ui.TicketFormPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillTicketMandatoryFields implements Task {

    private final String ticketTitle;
    private final String ticketDescription;

    public FillTicketMandatoryFields(String ticketTitle, String ticketDescription) {
        this.ticketTitle = ticketTitle;
        this.ticketDescription = ticketDescription;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TicketFormPage.TITLE_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(ticketTitle).into(TicketFormPage.TITLE_INPUT),
                Enter.theValue(ticketDescription).into(TicketFormPage.DESCRIPTION_TEXTAREA)
        );
    }

    public static FillTicketMandatoryFields with(String ticketTitle, String ticketDescription) {
        return Tasks.instrumented(FillTicketMandatoryFields.class, ticketTitle, ticketDescription);
    }
}
