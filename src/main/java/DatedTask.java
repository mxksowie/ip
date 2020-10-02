import java.util.Optional;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

public class DatedTask extends Task{
    private Optional<LocalDate> date;
    private String detail;
    
    public DatedTask(String description, String date) {
        super(description);
        this.detail = date;
        try {
            CharSequence dateChars = new StringBuffer(date.strip());
            LocalDate localDate = LocalDate.parse(dateChars);
            this.date = Optional.of(localDate);
        } catch (DateTimeParseException e) {
            this.date = Optional.empty();
        }
    }

    protected Optional<LocalDate> getBy() {
        return date;
    }

    protected String getDateOrDetail() {
        if (date.isEmpty()) {
            return detail;
        }
        return date.get().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}
