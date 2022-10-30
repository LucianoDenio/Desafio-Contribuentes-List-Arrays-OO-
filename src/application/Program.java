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
		
		List <TaxPayer> list = new ArrayList<>(); // lista principal com os dados do pagador
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int N = sc.nextInt();
		System.out.println();
		
		for(int i=0;i<N;i++) {
			System.out.println("Digite os dados do "+(i+1)+"o contribuinte: ");
			System.out.print("Renda anual com salário: ");
			Double salary = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			Double servicesIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			Double capitalIncome = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			Double healthSpending = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			Double educationSpending = sc.nextDouble();
			System.out.println();
			
			TaxPayer payer = new TaxPayer(salary,servicesIncome,capitalIncome,healthSpending,educationSpending);
			
			list.add(payer);
			
		}
		
		List<TaxPayer> tax = new ArrayList<>(); // nova lista que armazena os impostos 
		TaxPayer payer = new TaxPayer(); // objeto para poder chamar funções
		
		for(int i=0;i<list.size();i++) {
			Double salaryTax = payer.salaryTax(list.get(i).getSalaryIncome());
			Double serviceTax = payer.servicesTax(list.get(i).getServicesIncome());
			Double capitalTax = payer.capitalTax(list.get(i).getCapitalIncome());
			Double gross = payer.grossTax(salaryTax, serviceTax, capitalTax);
			Double rebate = payer.taxRebate(gross, list.get(i).getEducationSpending(), list.get(i).getHealthSpending());
			Double net = payer.netTax(gross, rebate);
			
			TaxPayer allTax = new TaxPayer(gross,rebate,net);// construtor para todas as taxas e abatimentos
			tax.add(allTax);
	
		}
		
		for(int i=0;i<tax.size();i++) {
			System.out.println();
			System.out.println("Resumo do "+(i+1)+"o contribuinte:");
			System.out.printf("Imposto bruto total: %.2f%n",tax.get(i).getSalaryIncome() );
			System.out.printf("Abatimento: %.2f%n",tax.get(i).getServicesIncome());
			System.out.printf("Imposto devido: %.2f%n", tax.get(i).getCapitalIncome());
			System.out.println();
		}
		
		
		
		
		
		
		
		sc.close();

	}

}
