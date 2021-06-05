package models;

public class Payment {

    public enum CARDTYPE{
        VISA("Visa"),
        AMEX("American Express"),
        DINER("Diner's Club");

        private String type;

        public String getType(){
            return this.type;
        }

        CARDTYPE(String type) {
            this.type = type;
        }
    }

    long cardNumber;
    int month;
    int year;
    String name;

    public Payment(long cardNumber, int month, int year, String name) {
        this.cardNumber = cardNumber;
        this.month = month;
        this.year = year;
        this.name = name;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }
}
