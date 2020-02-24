# Table of Contents
## 1. Introduction
- 1.1 Purpose
- 1.2 Overview
- 1.3 Glossary
## 2. General Descriptions
- 2.1 Product/System Functions 
- 2.2 User Characteristics and Objectives 
- 2.3 Operational Scenarios
- 2.4 Constraints
## 3. Functional Requirements
- 3.1. Sign Up
- 3.2 Sign in
- 3.3 Concert Listings
- 3.4 Facebook Profile Linker
- 3.5 Link User Data API(s)
- 3.6 Featured Song from a Concerts Artists
- 3.7 Profile Customization
- 3.8 Posts
- 3.9 Song and Playlist Sharing
- 3.10“Follow User” Feature
- 3.11 Notifications
- 3.12 User Feed
- 3.13 Filtering Concert Listings
- 3.14 Concert Interactions; ratings
- 3.15 Rudimentary recommender system
## 4. System Architecture
- 4.1 System Architecture Diagram
## 5. High Level Design
- 5.1 Data Flow Diagram
- 5.2 Logical Data Diagram
- 5.3 Class Diagram
## 6. Schedule


#  CA 326 Functional Specification
*Andrew Cullen, Daniel Rowe, Eoin McKeever*

##  1. Introduction

###  1.1 Purpose
This document’s purpose is to describe the problem that the proposed system, LiveWire, attempts to solve and the implementation of the system at an abstracted level. It will outline the project’s scope, intention and design.

###  1.2 Overview
The project is an Android app which notifies users of upcoming concert events and ticket releases in their local area. These notifications are based on the user’s music tastes and preferences. This system is aimed at solving the problem of finding personalized concerts in a user’s locality, firstly by appropriately listing all local concerts, and then personalizing a user’s concert recommendations based on music data and filtering options. These notifications will be provided passively, through a scrolling “user feed”, accessible through the app, as well as an alerts system for concerts.The user will have their own unique profile which they can use to follow other members and view their activity.Users can share whether they are interested/attending any of the local concerts and their friends will see this activity.The ability to give a 1-5 star rating on attending concerts is also an option.
 

###  1.3 Glossary
- **API -** Application Program Interface. A set of protocols to mandate how software components (usually in a client-server relationship) interact. In essence, a way to access some resource in a restricted/structured manner.

- **System -** Defined very loosely as a set of functions, procedures, “things” and inputs interacting together towards some common goal. 

- **Location Based Services -** Services that make use of a user’s location to provide some functionality. For example, using a phone’s GPS to set their standard language on startup.
recommender system - A way to filter information to match with some criteria that fulfills a user’s expectations. In the context of LiveWire, this would be the filtering of concerts to find ones the user would enjoy going to.

## 2. General Description

### 2.1 Product / System Functions

- **Sign Up -** Register to the LiveWire service.
- **Sign In -** Login to the LiveWire Service
- **Concert Listings -** Standardized page for each concert listing, accessible primarily through a filterable list of concerts. App notifications link directly to the concert page.
- **Facebook Profile Linker -** Link your LiveWire account with your Facebook account, to find your preferred followed users easier.
- **Link User Data API(s) -** Link popular music listening apps for user data, ie. Spotify, Soundcloud. Allows for Location Based Services
- **Featured Song from a Concert’s Artist -** Display a song for each Artist playing at a concert.
- **Profile Customization -** Allow for personalization of a user’s profile, such as a profile’s avatar, tagline, links to social media, etc.
- **Linked Media/Embedded Videos, Photos -** Allows users to share concert experiences through videos, photos, posts.
- **Song and playlist sharing -** Allow users to share or link songs from their linked User Data, regardless of platform.
- **“Follow User” Feature -** Follow users for updates on their experiences at concerts.
- **Notifications -** Notify Users of concerts in their area that they may enjoy. High priority concerts only.
- **User Feed -** Shows interactions of the user and their followed friends. Includes gigs attended by followed users, potentially interesting gigs, etc.
- **Filtering Concert Listings -** Filterable list of concert listings, eg. by date, price range, location.
- **Concert Interactions; ratings -** Give feedback on attended concerts.
- **Rudimentary recommender system -** Basic recommender system to recommend concerts based on Followed artists (Spotify, Soundcloud), most liked genre.

## 2.2 User Characteristics and Objectives
The general user of this system will be music listeners and concert/gig goers. The expected age of our users will vary from young adults upwards. As those who enjoy music concerts may have wildly varying technical ability with Android apps and mobiles in general,  LiveWire will focus on a friendly, easily accessible user interface. The user should expect to be able to easily set up their profile, and find concerts in their local area. For more advanced users, there is the ability to filter concert listings by various parameters such as date, cost ranges and genre. 
Besides this generic user model, there are a few subsets of users to consider:

***Concert Listing Users -*** Users who are looking for a complete list of concerts in their local area or using the recommender system, with the primary aim of finding new music.

***Social Sharers  -*** Users who are looking for a social space to share the gigs they attend. These types of users may be more interested in the interactivity of the LiveWire app.

***“Fan” Users  -*** Users who are avid followers of certain artists, who never want to miss the  most up-to-date concert listings and ticket releases. Complete concert listings and accurate pinging for relevant artists is an importance to them.

## 2.3 Operational Scenarios

#### User Registration
The user will be presented with a page that will request the user to enter a name to act as their profile name followed by a password. If the username is valid the user will advance and be asked to connect their spotify account. If not the user will be prompted to try again. The user will not be able to advance to any feature of LiveWire without a valid profile.


### Sign in
The user will be brought to a page where they will be asked to enter a username and password. Once a user enters a valid account they will advance into the app, if not they will be told the details are invalid and prompted to try again or to register an account. The user will be locked out if they enter 5 invalid attempts, as a standard security precaution.


### Connecting to 3rd Party Functionality (LBS, Facebook Friend Finder)
All users will have the option to connect Facebook with their LiveWire account. This option will appear on the users profile page to connect with friends. Once the button is clicked Facebook's graph API will link the user’s Facebook friends list to their LiveWire account, allowing for immediate connection into their pre-existing music social scene.


### Updating Profile
The user has the option to update their personal profile with a personal avatar to represent themselves. This avatar will be displayed on their profile page. Below the image an option to change the image will be available. Once clicked user will be prompted to input an image, with minor restrictions- such as resolution and image size. If successfully passed, their profile avatar is updated.


### Media Profile Post
Each user has the ability to post images and videos to do with upcoming and attended concerts. From the user’s profile pages an option is given to post images and videos that are related to upcoming events or events passed that the user may have been to. Once they have chosen what to upload, they have the option to tag their post with a concert they attended. They can then confirm the post.

### Concert Interactions (Rating, Interested, Attending)
When viewing a concert, users can confirm they are interested in the event or that they are going to be attending the event. This can be undone with the same button. Alongside this button is a list of followed users that will be attending the concert. This button updates friends of the user, letting them know they are attending/interested.Once the concert date has passed, users will be able to rate their experience in a 1-5 star format.


### Following/Unfollowing User
To follow/unfollow another member of LiveWire, the user must visit the other members profile page where there will be a button to follow or unfollow if already following the member. Navigating to the page requires a simple search for their name or just clicking on a profile found by the imported Facebook friends list.


### Filtering Concert Listings (Concert Searching)
At the top of the users feed there will be a drop down bar where the user can filter based on dates or a price  range i.e high to low, low to high, price cap, or by location. The feed will then update to the newly filtered concert listings.


## 2.4 Constraints
Lists general constraints placed upon the design team, including speed requirements, industry protocols, hardware platforms, and so forth.



### Backend Constraint
Firebase Free will be used to accommodate LiveWire’s database needs, as well as server needs. Firebase Free does not have unlimited accommodation for database size or querying numbers, and these limitations must be taken into consideration.


### Hardware Constraint
The most current stable version of Android will be the primary supported OS. The app will be published via the Google Play Store.


### User Data Constraint
We must comply with GDPR and DCU’s ethics form with regards to how we are storing personal data, for example how long we can store the data and how justifiable it is to collect certain user data. The overall aim of LiveWire when it comes to User Data is to keep only data that the user has expressly permitted us, and of course purge it once the project has been completed.


### Users Requirements Constraint
Each user’s personalized concert notifications must be accurate, or the app will not have done its job. Making sure that each recommendation is of value is an important constraint on our recommender system.


### Time Constraint
The LiveWire application must be completed by the 6th of March 2020. Given the large scale of the project, our scope may need to be adjusted as the project proceeds. This will be dealt with on a rolling basis, as we proceed with our schedule.


### Financial Constraints
As this project is not fully scaled to a business model, the use of media-heavy features such as videos and images must be carefully monitored to prevent data bloat with regards to the scale of the project.


### Safety and Security Constraints
User data will be held within the LiveWire User database, hence security and safety is a key consideration. Proper 


## 3. Functional Requirements
### 3.1 Sign Up

**Description -** The LiveWire app must be able to track unique users to personalize their data and properly provide its feature list. Signing up via the app, making use of the standard registration process of an email-password pairing, is the best way to achieve this and an industry standard.

**Criticality -** Without being able to track individual users, the app is rendered pointless and useless. Therefore, signing up users and uniquely identifying them is a first, crucial step to the system.

**Technical issues -** Security, ease of use and scalability in that order of priority, are the technical issues. Keeping user data secure is of paramount importance and must be solved definitively. Making the sign-up process of LiveWire as painless as possible will also be a technical consideration. Finally, taking early precautions for the potential occurrence of a large number of registered users may save a lot of headaches in the future.

**Dependencies with other requirements -** All other requirements rely on identifying users uniquely, and it is accurate to say that the entire app hinges on this functionality. Conversely, the actual implementation of the sign up feature relies on a working User Database that can be queried, and a working sign up page within the app.


### 3.2 Sign In

**Description - **Signing into the LiveWire app allows users to make use of the LiveWire service as a unique user. LiveWire is solely restricted to registered users, and for this reason, letting users correctly identify themselves is important. Without this restriction and unique identification, LiveWire’s user profiles would be wasted, as well as its recommender system.

**Criticality -** Uniquely identifying users is at the core of the LiveWire service, and the first step in providing them concert listings for their area, or based on their music listening habits. No signing in would render this functionality unfeasible or pointless.

**Technical issues - **Making sure users are correctly identified is the largest difficulty with the sign in functionality. This involves correctly matching the user, password key values to a user in the User Database. Similar to signing up, keeping this data safe and secure is important.

**Dependencies with other requirements -** Almost all requirements in the system require a user to sign in. This is an intentional design choice of LiveWire. For this reason, without a functioning sign in feature, the vast majority of the LiveWire app’s functionality is lost.


### 3.3 Concert Listings

**Description -** The Concert Listing function is the backbone of LiveWire’s functionality. The concert listings will return a list of concerts, each one accessible through the app. Each individual concert listing will show the concert’s date, time, cost, lineup and venue, among other relevant details. Combining these listings into the concert list, stored in a database, will allow for querying by users. When needed, Concert Listings in various forms (filtered, unfiltered, location based) must be made available for different functions of the LiveWire app.

**Criticality -** The Concert Listing is a major part of LiveWire’s function and is therefore critically important. Without a robust list of attribute-tagged concerts, the LiveWire system loses much of its features.

**Technical issues -** Although LiveWire makes use of many expansive APIs, the provided queried data to create this concert listing may not be error-free. Duplicate concerts, unfilled data attributes and errors from the API data itself are all considerations to have when checking the veracity of the concert listings data.

**Dependencies with other requirements -** Many of the personalization and user interaction requirements rely on an available concert listing to query. Opposite this, the concert listing function relies on the concert aggregation API’s to work properly. Without these, there will be no list of concerts to base other LiveWire functions off.

### 3.4 Facebook Profile Linker

**Description -** The app must be able to link with the user’s Facebook account in order to find their already existing Facebook friends’ accounts on the LiveWire app. This will use Facebook’s Graph API in order to receive their friends list. 

**Criticality - **Linking users with their Facebook friends is critical to creating a network which will be used to provide the app with data for the user’s feed and providing the user with possible interactions with said friends. Without using this it would require users to find friends individually using information such as their email address which is far too time consuming for the user. 

**Technical issues -** A few issues may arise when implementing this idea. Acquiring permission from Facebook to access the user’s data, in terms of implementation the feature must of course link to the correct profiles and be secure with the user’s data. 

**Dependencies with other requirements -** This feature is dependant on the fact that the user has his own account and has a facebook account. Following friends is dependant on this and in part the feed and user interaction is in turn. The user must be connected to friends in order to interact with and receive updates from them.

### 3.5 Link User Data API(s)

**Description -** This app will be relying on various APIs for filtering our concert listings. These APIs with be linked via an option in the sidebar of the app. This will require the user to input their username/email linked with their relevant third party account. These app will include their Spotify and/or Soundcloud as well as allowing access to their device’s Location Based Services. 

**Criticality -** This is critical as it will allow users to filter their concert listings. It also allows users to link media from said accounts. 

**Technical issues -** Linking said APIs is only difficult as we must acquire permission from both the user and the third party. Difficulty may arise when following the third party’s terms of use in our app.

**Dependencies with other requirements -** This is only dependant on the user login and signup. However many features are dependant on these APIs. Such as the concert filtering and so the notifications and user feeds. Media sharing is partially dependant on this also if said media must be linked from this users relevant account. 

### 3.6. Featured Song from a Concert’s Artist

**Description -** For each concert listing, if the artist is on Spotify, there will be a featured song by the artist. This allows for users to quickly gauge an artist’s genre and compatibility. The featured song, as it is based upon their spotify page, will directly grab their most popular song. Using Spotify’s embedded song player allows for direct playback of the song.

**Criticality -**  This feature has no real effect upon any other functions within the system. The biggest impact it may have is in affecting how the concerts and concert listings are displayed.

**Technical issues -** Many of the headaches of online song streaming is dealt with by Spotify’s embedded song player. Playback, the user interface and volume are dealt with through the mini-player. Displaying the song in an unobtrusive manner is the biggest hurdle to overcome.

**Dependencies with other requirements -** Relies upon Spotify’s embedded song player. Affects the display of concerts on the concert listing.

### 3.7 Profile Customization

**Description -** Profile customisation refers to the ability of the user to add media to their user profile page. This includes a user’s avatar. 

**Criticality -** This is critical as it provides variety and personality to each user on the site. Without this each account would appear as a clone of another.

**Technical issues -** As below in posts the issues that arise from uploading media such as photos is the amount of data being uploaded to the server, implementing the media upload function itself and retrieving said media when viewed by another user.

**Dependencies with other requirements -** This is dependant on media uploading functionality and server data retrieval. There are no dependencies on profiles being uniquely customized however. 

### 3.8 Posts
**Description -** The post function allows for the sharing of videos and images, potentially being attached to an attended concert. This post can be viewed by users who follow the posting user, as well as those viewing the concert, assuming it was attached to said concert.

**Criticality -** User interaction and community participation is an important aspect of the goal of the LiveWire app, however it is not necessary for the core functionality of the system- concert listings and concert notifications. Because of this, while it is not necessary for core functionality, it is one of the most important “social” functions.

**Technical issues -** A posting function relies on uploading media, associating it with concerts, and sharing it on the feed of users who follow the posting user. These are all individual problems that need to be addressed, although they are not particularly complicated. The largest issue facing this function is the user interface portion of it- the entire concept of posting hinges on positive user interactions and ease-of-use, which will be the main considerations when implementing this function.

**Dependencies with other requirements -**  As the posting function is a conduit for users to react to the functionality of the LiveWire app, it is reliant on the core features of it, such as concert listings, User Data access, notifications… Dependant functions are ones that change the user’s public state. This may mean an updated profile avatar or a playlist.

### 3.9 Song and Playlist Sharing

**Description -** This will allow users to link songs using Spotify, Soundcloud and embedded Youtube videos and post said link to their profiles. This will show up on the user’s friend’s feeds and the user’s profile page. These links can be posted individually or in groups which allows the unique functionality of having cross platform playlists. 

**Criticality -** This feature is critical in the social aspect of the app, turning the platform to a music hub of sorts, not just a concert related platform. 

**Technical issues -** It may not be possible to continuously play multiple songs in a single post continuously. Formatting these playlists into something visually appealing may also be a challenge.  

**Dependencies with other requirements -** This feature is dependant on many of the app’s features. The user login/signup, linking user’s third party API’s and partially on the ability for user to follow each other as said posts wouldn’t be viewed without this.

### 3.10 “Follow User” Feature

**Description -** The simple social media aspect of the platform is allowed through the follow feature. Each user will be able to follow people they find on the platform and can follow their friends using the Facebook linker which will provide a suggested friends functionality. 

**Criticality -** This is critical to the social side of the platform a it is the only way people can consistently see other people’s posts on the app. This can allow for friend groups, like minded music listeners and communities to stay connected. 

**Technical issues -** The follow feature will require its own part in the UI. The suggested follow feature may also need a lot of attention.

**Dependencies with other requirements -** This will be largely dependant on the Facebook linker in order for a user to find their friends on the platform. It could also be said that is has a dependency on profile customisation in order for users to recognise people in the case of people having the same name on the platform etc. Following users is of course also dependent on user login and signup. Notifications and the user feed are partially dependant on the follow feature as it is a data source for both. 

### 3.11 Notifications

**Description -** Based on the recommender system. Very high priority concerts and ticket releases will give an alert to their device when found by LiveWire. 

**Criticality -** This is a core feature of LiveWire this stops users from missing any concert or ticket release of their favourite artists in their local area. 

**Technical issues -** The recommender system of course can be very complicated to implement and so we may have to sacrifice some of the complexity of similar systems for a more concrete and reliable approach. 

**Dependencies with other requirements - **The notifications rely on almost every aspect of the app. Signup, concert listings and filtering , linking of user data apis. It will require all of the data we collect of the users listening and attendance habits. 

### 3.12 User Feed

**Description -**  The information that will be displayed based on user's music preferences and members followed. 

**Criticality - **This is the main part of the app that the user will interact with it shows all the concerts that the app wants to recommend to the user.

**Technical issues -** For the feed to be effective it needs to be a well designed easy to read part of the app as the user will be engaging with it the majority of the time they send on the app.Needs to be constantly update which could take some time to implement

**Dependencies with other requirements -** relies on receiving information from a user profiles based on their music preferences and friends list to create the user feed. 

### 3.13 Filtering Concert Listings

**Description -** Will be a process for the user to remove unwanted concert listing from their feed.

**Criticality -** This is critical to those users which want personalised concert listings and notifications. This is the app’s core functionality and is what we hope would draw users in. Without this feature the user could only possibly have a broad list of concerts in their feed with no adjustment for music taste or their location. 

**Technical issues -** To create an accurate filtering tool will need to understand how to manipulate the data we have to organise and sort it.

**Dependencies with other requirements -** This portion of the project will be dependent on the information given on the feed as the filtering mechanism will work on this data




### 3.14 Concert Interactions; ratings

**Description -**  Concerts found in concert listings, to expand upon the social aspect of the LiveWire app, can be interacted with. This entails rating attended apps, or tagging them “Attending” or “Interested”. 

**Criticality -** This does not affect the core functionality of the LiveWire app, but is an important feedback parameter for users who attended a concert, or for those who show interest in certain concerts. It is a small portion of the social aspect of LiveWire, and is not critical.

**Technical issues - **The biggest technical issue will be making sure that users don’t forget to rate concerts they attended, or are given ample opportunity to remember both the concerts they are attending and actually having the ability to mark concerts as such. This is primarily a UI problem, but an important one for enjoyable user interactions.

**Dependencies with other requirements -** Relies upon Concert Listings primarily, and the User Feed functioning properly.

### 3.15 Rudimentary recommender system

**Description -** The functionality of the recommender system will be finalized later on in the project, however the overall aim will be the same. The recommender system will send notifications to users of concerts they may be interested in. These notifications should prioritize accurately recommending concerts that the user will be interested in, instead of sending notifications whenever there is some chance the user may like the concert. In other words, there should be a very high chance the user will appreciate the notification.

The recommender system will use several different methods to generate reliably accurate concert recommendations. Any artists the user follows on Spotify will signify an artist they will be notified of. This can be expanded to any of their top listened to artists, artists that exist within their playlists, and even genres that they gravitate towards. Once more, this can all be achieved with relative ease using Spotify’s API.

Spotify’s API can be further used to get a list of recommended artists, based upon an artist “seed”. This, alongside the retrieval of a song’s attributes- once more tagged by Spotify- can allow for pattern matching between artists.

**Criticality -** This function may be a large draw for potential users of LiveWire. The large task of accurately recommending concerts lowers its importance due to time constraints, however. The overall aim is to implement a simple recommender system and expand upon it if time allows.

**Technical issues -** Recommender systems can be a massive undertaking, so a very important issue is to limit the scope of what our recommender system can do. By restricting our expectations and making smart use of the Spotify API to do a lot of the heavy work, we can implement a useful recommender system while still implementing the rest of our system functions

**Dependencies with other requirements -** The recommender system primarily relies upon the Spotify API. Notifications make use of the recommender system.

## 4. System Architecture
High level view of the interactions between systems involved in the LiveWire service. Users interact with the App system, loosely grouped as the GUI, API queries and the Kotlin programming functionality. This in turns interacts with the databases holding both user data and concert data.

![](https://gitlab.computing.dcu.ie/cullea37/2020-ca326-livewire/raw/master/functional_spec/img3.jpg)

## 5. High Level Design

### 5.1 Data Flow Diagram
Data flow diagrams visualise how the data flows through a system and how to system fundamentally communicates across itself. It shows the relationships between the databases,the entities and the processes involved.


![](https://gitlab.computing.dcu.ie/cullea37/2020-ca326-livewire/raw/master/functional_spec/img2.jpg)





### 5.2 User Flow Diagram
The user flow diagram gives a basic overview of how the app interactions will generally flow.


![](https://gitlab.computing.dcu.ie/cullea37/2020-ca326-livewire/raw/master/functional_spec/img4.jpg)
### 5.3 Class Diagram
Class diagrams show the relations between classes. 

![](https://gitlab.computing.dcu.ie/cullea37/2020-ca326-livewire/raw/master/functional_spec/img1.jpg)

## Schedule

![](https://gitlab.computing.dcu.ie/cullea37/2020-ca326-livewire/raw/master/functional_spec/gantt.png)
