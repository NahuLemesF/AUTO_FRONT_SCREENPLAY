package org.nahulemes.ui;

import net.serenitybdd.screenplay.targets.Target;

public final class LoginPage {

    public static final Target EMAIL_INPUT = Target.the("campo de correo").locatedBy("//*[@id='email']");
    public static final Target PASSWORD_INPUT = Target.the("campo de password").locatedBy("//*[@id='password']");
    public static final Target LOGIN_BUTTON = Target.the("boton ingresar").locatedBy("//*[@type='submit']");

    private LoginPage() {
    }
}
