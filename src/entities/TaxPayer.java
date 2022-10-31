package entities;

public class TaxPayer {
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;

	
	public TaxPayer() {
	}

	// construtor para a entrada de dados
	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public TaxPayer(Double grossTax, Double taxRebate, Double netTax) {
		salaryIncome = grossTax;
		servicesIncome = taxRebate;
		capitalIncome = netTax;
	}
	
	

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	
	
	public double salaryTax() {
		double month = salaryIncome/12.0;
		if(month < 3000.0) {
			return 0.0;
		}
		else if (month < 5000.0) {
			return 10.0 * salaryIncome/100.0;
		}
		else return 20.0 * salaryIncome/100.0;
	}
	
	public double servicesTax() {
		return servicesIncome/100.0 *15.0;
	}
	
	public double capitalTax() {
		return capitalIncome/100.0 * 20.0;
	}
	
	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax(); 
	}

	public double taxRebate() {
		double allExpensives = educationSpending + healthSpending;
		double percentTax = grossTax()/100.0*30.0;
		if(percentTax < allExpensives) {
			return percentTax;
		}
		else return allExpensives;
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}
	
	
}
