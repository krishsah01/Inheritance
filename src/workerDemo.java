public class workerDemo {
    public static void main(String[] args) {
        Worker worker = new Worker("101","krish", "sah","mr.", 2000,20 );
        System.out.println(worker.calculateWeeklyPay(16));
        worker.displayWeeklyPay(20);
        System.out.println(worker.toCSV());
        System.out.println(worker.toXML());
        System.out.println(worker.toJSON());
    }
}
