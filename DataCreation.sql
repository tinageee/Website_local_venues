USE local_venues;

-- Insert sample data for venues
INSERT INTO Venue (ID, Name, Location, Description, Facility_Details, Opening_Hours, Type, Fee, Zip_code, Contact_Information, Website) VALUES
(1, 'Market Square', '101 Market St', 'Outdoor market with local vendors', 'Public restrooms, Parking', '9am - 5pm', 'Market', 0, '90001', 'info@marketsquare.com', 'http://marketsquare.com'),
(2, 'Event Horizon', '2021 Event Ave', 'Event space with modern amenities', 'Audio/Video equipment, Catering', '8am - 11pm', 'Event Space', 300, '90002', 'contact@eventhorizon.com', 'http://eventhorizon.com'),
(3, 'Green Yard', '303 Green Rd', 'Open space for outdoor activities', 'Playground, Benches', '6am - 9pm', 'Yard Sale', 0, '90003', 'greenyard@green.com', 'http://greenyard.com'),
(4, 'Urban Gallery', '404 Art St', 'Art gallery and event venue', 'Exhibition space, Workshop rooms', '10am - 6pm', 'Gallery', 200, '90004', 'info@urbangallery.com', 'http://urbangallery.com'),
(5, 'Beachside Boardwalk', '505 Beach Blvd', 'Scenic beachside area for events', 'Shower stations, Public toilets', '5am - 12am', 'Outdoor', 0, '90005', 'info@beachboardwalk.com', 'http://beachboardwalk.com');

-- Insert sample data for vendors
INSERT INTO Vendor (ID, Name, Description, Contact_Information, Website) VALUES
(1, 'Catering Delights', 'Catering services for all events', 'catering@delights.com', 'http://cateringdelights.com'),
(2, 'Party Planners', 'Event planning and organization services', 'contact@partyplanners.com', 'http://partyplanners.com'),
(3, 'Fresh Farm Produce', 'Organic produce directly from our farm', 'farm@freshproduce.com', 'http://freshfarmproduce.com'),
(4, 'Soundwave Entertainment', 'DJ and audio services for events', 'info@soundwave.com', 'http://soundwaveentertainment.com'),
(5, 'Floral Fantasy', 'Florist services for all occasions', 'orders@floralfantasy.com', 'http://floralfantasy.com');

-- Insert sample data for users
INSERT INTO User (ID, Email, first_name,Last_name, Password, phone_number, username)
VALUES 
(1, 'test@test.com', 'testFN', 'testLN', '$2a$12$cEaT3LNdOz9M27hW/LeUVewozLqUhFsKr2BzBWB1G1TvWSTv7gwS.', '555-1234', 'test_john_doe'),
(2, 'alice@example.com', 'Alice', 'Smith', '$2a$12$cEaT3LNdOz9M27hW/LeUVewozLqUhFsKr2BzBWB1G1TvWSTv7gwS.', '555-5678', 'alice_smith'),
(3, 'bob@example.com', 'Bob', 'Johnson', '$2a$12$cEaT3LNdOz9M27hW/LeUVewozLqUhFsKr2BzBWB1G1TvWSTv7gwS.', '555-9012', 'bob_johnson'),
(4, 'carol@example.com', 'Carol', 'White', '$2a$12$cEaT3LNdOz9M27hW/LeUVewozLqUhFsKr2BzBWB1G1TvWSTv7gwS.', '555-3456', 'carol_white'),
(5, 'dave@example.com', 'Dave', 'Brown', 'hashed_password_5', '555-5555', 'dave_brown');


-- Insert sample data for reviews
INSERT INTO Review (ID, Content, Rating, Date, User_ID, Venue_ID, Vendor_ID) VALUES
(1, 'Great experience at Market Square!', 5, '2023-01-01', 1, 1, NULL),
(2, 'Loved the ambiance of Event Horizon.', 4, '2023-01-02', 2, Null, 2),
(3, 'Green Yard was perfect for our family day.', 5, '2023-01-03', 3, 3, NULL),
(4, 'Urban Gallery had an amazing exhibition.', 4, '2023-01-04', 4, NULL, 4),
(5, 'Beachside Boardwalk was a bit crowded but fun.', 3, '2023-01-05', 5, 5, 5);

-- Insert sample data for roles
INSERT INTO Role (ID, name) VALUES
(0,'User');
-- (1, 'Admin'),
-- (2, 'User'),
-- (3, 'Vendor'),
-- (4, 'VenueProvider'),
-- (5, 'Customer');

-- Insert sample data for roles-user
INSERT INTO user_roles (role_id, user_id) VALUES (0, 1),(0,2),(0,3),(0,4),(0,5);
