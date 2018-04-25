package business.domain;

import java.util.Calendar;

public class NextMatriculationNumberGenerator {

    private static long lastThreeDigits = 100L;

    public static void initialize(long lastMatriculationNumber) {
        String numberStr = String.valueOf(lastMatriculationNumber);
        lastThreeDigits = Long.parseLong(numberStr.substring(numberStr.length() - 3));
        lastThreeDigits++;
    }

    /**
     * Format: “<Aktuelles-Jahr-2-stellig><Nummer-Uni-2-stellig><Nummer-fortlaufend-3-stellig>”;
     * Beispiel: “1530312” (15=2015, 30=TU Graz, 312=fortlaufende Nummer);
     *
     * @return matriculation Number
     */
    public static long generateNextNumber() {
        // get last two digits of current year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR) % 100;
        int uniId = 30;
        String matriculationNumber = String.valueOf(currentYear) +
                String.valueOf(uniId) +
                String.format("%03d", lastThreeDigits);
        lastThreeDigits++;
        return Long.parseLong(matriculationNumber);
    }
}
