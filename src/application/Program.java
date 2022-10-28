package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <TaxPayer> list = new ArrayList<>();
		
		System.out.println("Quantos contribuintes você vai digitar? ");
		int N = sc.nextInt();
		
		for(int i=0;i<N;i++) {
			System.out.println("Digite os dados do "+(i+1)+"o contribuinte: ");
			System.out.print("Renda anual com salário: ");
			Double salary = sc.nextDouble();
			System.out.println("Renda anual com prestação de serviço: ");
			Double servicesIncome = sc.nextDouble();
			System.out.println("Renda anual com ganho de capital: ");
			Double capitalIncome = sc.nextDouble();
			System.out.println("Gastos médicos: ");
			Double healthSpending = sc.nextDouble();
			System.out.println("Gastos educacionais: ");
			Double educationSpending = sc.nextDouble();
			
			TaxPayer payer = new TaxPayer(salary,servicesIncome,capitalIncome,healthSpending,educationSpending);
			
			list.add(payer);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		sc.close();

	}

}
