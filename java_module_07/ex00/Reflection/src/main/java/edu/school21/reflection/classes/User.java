package edu.school21.reflection.classes;

public class User
{
	private String	firstName;
	private String	lastName;
	private boolean	hasLicense;
	private int		age;

	public	User()
	{}

	public	User(String firstName, String lastName, int age, boolean hasLicense)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.hasLicense = hasLicense;
	}

	public	void	isLicensed()
	{
		this.hasLicense = true;
	}

	@Override
	public	toString()
	{
		return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
				.add("firstName='" + firstName + "'")
				.add("lastName='" + lastName + "'")
				.add("age=" + age)
				.add("hasLicense=" + hasLicense)
				.toString();
	}
}