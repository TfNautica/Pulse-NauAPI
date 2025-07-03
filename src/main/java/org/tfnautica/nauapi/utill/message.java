package org.tfnautica.nauapi.utill;

public class message {
    public static String NAPI_PREFIX = "§x§A§9§0§0§F§F|§x§C§2§3§E§B§6N§x§C§E§5§D§9§2a§x§D§A§7§C§6§Dp§x§E§6§9§B§4§9i§x§F§F§D§9§0§0| ";

    public static String error_message(String message) {
        return NAPI_PREFIX + "§x§F§F§0§0§0§0" + message;
    }

    public static String done_message(String message) {
        return NAPI_PREFIX + "§x§0§3§F§F§0§0" + message;
    }

    public static String warn_message(String message) {
        return NAPI_PREFIX + "§x§F§F§D§9§0§0" + message;
    }

}
