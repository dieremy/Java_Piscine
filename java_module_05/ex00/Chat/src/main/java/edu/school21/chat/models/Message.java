package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message
{
    private long id;
    private User author;
    private Chatroom room;
    private String text;
    private LocalDateTime localDateTime;

    public Message( long id, User author, Chatroom room, String text, LocalDateTime localDateTime )
    {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.localDateTime = localDateTime;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public void setAuthor( User author )
    {
        this.author = author;
    }

    public void setRoom( Chatroom room )
    {
        this.room = room;
    }

    public void setText( String text )
    {
        this.text = text;
    }

    public void setLocalDateTime( LocalDateTime localDateTime )
    {
        this.localDateTime = localDateTime;
    }

    public long getId()
    {
        return ( this.id );
    }

    public User getAuthor()
    {
        return ( this.author );
    }

    public Chatroom getRoom()
    {
        return ( this.room );
    }

    public String getText()
    {
        return ( this.text );
    }

    public LocalDateTime getLocalDateTime()
    {
        return ( this.localDateTime );
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
            return ( true );
        if ( o == null || getClass() != o.getClass() )
            return ( false );
        Message message = ( Message ) o;
        return ( Objects.equals( id, message.id )
            && Objects.equals( author, message.author )
            && Objects.equals( room, message.room )
            && Objects.equals( text, message.text )
            && Objects.equals( localDateTime, message.localDateTime ) ); 
    } 

    @Override
    public int hashCode()
    {
        return ( Objects.hash( id, author, room, text, localDateTime ) );
    }

    @Override
    public String toString()
    {
        return ( "Chatroom{" +
            "id=" + id +
            ", author=" + author +
            ", room=" + room +
            ", text=" + text +
            ", localDateTime=" + localDateTime + "}");
    }
}