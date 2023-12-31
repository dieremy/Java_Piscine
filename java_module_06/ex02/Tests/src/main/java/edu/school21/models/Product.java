package edu.school21.models;

import java.util.Objects;

public class Product
{
    private Long	identifier;
    private String	name;
    private Long	price;

    public Product( Long identifier, String name, Long price )
    {
        this.identifier = identifier;
        this.name = name;
        this.price = price;
    }

    public void setId( Long id )
    {
        this.identifier = identifier;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public void setPrice( Long price )
    {
        this.price = price;
    }

    public Long getId()
    {
        return ( this.identifier );
    }

    public String getName()
    {
        return ( this.name );
    }

	public Long getPrice()
    {
        return ( this.price );
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
            return ( true );
        if ( o == null || getClass() != o.getClass() )
            return ( false );
        Product product = ( Product ) o;
        return ( Objects.equals( identifier, product.identifier )
            && Objects.equals( name, product.name )
            && Objects.equals( price, product.price ) ); 
    } 

    @Override
    public int hashCode()
    {
        return ( Objects.hash( identifier, name, price ) );
    }

    @Override
    public String toString()
    {
        return ( "Product : {" +
            "\nidentifier=" + identifier +
            ", name=" + name +
            ", price=" + price + "\n}");
    }
}