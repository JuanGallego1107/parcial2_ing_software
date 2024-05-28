import java.util.*;

class Appointment {
    String id;
    String patientId;
    String doctorId;
    Date date;
    String status;

    Appointment(String id, String patientId, String doctorId, Date date, String status) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{id='" + id + "', patientId='" + patientId + "', doctorId='" + doctorId + "', date=" + date + ", status='" + status + "'}";
    }
}

class AppointmentsService {
    private Map<String, Appointment> appointments = new HashMap<>();

    public Appointment createAppointment(String id, String patientId, String doctorId, Date date, String status) {
        Appointment appointment = new Appointment(id, patientId, doctorId, date, status);
        appointments.put(id, appointment);
        return appointment;
    }

    public Appointment getAppointmentById(String id) {
        return appointments.get(id);
    }

    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointments.values());
    }

    public Appointment updateAppointment(String id, String patientId, String doctorId, Date date, String status) {
        Appointment appointment = new Appointment(id, patientId, doctorId, date, status);
        appointments.put(id, appointment);
        return appointment;
    }

    public void deleteAppointment(String id) {
        appointments.remove(id);
    }
}
