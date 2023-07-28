package edu.school21.models;

import java.util.Objects;

public class Product
{
    private Long	id;
    private String	name;
    private Long	price;

    public Product( Long id, String name, Long price )
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public Long getId()
    {
        return ( this.id );
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
        return ( Objects.equals( id, product.id )
            && Objects.equals( name, product.name )
            && Objects.equals( price, product.price ) ); 
    } 

    @Override
    public int hashCode()
    {
        return ( Objects.hash( id, name, price ) );
    }

    @Override
    public String toString()
    {
        return ( "Product : {" +
            "\nid=" + id +
            ", name=" + name +
            ", price=" + price + "\n}");
    }
}