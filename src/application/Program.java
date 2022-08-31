package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe os dados da conta");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double balance = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double withdrawLimit = sc.nextDouble();
		Account account = new Account(number, holder, balance, withdrawLimit);
		System.out.println();
		System.out.print("Informe uma quantia para sacar: ");
		double withdraw = sc.nextDouble();
		try {
			account.withdraw(withdraw);
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));		
		}
		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}
