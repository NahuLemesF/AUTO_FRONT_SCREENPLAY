package org.nahulemes.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class TestData {

    public static final String BASE_URL = "http://localhost:3000/";
    public static final String ADMIN_EMAIL = "admin@sofkau.com";
    public static final String ADMIN_PASSWORD = "Admin@SofkaU_2026!";

    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private TestData() {
    }

    public static String uniqueTicketTitle() {
        return "Ticket-Auto-" + LocalDateTime.now().format(TIMESTAMP_FORMAT);
    }

    public static String descriptionFor(String ticketTitle) {
        return "Descripcion automatizada para " + ticketTitle;
    }
}
