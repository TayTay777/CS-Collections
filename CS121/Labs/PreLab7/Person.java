
public class Person {

	private String firstName;
	private String lastName;
	private int age;


	public Person(String firstName, String lastName, int age)
	{ 
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}


	public String getFirstname()
	{
		return firstName;
	}

	public String getLastname()
	{
		return lastName;
	}	

	public int getAge()
	{
		return age;
	}

	public void setFistname(String firstName)
	{
		this.firstName = firstName;
	}

	public void setLastname(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setage(int age)
	{
		this.age = age;
	}
	
	public String toString()
	{
		return 
				"Here is your name output: " + firstName + " " + lastName + " " + "& here is your age " + age;
	}











}
