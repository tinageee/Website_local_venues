USE
local_venues;

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
INSERT INTO Review (ID, Content, Rating, Date, User_ID, Venue_ID, Vendor_ID)
VALUES (1, 'Great experience at Market Square!', 5, '2023-01-01', 1, 1, NULL),
       (2, 'Loved the ambiance of Event Horizon.', 4, '2023-01-02', 2, Null, 2),
       (3, 'Green Yard was perfect for our family day.', 5, '2023-01-03', 3, 3, NULL),
       (4, 'Urban Gallery had an amazing exhibition.', 4, '2023-01-04', 4, NULL, 4),
       (5, 'Beachside Boardwalk was a bit crowded but fun.', 3, '2023-01-05', 5, 5, 5),
       (6, 'test!', 1, '2023-01-01', 1, 1, NULL);

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
