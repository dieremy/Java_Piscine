INSERT INTO chat.users ( login, password ) VALUES
( 'Bob', '123456' ),
( 'Jack', '000000' ),
( 'Tony', '654321' ),
( 'Sara', '111111' ),
( 'Mary', '222222' )
ON CONFLICT DO NOTHING;

INSERT INTO chat.rooms ( name, owner ) VALUES
( 'Chat 1', 1 ),
( 'Chat 2', 2 ),
( 'Chat 3', 3 ),
( 'Chat 4', 4 ),
( 'Chat 5', 5 )
ON CONFLICT DO NOTHING;


INSERT INTO chat.messages ( author, room, text, timestamp ) VALUES
( 1, 1, 'Hello buddy', '2020-12-21 01:01:01' ),
( 2, 3, 'lol', '2020-12-21 02:02:02' ),
( 3, 4 , 'lmao', '2020-12-21 03:03:03'),
( 4, 5 , 'how are you?', '2020-12-21 04:04:04'),
( 5, 2 , 'See you there', '2020-12-21 05:05:05')
ON CONFLICT DO NOTHING;