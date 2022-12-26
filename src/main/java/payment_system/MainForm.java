package payment_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import forms.Form;
import payment.Payment;
import payment.Wallet;
import refunds.RefundController;
import services.Donations;
import services.InternetPayment;
import services.Landline;
import services.MobileRecharge;
import services.ServiceFactory;

public class MainForm {
//	private static Scanner myObj = new Scanner(System.in);
//	public static Payment payment ;
//	public static User user = new User();
//	public static RefundController refundSubject = new RefundController();
//	public static List<User> users=new ArrayList<>();
//	public static ServiceFactory mobileRechaServiceFactory = new MobileRecharge();
//	public static ServiceFactory internetPaymentFactory = new InternetPayment();
//	public static ServiceFactory landlineServiceFactory = new Landline();
//	public static ServiceFactory donationServiceFactory = new Donations();
//	public static void getUserPrompt() {
//		System.out.println("Our Services: ");
//		System.out.println("1- Mobile Recharge Services");
//		System.out.println("2- Internet Payment Services");
//		System.out.println("3- Landline Services ");
//		System.out.println("4- Donation Services ");
//		System.out.println("5- Add funds to wallet ");
//		System.out.println("Enter your service: ");
//		int switchNum = myObj.nextInt();
//		switch (switchNum) {
//		case 1:
//			System.out.println("---Mobile Recharge Services---");
//			Form mobileForm = mobileRechaServiceFactory.createForm();
//			((MobileRecharge) mobileRechaServiceFactory).setCompanyChoice();
//			((MobileRecharge) mobileRechaServiceFactory).setPaymentChoice();
//			if(user.requestRefund(((MobileRecharge) mobileRechaServiceFactory).form.amount)) {
//				refundSubject.subscribe(user);
//			}
//			break;
//		case 2:
//			System.out.println("---Internet Payment Services---");
//			internetPaymentFactory.createForm();
//			((InternetPayment) internetPaymentFactory).setCompanyChoice();
//			((InternetPayment) internetPaymentFactory).setPaymentChoice();
//			if( user.requestRefund(((InternetPayment) internetPaymentFactory).form.amount) ) {
//				refundSubject.subscribe(user);
//			}
//			break;
//		case 3:
//			System.out.println("---Landline Service---");
//			Form landlineForm = landlineServiceFactory.createForm();
//			((Landline) landlineServiceFactory).setReceiptChoice();
//			((Landline) landlineServiceFactory).setPaymentChoice();
//			if ( user.requestRefund(((Landline) landlineServiceFactory).form.amount) ) {
//				refundSubject.subscribe(user);
//			}
//			break;
//		case 4:
//			System.out.println("---Donation Services---");
//			Form donationForm = donationServiceFactory.createForm();
//			((Donations) donationServiceFactory).setDonationChoice();
//			((Donations) donationServiceFactory).setPaymentChoice();
//			if( user.requestRefund(((Donations) donationServiceFactory).form.amount) ) {
//				refundSubject.subscribe(user);
//			}
//			break;
//		case 5:
//			System.out.println("---Add funds to wallet---");
//			((Wallet) user.wallet).addFunds();
//		}
//	}
//	
//	public static void getAdminForm() {
//		System.out.println("----Choose----");
//		System.out.println("1- Add discount");
//		System.out.println("2- View refund requests");
//		System.out.println("3- Exit");
//		int temp = myObj.nextInt();
//		switch (temp) {
//		case 1:
//			 int c;
//			System.out.println("\n1- Overall Descount \n2- Specific Discount");
//			c = myObj.nextInt();
//			if(c == 2) {
//				System.out.println("Our Services \n1- Mobile Recharge Services");
//				System.out.println("2- Internet Payment Services");
//				System.out.println("3- Landline Services ");
//				System.out.println("Enter your service: ");
//				int s = myObj.nextInt();
//				System.out.println("Enter the percentage of the discount: ");
//				int discountPercentSpecific = myObj.nextInt();
//				
//				switch (s) {
//				case 1: {
//					mobileRechaServiceFactory.specificDiscount = discountPercentSpecific;
//					break;
//				}
//				case 2:{
//					internetPaymentFactory.specificDiscount = discountPercentSpecific;
//					break;
//				}
//				case 3:{
//					landlineServiceFactory.specificDiscount = discountPercentSpecific;
//					break;
//				}
//				default:
//					throw new IllegalArgumentException("Unexpected value: " + s);
//				}
//			}else {
//				System.out.println("Enter the percentage of the discount: ");
//				int discountPercentOverall = myObj.nextInt();
//				mobileRechaServiceFactory.overallDiscount = discountPercentOverall;
//				internetPaymentFactory.overallDiscount = discountPercentOverall;
//				landlineServiceFactory.overallDiscount = discountPercentOverall;
//			}
//			break;
//		case 2:
//			System.out.println(refundSubject.requests);
//			refundSubject.getAdminResponse(users);
//			user.update();
//			break;
//		case 3:
//			return;
//		default:
//			System.out.println("sUnexpected value: " + temp);
//			break;
//		}		
//}	
}