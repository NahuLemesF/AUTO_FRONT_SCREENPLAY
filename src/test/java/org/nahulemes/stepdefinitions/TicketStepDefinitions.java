package org.nahulemes.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.nahulemes.hooks.OpenBrowser;
import org.nahulemes.questions.IsTicketVisibleInList;
import org.nahulemes.questions.IsTicketsPanelVisible;
import org.nahulemes.tasks.FillTicketMandatoryFields;
import org.nahulemes.tasks.LoginAsAdmin;
import org.nahulemes.tasks.OpenTicketCreationForm;
import org.nahulemes.tasks.SaveTicket;
import org.nahulemes.ui.TicketsPage;
import org.nahulemes.util.TestData;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TicketStepDefinitions {

    private String ticketTitle;
    private String ticketDescription;

    @Dado("que el administrador abre la aplicación")
    public void queElAdministradorAbreLaAplicacion() {
        OnStage.theActorCalled("Administrador").attemptsTo(
                OpenBrowser.withUrl(TestData.BASE_URL)
        );
    }

    @Y("inicia sesión con credenciales válidas")
    public void iniciaSesionConCredencialesValidas() {
        OnStage.theActorInTheSpotlight().attemptsTo(LoginAsAdmin.withConfiguredCredentials());
    }

    @Cuando("navega al formulario de creación de ticket")
    public void navegaAlFormularioDeCreacionDeTicket() {
        OnStage.theActorInTheSpotlight().attemptsTo(OpenTicketCreationForm.now());
    }

    @Y("completa los campos obligatorios del ticket")
    public void completaLosCamposObligatoriosDelTicket() {
        ticketTitle = TestData.uniqueTicketTitle();
        ticketDescription = TestData.descriptionFor(ticketTitle);

        OnStage.theActorInTheSpotlight().attemptsTo(
                FillTicketMandatoryFields.with(ticketTitle, ticketDescription)
        );
    }

    @Y("guarda el ticket")
    public void guardaElTicket() {
        OnStage.theActorInTheSpotlight().attemptsTo(SaveTicket.now());
    }

    @Entonces("debe regresar al panel de tickets")
    public void debeRegresarAlPanelDeTickets() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(IsTicketsPanelVisible.now()).isTrue()
        );
    }

    @Y("debe ver el ticket recién creado en el listado")
    public void debeVerElTicketRecienCreadoEnElListado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(TicketsPage.ticketWithTitle(ticketTitle), isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(IsTicketVisibleInList.called(ticketTitle)).isTrue()
        );
    }
}
