import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        AppointmentsService appointmentsService = new AppointmentsService();
        EhrService ehrService = new EhrService();
        MonitoringService monitoringService = new MonitoringService();
        CommunicationService communicationService = new CommunicationService();
        MedicationReminderService medicationReminderService = new MedicationReminderService();
        ReportService reportService = new ReportService();

        while (!exit) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Gestionar Citas");
            System.out.println("2. Gestionar Historial Médico Electrónico");
            System.out.println("3. Monitoreo de Salud Remoto");
            System.out.println("4. Comunicación en Tiempo Real");
            System.out.println("5. Recordatorios de Medicación");
            System.out.println("6. Generación de Reportes");
            System.out.println("0. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (choice) {
                case 1:
                    manageAppointments(appointmentsService);
                    break;
                case 2:
                    manageEHR(ehrService);
                    break;
                case 3:
                    manageIoTMonitoring(monitoringService);
                    break;
                case 4:
                    manageCommunication(communicationService);
                    break;
                case 5:
                    manageMedicationReminders(medicationReminderService);
                    break;
                case 6:
                    manageReports(reportService);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }

    private static void manageAppointments(AppointmentsService service) {
        System.out.println("///////////////////////////////////////AppointmentService//////////////////////////////////////////////////");

        // Create a new appointment
        Appointment appointment1 = service.createAppointment("1", "Patient1", "Doctor1", new Date(), "Scheduled");
        System.out.println("Created Appointment: " + appointment1);

        // Get appointment by ID
        Appointment retrievedAppointment = service.getAppointmentById("1");
        System.out.println("Retrieved Appointment: " + retrievedAppointment);

        // Update appointment
        Appointment updatedAppointment = service.updateAppointment("1", "Patient1", "Doctor1", new Date(), "Completed");
        System.out.println("Updated Appointment: " + updatedAppointment);

        // Get all appointments
        System.out.println("All Appointments: " + service.getAllAppointments());

        // Delete appointment
        service.deleteAppointment("1");
        System.out.println("Appointment deleted. All Appointments: " + service.getAllAppointments());
    }

    private static void manageEHR(EhrService service) {
        System.out.println("///////////////////////////////////////MedicalRecordService//////////////////////////////////////////////////");

        // Create a new medical record
        MedicalRecord record1 = service.createRecord("1", "Patient1", "Details of Patient1");
        System.out.println("Created Record: " + record1);

        // Get medical record by ID
        MedicalRecord retrievedRecord = service.getRecordById("1");
        System.out.println("Retrieved Record: " + retrievedRecord);

        // Update medical record
        MedicalRecord updatedRecord = service.updateRecord("1", "Patient1", "Updated details of Patient1");
        System.out.println("Updated Record: " + updatedRecord);

        // Get all medical records
        System.out.println("All Records: " + service.getAllRecords());

        // Delete medical record
        service.deleteRecord("1");
        System.out.println("Record deleted. All Records: " + service.getAllRecords());
    }

    private static void manageIoTMonitoring(MonitoringService service) throws InterruptedException {
        System.out.println("///////////////////////////////////////IoTMonitoringService//////////////////////////////////////////////////");

        // Simulate IoT data generation for patient1
        service.simulateIoTDataGeneration("Patient1");

        System.out.println("Measuring Blood Pressure...");
        // Let the simulation run for a while
        Thread.sleep(5000); // Sleep for 5 seconds to allow data generation

        // Stop the simulation
        service.stopSimulation();

        // Retrieve and print health data for patient1
        System.out.println("Health Data for Patient1: " + service.getHealthDataByPatientId("Patient1"));
    }

    private static void manageCommunication(CommunicationService service) {
        System.out.println("///////////////////////////////////////CommunicationService//////////////////////////////////////////////////");

        // Simulate video conferences
        service.startVideoConference("Patient1", "DoctorA");
        service.endVideoConference("Patient1", "DoctorA");

        // Simulate chat
        service.sendMessage("Patient1", "DoctorA", "Hello, Doctor. I have a question about my medication.");
        service.receiveMessage("DoctorA", "Patient1", "Hello, Patient1. Sure, I'm here to help you.");

        // Simulate push notifications
        service.sendNotification("Patient1", "Reminder: It's time to take your medication.");
        service.sendNotification("DoctorA", "New message from Patient1: Hello, Doctor. I have a question about my medication.");
    }

    private static void manageMedicationReminders(MedicationReminderService service) {
        System.out.println("///////////////////////////////////////MedicationReminderService//////////////////////////////////////////////////");

        // Simulate sending medication reminders
        service.sendMedicationReminder("Patient1", "Aspirin 100mg");
        service.sendMedicationReminder("Patient1", "Vitamin D 1000IU");
        service.sendMedicationReminder("Patient2", "Metformin 500mg");

        // Simulate recording medication compliance
        service.recordMedicationCompliance("Patient1", "Aspirin 100mg");
        service.recordMedicationCompliance("Patient1", "Vitamin D 1000IU");
        service.recordMedicationCompliance("Patient2", "Metformin 500mg");

        // Get all medication reminders for a patient
        System.out.println("Medication Reminders for Patient1: " + service.getMedicationReminders("Patient1"));
        System.out.println("Medication Reminders for Patient2: " + service.getMedicationReminders("Patient2"));

        // Get all medication compliance records for a patient
        System.out.println("Medication Compliance for Patient1: " + service.getMedicationCompliance("Patient1"));
        System.out.println("Medication Compliance for Patient2: " + service.getMedicationCompliance("Patient2"));
    }

    private static void manageReports(ReportService service) {
        System.out.println("///////////////////////////////////////ReportService//////////////////////////////////////////////////");

        // Create new reports
        Report report1 = service.createReport("Patient1", "Title1", "Health report content for Patient1", "Doctor A");
        System.out.println("Created Reports: " + report1);

        // Get report by ID
        Report retrievedReport = service.getReportById(report1.getId());
        System.out.println("Retrieved Report: " + retrievedReport);

        // Generate summary of a report
        String summary = service.generateSummary(report1.getId());
        System.out.println("Report Summary: " + summary);
    }
}
