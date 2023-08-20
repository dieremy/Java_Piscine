package edu.school21.reflection.classes;

import java.util.StringJoiner;

public class Car
{
	private String	model;
	private	long	percentage;
	private	double	price;

	public Car()
	{}

	public Car(String model, long percentage, double price)
	{
		this.model = model;
		this.percentage = percentage;
		this.price = price;
	}

	public double discountedPrice()
	{
		this.price = (this.price * this.percentage) / 100;
		return (this.price);
	}

	@Override
	public String toString()
	{
		return new StringJoiner(", ", Class.class.getSimpleName() + "[", "]")
				.add("model='" + model + "'")
				.add("percentage='" + percentage + "'")
				.add("price=" + price)
				.toString();
	}
}