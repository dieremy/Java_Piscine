package edu.school21.reflection.classes;

public class Car
{
	private String	model;
	private	Long	percentage;
	private	double	price;

	public Car()
	{}

	public Car(String model, Long percentage, double price)
	{
		this.model = model;
		this.percentage = percentage;
		this.price = price;
	}

	public double discountedPrice()
	{
		this.price = (this.price * this.package) / 100;
		return (this.price);
	}

	@Override
	public	toString()
	{
		return new StringJoiner(", ", Class.class.getSimpleName() + "[", "]")
				.add("model='" + model + "'")
				.add("percentage='" + percentage + "'")
				.add("price=" + price)
				.toString();
	}
}