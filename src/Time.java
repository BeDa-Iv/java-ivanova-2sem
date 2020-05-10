import java.util.Calendar;
import java.util.GregorianCalendar;
public class Time {
    int hours;
    int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public String show() {
        return (this.hours + ":" + this.minutes);
    }

    boolean isDay() {
        return hours >= 12 & hours <= 16;
    }

    boolean isMorning() {
        return hours >= 4 & hours <= 11;
    }

    boolean isEvening() {
        return hours >= 17 & hours <= 23;
    }

    boolean isNight() {
        return hours >= 0 & hours <= 3;
    }

    public String sayHello() {
        if (isDay())
            return ("Добрый день");
        else if (isMorning())
            return ("Доброе утро");
        else if (isEvening())
            return ("Добрый вечер");
        else
            return ("Доброй ночи");
    }

    public String plusTime() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, minutes);
        calendar.add(Calendar.MINUTE, 20);
        return (calendar.get(Calendar.HOUR_OF_DAY) + ":" + (calendar.get(Calendar.MINUTE)));
    }
}



