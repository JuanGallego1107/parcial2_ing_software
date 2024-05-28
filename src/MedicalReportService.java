import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.*;


class Report {
    String id;
    String patientId;
    String title;
    String content;
    Date date;
    String author;

    Report(String patientId, String title, String content, String author) {
        this.id = UUID.randomUUID().toString();
        this.patientId = patientId;
        this.title = title;
        this.content = content;
        this.date = new Date();
        this.author = author;
    }

    Report(String id, String patientId, String title, String content, Date date, String author) {
        this.id = id;
        this.patientId = patientId;
        this.title = title;
        this.content = content;
        this.date = date;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Report{id='" + id + "', patientId='" + patientId + "', title='" + title + "', content='" + content + "', date=" + date + ", author='" + author + "'}";
    }

    public String getId() {
        return id;
    }
}

class ReportService {
    private Map<String, Report> reports = new HashMap<>();

    public Report createReport(String patientId, String title, String content, String author) {
        Report report = new Report(patientId, title, content, author);
        reports.put(report.id, report);
        return report;
    }

    public Report getReportById(String id) {
        return reports.get(id);
    }

    public List<Report> getAllReports() {
        return new ArrayList<>(reports.values());
    }

    public Report updateReport(String id, String patientId, String title, String content, Date date, String author) {
        Report report = new Report(id, patientId, title, content, date, author);
        reports.put(id, report);
        return report;
    }

    public void deleteReport(String id) {
        reports.remove(id);
    }

    public List<Report> getReportsByPatientId(String patientId) {
        return reports.values().stream()
                .filter(report -> report.patientId.equals(patientId))
                .collect(Collectors.toList());
    }

    public String generateSummary(String id) {
        Report report = getReportById(id);
        if (report == null) {
            return "Report not found with ID: " + id;
        }
        return "Summary of Report: " + report.title + "\n" +
                "Author: " + report.author + "\n" +
                "Date: " + report.date + "\n" +
                "Content: " + (report.content.length() > 100 ? report.content.substring(0, 100) + "..." : report.content);
    }

    public List<Report> getReportsByDateRange(Date startDate, Date endDate) {
        return reports.values().stream()
                .filter(report -> !report.date.before(startDate) && !report.date.after(endDate))
                .collect(Collectors.toList());
    }
}
