package com.DP;
public class Bike implements Vehicle
{
public void requestRide()
{
System.out.println("Requesting a Bike ride!!!");
}
}
package com.DP;
//Concrete Factories: Bike Factory
public class BikeFactory implements VehicleFactory
{
public Vehicle createVehicle() {
return new Bike();
}
}
package com.DP;
public class Car implements Vehicle
{
public void requestRide()
{
System.out.println("Requesting a Car Ride!!!");
}
}
package com.DP;
//Concrete Factories: Car Factory
public class CarFactory implements VehicleFactory
{
public Vehicle createVehicle() {
return new Car();
}
}
package com.DP;
public class CreditCardFactory implements PaymentMethodFactory
{
public PaymentMethod createPaymentMethod() {
return new CreditCardPayment();
}
}
package com.DP;
public class CreditCardPayment implements PaymentMethod
{
public void pay(double amount)
{
System.out.println("Paid $"+amount+"using a credit card..!");
}
}
package com.DP;
public class DemoMain {
public static void main(String[] args)
{
UserAuthentication authentication=UserAuthentication.getInstance();
boolean isAuthenticate=authentication.authenticateUser("username",
"password");
if (isAuthenticate) {
// Create a car ride
VehicleFactory carFactory = new CarFactory();
Vehicle car = carFactory.createVehicle();
car.requestRide();
// Create a bike ride
VehicleFactory bikeFactory = new BikeFactory();
Vehicle bike = bikeFactory.createVehicle();
bike.requestRide();
// Create a scooter ride
VehicleFactory scooterFactory = new ScooterFactory();
Vehicle scooter = scooterFactory.createVehicle();
scooter.requestRide();
// Create a credit card payment
PaymentMethodFactory creditCardFactory = new CreditCardFactory();
PaymentMethod creditCardPayment = creditCardFactory.createPaymentMethod();
creditCardPayment.pay(20.0);
// Create a PayPal payment
PaymentMethodFactory payPalFactory = new PayPalFactory();
PaymentMethod payPalPayment = payPalFactory.createPaymentMethod();
payPalPayment.pay(15.0);
} else {
System.out.println("Authentication failed. Unable to request a ride or make a
payment.");
}
}
}
package com.DP;
public interface PaymentMethod
{
void pay(double amount);
}
package com.DP;
public interface PaymentMethodFactory
{
PaymentMethod createPaymentMethod();
}
package com.DP;
public class PayPalFactory implements PaymentMethodFactory
{
public PaymentMethod createPaymentMethod()
{
return new PayPalPayment();
}
}
package com.DP;
public class PayPalPayment implements PaymentMethod
{
public void pay(double amount)
{
System.out.println("Paid $" + amount + "using PayPal..!");
}
}
package com.DP;
public class Scooter implements Vehicle
{
public void requestRide()
{
System.out.println("Requesting a Scooter ride!!!");
}
}
package com.DP;
//Concrete Factories: Scooter Factory
public class ScooterFactory implements VehicleFactory
{
public Vehicle createVehicle() {
return new Scooter();
}
}
package com.DP;
public class UserAuthentication
{
private static UserAuthentication instance;
private UserAuthentication() { }
public static UserAuthentication getInstance()
{
if(instance==null)
{
instance=new UserAuthentication();
}
return instance;
}
public boolean authenticateUser(String username, String password)
{
return true;
}
}
package com.DP;
public interface Vehicle
{
void requestRide();
}
package com.DP;
//Abstract Factory: Vehicle Factory
public interface VehicleFactory
{
Vehicle createVehicle();
}
