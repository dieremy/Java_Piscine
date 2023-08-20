package edu.school21.reflection.app;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.stream.Collectors;
import java.util.*;

public class Program
{
	public static void main(String[] args) throws ClassNotFoundException,
		   NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException
	{
		Scanner scanner = new Scanner(System.in);

        System.out.println("Classes:");
        System.out.println("User");
        System.out.println("Car");
        System.out.println("---------------------");
        System.out.println("Enter class name:");
        String className = scanner.nextLine();

        try
		{
            Class<?> selectedClass = Class.forName("edu.school21.reflection.classes." + className);
            System.out.println("---------------------");
            System.out.println("fields:");
            Field[] fields = selectedClass.getDeclaredFields();
            for (Field field : fields)
                System.out.println(field.getType().getSimpleName() + " " + field.getName());

            System.out.println("methods:");
            Method[] methods = selectedClass.getDeclaredMethods();
            for (Method method : methods)
			{
                System.out.println(method.getReturnType().getSimpleName() + " " + method.getName() + "(" +
                        String.join(", ", Arrays.stream(method.getParameterTypes())
                                .map(Class::getSimpleName)
                                .collect(Collectors.toList())) + ")");
            }


            System.out.println("---------------------");
            System.out.println("Let's create an object.");
            Constructor<?> emptyConstructor = selectedClass.getConstructor();
            Object instance = emptyConstructor.newInstance();

			for (Field field : fields)
				field.setAccessible(true);


			try
			{
				for (Field field : fields)
				{
					System.out.println(field.getName() + ":");
					String value = scanner.nextLine();
					if (field.getType() == String.class)
						field.set(instance, value);
					else if (field.getType() == int.class)
					field.set(instance, Integer.parseInt(value));
					else if (field.getType() == double.class)
					field.set(instance, Double.parseDouble(value));
					else if (field.getType() == boolean.class)
					field.set(instance, Boolean.parseBoolean(value));
					else if (field.getType() == long.class)
					field.set(instance, Long.parseLong(value));
				}
				System.out.println("Object created: " + instance);
			}
			catch(IllegalAccessException | NumberFormatException e)
			{
				System.out.println("Error occurred while updating the field:");
				e.getMessage();
			}

            System.out.println("---------------------");
            System.out.println("Enter name of the field for changing:");
            String fieldName = scanner.nextLine();
            Field targetField = selectedClass.getDeclaredField(fieldName);
            System.out.println("Enter " + targetField.getType().getSimpleName() + " value:");
            String newValue = scanner.nextLine();
            targetField.setAccessible(true);
			try
			{
				if (targetField.getType() == String.class)
					targetField.set(instance, newValue);
				else if (targetField.getType() == int.class)
				{
					int intValue = Integer.parseInt(newValue);
					targetField.set(instance, intValue);
				}
				else if (targetField.getType() == double.class)
				{
					double doubleValue = Double.parseDouble(newValue);
					targetField.set(instance, doubleValue);
				}
				else if (targetField.getType() == boolean.class)
				{
					boolean booleanValue = Boolean.parseBoolean(newValue);
					targetField.set(instance, booleanValue);
				}
				else if (targetField.getType() == long.class)
				{
					long longValue = Long.parseLong(newValue);
					targetField.set(instance, longValue);
				}
				else
					System.out.println("Unsupported field type: " + targetField.getType().getSimpleName());
				System.out.println("Object updated: " + instance);
			}
			catch(IllegalAccessException | NumberFormatException e)
			{
				System.out.println("Error occurred while updating the field:");
				e.getMessage();
			}
			try
			{
				System.out.println("---------------------");
				System.out.println("Enter name of the method for call:");
				String methodName = scanner.nextLine();
				Method targetMethod = selectedClass.getDeclaredMethod(methodName);

				try
				{
					Object result = targetMethod.invoke(instance);
					if (result != null)
					{
						System.out.println("Method returned:");
						if (result instanceof Double)
							System.out.println((Double) result);
						else if (result instanceof Integer)
							System.out.println((Integer) result);
						else if (result instanceof Boolean)
							System.out.println((Boolean) result);
						else
							System.out.println(result);
					}
					else
						System.out.println("Method returned null.");
				}
				catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
				{
					System.out.println("An error occurred while invoking the method:");
					e.getMessage();
				}
			}
			catch (NoSuchMethodException e)
			{
				System.out.println("Method not found:");
				e.getMessage();
			}
		}
		catch (ClassNotFoundException | NoSuchFieldException e)
		{
			e.getMessage();
			System.out.println("Class not found.");
		}
	}
}