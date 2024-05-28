import java.util.*;

class MedicalRecord {
    String id;
    String patientId;
    String details;

    MedicalRecord(String id, String patientId, String details) {
        this.id = id;
        this.patientId = patientId;
        this.details = details;
    }

    @Override
    public String toString() {
        return "MedicalRecord{id='" + id + "', patientId='" + patientId + "', details='" + details + "'}";
    }
}

class EhrService {
    private Map<String, MedicalRecord> records = new HashMap<>();

    public MedicalRecord createRecord(String id, String patientId, String details) {
        MedicalRecord record = new MedicalRecord(id, patientId, details);
        records.put(id, record);
        return record;
    }

    public MedicalRecord getRecordById(String id) {
        return records.get(id);
    }

    public List<MedicalRecord> getAllRecords() {
        return new ArrayList<>(records.values());
    }

    public MedicalRecord updateRecord(String id, String patientId, String details) {
        MedicalRecord record = new MedicalRecord(id, patientId, details);
        records.put(id, record);
        return record;
    }

    public void deleteRecord(String id) {
        records.remove(id);
    }
}
