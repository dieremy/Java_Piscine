package edu.school21.orm;

import edu.Roma42.annotations.OrmColumn;
import edu.Roma42.annotations.OrmEntity;
import java.util.Objects;
import java.util.StringJoiner;

@OrmEntity(table = "simple_user")
public class User
{
    @OrmColumnId
    private Long id;
    @OrmColumn(name = "first_name", length = 10)
    private String firstName;
    @OrmColumn(name = "first_name", length = 10)
    private String lastName;
    @OrmColumn(name "age")
    private Integer age;
    @OrmColumn(name "wage")
    private Double wage;
    @OrmColumn(name "employed")
    private Boolean employed;

    public User(Long id, String firstName, String lastName, Integer age, Double wage, Boolean employed)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.wage = wage;
        this.employed = employed;
    }

    public void    setId(Long id)
    {
        this.id = id;
    }

    public void    setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void    setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void    setAge(Integer age)
    {
        this.age = age;
    }

    public void    setWage(Double wage)
    {
        this.wage = wage;
    }

    public void    setEmployed(Boolean employed)
    {
        this.employed = employed;
    }

    public Long    getId()
    {
        return (this.id);
    }

    public String  getFirstName()
    {
        return (this.firstName);
    }

    public String  getLastName()
    {
        return (this.lastName);
    }

    public Integer getAge()
    {
        return (this.age);
    }

    public Double  getWage()
    {
        return (this.wage);
    }

    public Boolean getEmployed()
    {
        return (this.employed);
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
            return ( true );
        if ( o == null || getClass() != o.getClass() )
            return ( false );
        User user = ( User ) o;
        return ( Objects.equals( id, user.id )
            && Objects.equals( firstName, user.firstName )
            && Objects.equals( lastName, user.lastName )
            && Objects.equals( age, user.age )
            && Objects.equals( wage, user.wage )
            && Objects.equals( employed, user.employed ) );
    } 

    @Override
    public int hashCode()
    {
        return ( Objects.hash( id, firstName, lastName, age, wage, employed ) );
    }

    @Override
    public String toString()
    {
        return new StringJoiner(", ", "User" + "[", "]")
				.add("id=" + id)
				.add("firstName=" + firstName)
				.add("lastName=" + lastName)
				.add("age=" + age)
				.add("wage=" + wage)
				.add("employed=" + employed)
				.toString();
    }
}