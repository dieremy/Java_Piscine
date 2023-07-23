package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User
{
    private static long id;
    private static String login;
    private static String password;
    private static List<Chatroom> createdRooms;
    private static List<Chatroom> socialRooms;

    public User( long id, String login, String password, List<Chatroom> createdRooms, List<Chatroom> socialRooms )
    {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.socialRooms = socialRooms;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public void setLogin( String login )
    {
        this.login = login;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public void setCreatedRooms( List<Chatroom> createdRooms )
    {
        this.createdRooms = createdRooms;
    }

    public void setSocialRooms( List<Chatroom> socialRooms )
    {
        this.socialRooms = socialRooms;
    }

    public long getId()
    {
        return ( this.id );
    }

    public String getLogin()
    {
        return ( this.login );
    }

    public String getPassword()
    {
        return ( this.password );
    }

    public List<Chatroom> getCreatedRooms()
    {
        return ( this.createdRooms );
    }

    public List<Chatroom> getSocialRooms()
    {
        return ( this.socialRooms );
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
            && Objects.equals( login, user.login )
            && Objects.equals( password, user.password )
            && Objects.equals( createdRooms, user.createdRooms )
            && Objects.equals( socialRooms, user.socialRooms ) ); 
    } 

    @Override
    public int hashCode()
    {
        return ( Objects.hash( id, login, password, createdRooms, socialRooms ) );
    }

    @Override
    public String toString()
    {
        return ( "id=" + id +
            ", login=" + login +
            ", password=" + password +
            ", createdRooms=" + createdRooms +
            ", rooms=" + socialRooms + "},");
    }
}