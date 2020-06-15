public class ExperimentsWithTime {

    public static void main(String[] args) {
        Time t1 = new Time(12, 50);
        System.out.println(t1.show());
        System.out.println(t1.isDay());
        System.out.println(t1.isMorning());
        System.out.println(t1.isEvening());
        System.out.println(t1.isNight());
        System.out.println(t1.sayHello());
        System.out.println(t1.plusTime());
    }
}