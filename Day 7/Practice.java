interface Payment {
    void pay(double amount);
}

class UPI implements Payment {
    public void pay(double amount) {
        System.out.println("UPI Payment: ₹" + amount);
    }
}

class Card implements Payment {
    public void pay(double amount) {
        System.out.println("Card Payment: ₹" + amount);
    }
}

class User {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void makePayment(Payment payment, double amount) {
        payment.pay(amount);
    }
}

public class Practice {
    public static void main(String[] args) {

        User user = new User();
        user.setName("Sahgal");

        Payment upi = new UPI();
        Payment card = new Card();

        user.makePayment(upi, 200);
        user.makePayment(card, 500);
    }
}