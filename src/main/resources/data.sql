USE local_venues;

-- Insert sample data for venues
INSERT INTO Venue (ID, Name, Location, Description, Facility_Details, Opening_Hours, Type, Fee, Zip_code,
                   Contact_Information, Website, image_Url)
VALUES (1, 'Market Square', '101 Market St', 'Outdoor market with local vendors', 'Public restrooms, Parking',
        '9am - 5pm', 'Market', 0, '90001', 'info@marketsquare.com', 'http://marketsquare.com',
        'https://dynamic-media-cdn.tripadvisor.com/media/photo-o/10/74/37/a3/signage.jpg?w=1200&h=-1&s=1'),
       (2, 'Event Horizon', '2021 Event Ave', 'Event space with modern amenities', 'Audio/Video equipment, Catering',
        '8am - 11pm', 'Event Space', 300, '90002', 'contact@eventhorizon.com', 'http://eventhorizon.com',
        'https://news.asu.edu/sites/default/files/styles/asu_news_article_hero/public/dsc07708.jpeg?itok=PSB-61SX'),
       (3, 'Green Yard', '303 Green Rd', 'Open space for outdoor activities', 'Playground, Benches', '6am - 9pm',
        'Yard Sale', 0, '90003', 'greenyard@green.com', 'http://greenyard.com',
        'https://images.squarespace-cdn.com/content/v1/5d01a7efbf4ae50001f78eaf/1611850446685-C8QITUOZ43Z2Y5SUKSJI/Figure+4.jpg'),
       (4, 'Urban Gallery', '404 Art St', 'Art gallery and event venue', 'Exhibition space, Workshop rooms',
        '10am - 6pm', 'Gallery', 200, '90004', 'info@urbangallery.com', 'http://urbangallery.com',
        'https://uploads.tickettailor.com/c_fill,h_627,w_1200/v1/production/userfiles/lstgljiptca8eazwhzbe.jpg?_a=BAAARODQ'),
       (5, 'Beachside Boardwalk', '505 Beach Blvd', 'Scenic beachside area for events',
        'Shower stations, Public toilets', '5am - 12am', 'Outdoor', 0, '90005', 'info@beachboardwalk.com',
        'http://beachboardwalk.com',
        'https://res.klook.com/image/upload/fl_lossy.progressive,q_85/c_fill,w_680/v1678431512/blog/t9hg3hmywow73e3zlqc3.jpg');

-- Insert sample data for vendors
INSERT INTO Vendor (ID, Name, Description, Contact_Information, Website, image_Url)
VALUES (1, 'Catering Delights', 'Catering services for all events', 'catering@delights.com',
        'http://cateringdelights.com',
        'https://www.davisfarmersmarket.org/wp-content/uploads/2018/09/lloyd-the-farmer-davis-market-20180912.jpg'),
       (2, 'Party Planners', 'Event planning and organization services', 'contact@partyplanners.com',
        'http://partyplanners.com',
        'https://www.davisfarmersmarket.org/wp-content/uploads/2018/08/DavisBreadsDesserts-225x300.jpg'),
       (3, 'Fresh Farm Produce', 'Organic produce directly from our farm', 'farm@freshproduce.com',
        'http://freshfarmproduce.com',
        'https://www.davisfarmersmarket.org/wp-content/uploads/2020/07/CopperGrasshopper2020-300x225.jpg'),
       (4, 'Soundwave Entertainment', 'DJ and audio services for events', 'info@soundwave.com',
        'http://soundwaveentertainment.com',
        'https://www.davisfarmersmarket.org/wp-content/uploads/2021/01/Good-Faith-Farm-olives-and-oil-300x195.jpg'),
       (5, 'Floral Fantasy', 'Florist services for all occasions', 'orders@floralfantasy.com',
        'http://floralfantasy.com',
        'https://www.davisfarmersmarket.org/wp-content/uploads/2020/08/YanezFarms-300x225.jpg');

-- Insert sample data for users
INSERT INTO User (ID, Email, first_name, Last_name, Password, phone_number, username)
VALUES (1, 'test@test.com', 'testFN', 'testLN', '$2a$12$cEaT3LNdOz9M27hW/LeUVewozLqUhFsKr2BzBWB1G1TvWSTv7gwS.',
        '555-1234', 'test_john_doe'),
       (2, 'alice@example.com', 'Alice', 'Smith', '$2a$12$cEaT3LNdOz9M27hW/LeUVewozLqUhFsKr2BzBWB1G1TvWSTv7gwS.',
        '555-5678', 'alice_smith'),
       (3, 'bob@example.com', 'Bob', 'Johnson', '$2a$12$cEaT3LNdOz9M27hW/LeUVewozLqUhFsKr2BzBWB1G1TvWSTv7gwS.',
        '555-9012', 'bob_johnson'),
       (4, 'carol@example.com', 'Carol', 'White', '$2a$12$cEaT3LNdOz9M27hW/LeUVewozLqUhFsKr2BzBWB1G1TvWSTv7gwS.',
        '555-3456', 'carol_white'),
       (5, 'dave@example.com', 'Dave', 'Brown', 'hashed_password_5', '555-5555', 'dave_brown');


-- Insert sample data for reviews
INSERT INTO Review (ID, Content, Rating, created_date, last_edit_date, User_ID, Venue_ID, Vendor_ID)
VALUES (1, 'Had an unpleasant experience with a vendor at Market Square.', 3, '2023-11-11 22:15:50',
        '2023-11-10 22:15:50', 4, 2, NULL),
       (2, 'Event Horizon hosted our corporate event, and it was flawless.', 4, '2023-11-06 22:15:50',
        '2023-11-18 22:15:50', 2, NULL, 1),
       (3, 'Exceptional experience at Market Square! Fresh products and friendly vendors.', 3, '2023-10-29 22:15:50',
        '2023-10-25 22:15:50', 5, NULL, 5),
       (4, 'Green Yard is perfect for family outings. The kids loved the playground.', 2, '2023-11-10 22:15:50',
        '2023-11-03 22:15:50', 1, 2, NULL),
       (5, 'Event Horizon hosted our corporate event, and it was flawless.', 5, '2023-10-23 22:15:50',
        '2023-11-08 22:15:50', 5, 3, NULL),
       (6, 'Market Square has a decent selection, but some vendors are overpriced.', 1, '2023-11-17 22:15:50',
        '2023-11-10 22:15:50', 5, 5, NULL),
       (7, 'Green Yard could be a great spot, but it is poorly maintained.', 3, '2023-11-05 22:15:50',
        '2023-11-13 22:15:50', 2, NULL, 4),
       (8, 'Had an unpleasant experience with a vendor at Market Square.', 3, '2023-10-26 22:15:50',
        '2023-10-21 22:15:50', 5, 4, NULL),
       (9, 'Event Horizon is a nice venue, but the parking can be a nightmare.', 5, '2023-10-21 22:15:50',
        '2023-10-31 22:15:50', 4, 1, NULL),
       (10, 'Urban Gallery''s art collection is breathtaking. A must-visit for art enthusiasts.', 3,
        '2023-10-19 22:15:50', '2023-10-31 22:15:50', 3, 2, NULL),
       (11, 'Visited Urban Gallery and was underwhelmed. The collection is small and not well-curated.', 2,
        '2023-11-09 22:15:50', '2023-11-13 22:15:50', 2, 1, NULL),
       (12, 'Urban Gallery''s art collection is breathtaking. A must-visit for art enthusiasts.', 4,
        '2023-10-27 22:15:50', '2023-10-31 22:15:50', 1, NULL, 2),
       (13, 'Green Yard could be a great spot, but it''s poorly maintained.', 1, '2023-10-20 22:15:50',
        '2023-10-29 22:15:50', 4, 3, NULL),
       (14, 'A hidden gem in the heart of the city! The atmosphere was inviting, and the staff went above and beyond.',
        1, '2023-10-29 22:15:50', '2023-11-16 22:15:50', 5, NULL, 4),
       (15, 'Urban Gallery''s art collection is breathtaking. A must-visit for art enthusiasts.', 1,
        '2023-11-15 22:15:50', '2023-11-14 22:15:50', 3, 1, NULL),
       (16, 'Visited Urban Gallery and was underwhelmed. The collection is small and not well-curated.', 5,
        '2023-10-21 22:15:50', '2023-11-08 22:15:50', 3, 2, NULL),
       (17, 'Event Horizon is a nice venue, but the parking can be a nightmare.', 5, '2023-11-04 22:15:50',
        '2023-11-08 22:15:50', 3, NULL, 2);

-- Insert sample data for roles
INSERT INTO Role (ID, name)
VALUES (0, 'ROLE_USER');
-- (1, 'Admin'),
-- (2, 'User'),
-- (3, 'Vendor'),
-- (4, 'VenueProvider'),
-- (5, 'Customer');

-- Insert sample data for roles-user
INSERT INTO user_roles (role_id, user_id)
VALUES (0, 1),
       (0, 2),
       (0, 3),
       (0, 4),
       (0, 5);
