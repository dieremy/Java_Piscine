package edu.school21.chat.models;

import java.util.LinkedList;

public class Chatroom
{
    private Long ID;
    private String name;
    private User owner;
    private LinkedList<Message> messages;

    public Chatroom( long id, String name, User owner, LinkedList<Message> messages )
    {
        this.ID = id;
        this.name = name;
        this.owner = owner;
        this.messages = messages;
    }

    public void setId( long id )
    {
        this.ID = id;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public void setOwner( User owner )
    {
        this.owner = owner;
    }

    public long getId()
    {
        return ( this.ID );
    }

    public String getName()
    {
        return ( this.name );
    }

    public User getOwner()
    {
        return ( this.owner );
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
            return ( true );
        if ( o == null || getClass() != o.getClass() )
            return ( false );
        Chatroom chatroom = ( Chatroom ) o;
        return ( Object.equals( ID, chatroom.id )
            && Objects.equals( name, chatroom.name )
            && Objects.equals( owner, chatroom.owner )
            && Objects.equals( messages, chatroom.messages ) ); 
    } 

    @Override
    public int hashCode()
    {
        return ( Objects.hash( ID, name, owner, messages ) );
    }

    @Override
    public String toString()
    {
        return ( "Chatroom{" +
            "id=" + ID +
            ", name=" + name +
            ", owner=" + owner +
            ", roomMessages=" + messages + "}");
    }
}