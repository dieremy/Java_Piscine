INSERT INTO chat.users ( login, password ) VALUES
( 'Bob', '123456' ),
( 'Jack', '000000' ),
( 'Tony', '654321' ),
( 'Sara', '111111' ),
( 'Mary', '222222' )
ON CONFLICT DO NOTHING;

INSERT INTO chat.rooms ( name, owner ) VALUES
( 'Chat 1', 'Bob' ),
( 'Chat 2', 'Jack' ),
( 'Chat 3', 'Tony' ),
( 'Chat 4', 'Sara' ),
( 'Chat 5', 'Mary' )
ON CONFLICT DO NOTHING;


INSERT INTO chat.messages ( author, room, text, timestamp ) VALUES
( 'Bob', 1, "Hello buddy", "2020-12-21 01:01:01" ),
( 'Jack', 3, " lol", "2020-12-21 02:02:02" ),
( 'Tony', 4 , "lmao", "2020-12-21 03:03:03"),
( 'Sara', 5 , "how are you?", "2020-12-21 04:04:04"),
( 'Mary', 2 , "See you there", "2020-12-21 05:05:05")
ON CONFLICT DO NOTHING;