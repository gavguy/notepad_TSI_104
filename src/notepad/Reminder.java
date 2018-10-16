package notepad;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reminder extends Alarm implements Expirable { // ne kakoj roli ne iraet - dekor- on uze prinadlezit ot alarma
    private LocalDate date;


    @Override
    public void askQuestions() {
        super.askQuestions();
        System.out.println("Enter reminder date");
        date = Main.askDate();


    }

    @Override
    public boolean hasSubstring(String str) {
        return super.hasSubstring(str)
                || date.format(Main.DATE_FORMATTER).contains(str);
            //    || time.format(Main.TIME_FORMATTER).contains(str);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean isExpired() {
        LocalTime now= LocalTime.now();
        return now.isAfter(time);

    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + getId() + ", " +
                "text='" + getText() + '\'' +
                ", date='" + date.format(Main.DATE_FORMATTER) + '\'' +
                ", time='" + getTime().format(Main.TIME_FORMATTER) + '\'' +
                '}';
    }
}
