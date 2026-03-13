package org.nahulemes.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.nahulemes.ui.LoginPage;
import org.nahulemes.util.TestData;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginAsAdmin implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.EMAIL_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(TestData.ADMIN_EMAIL).into(LoginPage.EMAIL_INPUT),
                Enter.theValue(TestData.ADMIN_PASSWORD).into(LoginPage.PASSWORD_INPUT),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }

    public static LoginAsAdmin withConfiguredCredentials() {
        return Tasks.instrumented(LoginAsAdmin.class);
    }
}
