Feature: Api Test
As a test automation developer 
I get a list of blog posts using the API endpoint
user should have posts and
each blog post should have a unique ID
 

@countingPostPerUser
Scenario: Counting posts for user   
When I get a list of blog posts using the API endpoint
Then user should have posts.		
| 5    |10 |
| 7    |10 |
| 9    |10 |

@uniqueIdPerPost
Scenario: Unique ID per post
When I get a list of blog posts using the API endpoint
Then each blog post should have a unique ID