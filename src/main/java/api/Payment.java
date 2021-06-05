package api;

public class Payment {
    String cardNumber;
    int cardExpirationMonth;
    int cardExpirationYear;

    public String getCardNumber() {
        return cardNumber;
    }

    public int getCardExpirationMonth() {
        return cardExpirationMonth;
    }

    public int getCardExpirationYear() {
        return cardExpirationYear;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardExpirationMonth(int cardExpirationMonth) {
        this.cardExpirationMonth = cardExpirationMonth;
    }

    public void setCardExpirationYear(int cardExpirationYear) {
        this.cardExpirationYear = cardExpirationYear;
    }
}
