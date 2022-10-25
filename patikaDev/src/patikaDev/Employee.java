package patikaDev;

public class Employee {
	
	//private. Çünkü bu değerleri dışarıdan değiştirmeyeceğim.
	//salary'i dışarıdan almam gerektiği için public yaptım.
	
	private String name; 
	public double salary;
	private int workHours;
	private int hireYear;
	
	//Constructor  oluşturdum.
	Employee(int hireYear, int workHours, double salary, String name){
		
		this.name = name;
		this.salary = salary;
		this.workHours = workHours;
		this.hireYear = hireYear;
		
	}
	
	public double tax() {
		//Çalışanın maaşı 1000 TL'den fazla ise maaşının
		//%3'ü kadar vergi uygulanacaktır.
		if(this.salary >= 1000) {
			return salary * 0.03;
			 
		}
			return 0.0;				
	}
	
	//Eğer çalışan haftada 40 saatten 
	//fazla çalışmış ise fazladan çalıştığı 
	//her saat başına 30 TL olacak şekilde bonus 
	//ücretleri hesaplayacaktır.

	public double bonus() {
		int extraHours = this.workHours - 40;
		if(extraHours > 0) {
			return 30 * extraHours;	
		}
		return 0.0;
	}
	
	//Çalışanın işe başlangıç yılına 
	//göre maaş artışını hesaplayacaktır.
	//Şuan ki yılı 2021 olarak alın.
	public double raiseSalary() {
		int currentYear = 2021 - this.hireYear;
		
		//Eğer çalışan 10 yıldan az bir süredir çalışıyorsa
		//maaşına %5 zam yapılacaktır.
		if(currentYear < 10) {
			return salary * 0.05;
			
		}
		
		//Eğer çalışan 9 yıldan fazla ve 
		//20 yıldan az çalışıyorsa maaşına %10 zam yapılacaktır.
		else if(currentYear >= 10 && currentYear < 20) {
			return salary * 0.10;
		}
		//Eğer çalışan 19 yıldan fazla çalışıyorsa 
		//%15 zam yapılacaktır.
		else {
			return salary * 0.15;
		}
	}
	
	
	public void toString(Employee employee) {
		System.out.println("Vergi:" + employee.tax());
		System.out.println("Bonus:" + employee.bonus());
		System.out.println("Maas Artisi:" + employee.raiseSalary());
		
		//vergi kendinden gittiği için - yapıldı.
		double totalSalary = employee.salary - employee.tax() + employee.bonus();
		System.out.println("Vergi ve Bonuslar ile birlikte maas :" + totalSalary);
		System.out.println("Toplam Maas :" + (employee.salary + employee.raiseSalary() + employee.bonus()));
		
	}

	
}
