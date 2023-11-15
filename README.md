# Website_local_venues

A web platform akin to Yelp, but with a unique focus on invigorating local markets by promoting small and independent
businesses. 

# Local Venues Database Schema

## Overview
This document outlines the database schema for the Local Venues application, detailing the entities, their attributes, and relationships.

## Entities and Attributes

### Venue
- **ID:** Primary Key. A unique identifier for each venue.
- **Name:**  The name of the venue.
- **Location (Address):**  The physical address of the venue.
- **Description:**  A detailed description of the venue.
- **Facility Details:** Information about the facilities available at the venue.
- **Opening Hours:** The hours during which the venue is open.
- **Type:** The type of venue (e.g., Market, Event Space, Yard Sale).
- **Fee:** The fee charged for using the venue.
- **Zipcode:** The zipcode of the venue.
- **Contact Information:**  Contact details of the venue.
- **Website:** The website of the venue.


### Vendor
- **ID:** Primary Key, INT. A unique identifier for each vendor.
- **Name:** VARCHAR(255). The name of the vendor.
- **Description:** TEXT. A description of the services or goods provided by the vendor.
- **Contact Information:** VARCHAR(255). Contact details of the vendor.
- **Website:** The website of the venue.

### User
- **ID:** Primary Key, INT. A unique identifier for each user.
- **Username:** The chosen username of the user.
- **Password:** A hashed password for user authentication.
- **First Name:** The user's first name.
- **Last Name:** The user's last name.
- **Email:** The user's email address.
- **Phone Number:** The user's phone number.

### Review
- **ID:** Primary Key, INT. A unique identifier for each review.
- **Content:** The textual content of the review.
- **Rating:**  A numerical rating associated with the review.
- **Date:** The date when the review was posted.
- **User ID:** Links the review to the user who posted it.
- **Venue ID:** (nullable). Links the review to a venue, if applicable.
- **Vendor ID:** (nullable). Links the review to a vendor, if applicable.

### Role
- **ID:** Primary Key, INT. A unique identifier for each role.
- **Role Name:**  The name of the role (e.g., Admin, Vendor, User, VenueProvider).

## Relationships

### Venue-Vendor Relationship
- **Many-to-many:** A venue can host multiple vendors, and a vendor can attend multiple venues.

### User-Role Relationship
- **One-to-many:** A user is associated with one specific role (Admin, Vendor, Customer, Venue Provider).

### Review-Venue and Review-Vendor Relationships
- **One-to-many:** Reviews can be associated with either a venue or a vendor, or potentially both.

