abstract class Vehicle {
    public abstract void bookRide();
}

class Car extends Vehicle {
    public void bookRide() {
        System.out.println("Car ride booked.");
    }
}

class Bike extends Vehicle {
    public void bookRide() {
        System.out.println("Bike ride booked.");
    }
}

class Scooter extends Vehicle {
    public void bookRide() {
        System.out.println("Scooter ride booked.");
    }
}

class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        if (type.equals("car")) {
            return new Car();
        } else if (type.equals("bike")) {
            return new Bike();
        } else {
            return new Scooter();
        }
    }
}

abstract class PaymentMethod {
    public abstract void pay();
}

class CreditCard extends PaymentMethod {
    public void pay() {
        System.out.println("Payment made by Credit Card.");
    }
}

class PayPal extends PaymentMethod {
    public void pay() {
        System.out.println("Payment made by PayPal.");
    }
}

abstract class PaymentFactory {
    public abstract PaymentMethod createPayment();
}

class CreditCardFactory extends PaymentFactory {
    public PaymentMethod createPayment() {
        return new CreditCard();
    }
}

class PayPalFactory extends PaymentFactory {
    public PaymentMethod createPayment() {
        return new PayPal();
    }
}

class UserAuth {
    private static UserAuth instance;
    private boolean authenticated;
    private UserAuth() {}
    public static UserAuth getInstance() {
        if (instance == null) {
            instance = new UserAuth();
        }
        return instance;
    }
    public void login() {
        authenticated = true;
        System.out.println("User logged in.");
    }
    public boolean isAuthenticated() {
        return authenticated;
    }
}

public class Week_3_post_Lab {
    public static void main(String[] args) {
        UserAuth user = UserAuth.getInstance();
        user.login();

        if (user.isAuthenticated()) {
            Vehicle vehicle = VehicleFactory.createVehicle("car");
            vehicle.bookRide();

            PaymentFactory paymentFactory = new CreditCardFactory();
            PaymentMethod payment = paymentFactory.createPayment();
            payment.pay();
        }
    }
}
