package hibernate_user.controller;

import java.util.Scanner;

import hibernate_user.dao.UserDao;
import hibernate_user.dto.User;

public class UserController {
	public static void main(String[] args) {
		System.out.println("WELCOME USER!!!");
		Scanner scanner = new Scanner(System.in);

		User user = new User();
		UserDao dao = new UserDao();
		System.out.println("1.SignUp\n2.Login\n3.Exit");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			try {

				// save student
				System.out.println("enter the user id:");
				int id = scanner.nextInt();
				System.out.println("Enter the user name:");
				String name = scanner.next();
				System.out.println("Enter the phone number:");
				long phone = scanner.nextLong();
				System.out.println("Enter the email:");
				String email = scanner.next();
				System.out.println("Enter the password:");
				String password = scanner.next();
				System.out.println("Enter the facebook password:");
				String facebook = scanner.next();
				System.out.println("Enter the whatsapp password:");
				String whatsapp = scanner.next();
				System.out.println("Enter the instagram password:");
				String instagram = scanner.next();
				System.out.println("Enter the snapchat password:");
				String snapchat = scanner.next();
				System.out.println("Enter the twitter password:");
				String twitter = scanner.next();

				user.setId(id);
				user.setName(name);
				user.setPhone(phone);
				user.setEmail(email);
				user.setPassword(password);
				user.setFacebook(facebook);
				user.setWhatsapp(whatsapp);
				user.setInstagram(instagram);
				user.setSnapchat(snapchat);
				user.setTwitter(twitter);

				dao.signUp(user);
				System.out.println("User signup successfully");
			} catch (Exception e) {
				System.out.println("Error in signup");
			}

		}
			break;

		case 2: {
			try {
				// login student
				System.out.println("Enter the email:");
				String email = scanner.next();
				System.out.println("Enter the password:");
				String password = scanner.next();

				User loginUser = dao.loginUser(email, password);
				if (loginUser != null) {
					System.out.println("Login successful:" + loginUser);
					System.out.println("1.Show Password \n2.logout");
					choice = scanner.nextInt();

					switch (choice) {
					case 1: {
						// Displaying password(for demonstration purpose)
						dao.displayPassword();

					}
						break;
					case 2: {
						System.out.println("Logout Successful");
					}
						break;

					default: {
						System.out.println("Invalid choice!");
					}

						break;
					}

				} else {
					System.out.println("Login Failed ,Invalid Email or Password!");
				}
				
			} catch (Exception e) {
				System.out.println("Error in login");
			}
		}
		default:
			break;
		}
		scanner.close();

	}
}
