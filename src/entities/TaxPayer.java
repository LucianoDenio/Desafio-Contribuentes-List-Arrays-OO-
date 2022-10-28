package entities;

public class TaxPayer {
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;

	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
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
	
	public double salaryTax(double salary) {
		if(salary < 3000) {
			return 0;
		}
		else if (salary < 5000) {
			return salary/ 100 * 10;
		}
		else return salary/ 100 * 20;
	}
	
	public double servicesTax(double taxServices) {
		return taxServices/100 *15;
	}
	
	public double capitalTax(double taxCapital) {
		return taxCapital/100 * 20;
	}
	
	public double grossTax(double taxSalary, double taxServices, double taxCapital) {
		return taxSalary + taxServices + taxCapital; 
	}

	public double taxRebate(double grossTax, double educationSpending, double healthSpending) {
		if(grossTax/100 * 30 < educationSpending + healthSpending) {
			return grossTax/100*30;
		}
		else return educationSpending + healthSpending;
	}
	
	public double netTax(double grossTax, double taxRebate) {
		return grossTax - taxRebate;
	}
	

}