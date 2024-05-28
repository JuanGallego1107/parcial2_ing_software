import java.util.*;

class MedicationReminderService {
    private Map<String, List<String>> medicationReminders = new HashMap<>();
    private Map<String, List<String>> medicationCompliance = new HashMap<>();

    // Simular el envío de un recordatorio de medicación
    public void sendMedicationReminder(String patientId, String medication) {
        String reminder = "Reminder for Patient " + patientId + ": Take your medication - " + medication;
        medicationReminders.computeIfAbsent(patientId, k -> new ArrayList<>()).add(reminder);
        System.out.println(reminder);
    }

    // Simular el registro del cumplimiento de la medicación
    public void recordMedicationCompliance(String patientId, String medication) {
        String compliance = "Compliance recorded for Patient " + patientId + " for medication - " + medication;
        medicationCompliance.computeIfAbsent(patientId, k -> new ArrayList<>()).add(compliance);
        System.out.println(compliance);
    }

    // Obtener todos los recordatorios de medicación para un paciente
    public List<String> getMedicationReminders(String patientId) {
        return medicationReminders.getOrDefault(patientId, Collections.emptyList());
    }

    // Obtener todos los registros de cumplimiento de medicación para un paciente
    public List<String> getMedicationCompliance(String patientId) {
        return medicationCompliance.getOrDefault(patientId, Collections.emptyList());
    }
}
