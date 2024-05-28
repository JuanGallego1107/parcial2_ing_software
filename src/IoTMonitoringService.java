import java.util.*;
import java.util.concurrent.*;

class HealthData {
    String patientId;
    Date timestamp;
    String dataType;
    double value;

    HealthData(String patientId, Date timestamp, String dataType, double value) {
        this.patientId = patientId;
        this.timestamp = timestamp;
        this.dataType = dataType;
        this.value = value;
    }

    @Override
    public String toString() {
        return "HealthData{patientId='" + patientId + "', timestamp=" + timestamp + ", dataType='" + dataType + "', value=" + value + "}";
    }
}

class MonitoringService {
    private Map<String, Map<String, LinkedList<HealthData>>> healthDataMap = new HashMap<>();
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public void simulateIoTDataGeneration(String patientId) {
        Runnable task = () -> {
            generateAndStoreHealthData(patientId, "Heart Rate");
            generateAndStoreHealthData(patientId, "Blood Pressure");
            generateAndStoreHealthData(patientId, "Blood Glucose");
        };

        executor.scheduleAtFixedRate(task, 0, 10, TimeUnit.SECONDS);
    }

    public void stopSimulation() {
        executor.shutdown();
    }

    private void generateAndStoreHealthData(String patientId, String dataType) {
        HealthData healthData = generateRandomHealthData(patientId, dataType);
        healthDataMap
                .computeIfAbsent(patientId, k -> new HashMap<>())
                .computeIfAbsent(dataType, k -> new LinkedList<>())
                .add(healthData);

        LinkedList<HealthData> dataList = healthDataMap.get(patientId).get(dataType);
        if (dataList.size() > 3) {
            dataList.removeFirst();
        }
    }

    private HealthData generateRandomHealthData(String patientId, String dataType) {
        Random random = new Random();
        double value = 0.0;
        switch (dataType) {
            case "Heart Rate":
                value = 60 + random.nextInt(40); // Simulating heart rate between 60 and 100 bpm
                break;
            case "Blood Pressure":
                value = 90 + random.nextInt(30); // Simulating blood pressure between 90 and 120 mmHg
                break;
            case "Blood Glucose":
                value = 70 + random.nextInt(80); // Simulating blood glucose between 70 and 150 mg/dL
                break;
        }
        return new HealthData(patientId, new Date(), dataType, value);
    }

    public List<HealthData> getHealthDataByPatientId(String patientId) {
        List<HealthData> result = new ArrayList<>();
        Map<String, LinkedList<HealthData>> dataMap = healthDataMap.getOrDefault(patientId, new HashMap<>());
        dataMap.values().forEach(result::addAll);
        return result;
    }
}
