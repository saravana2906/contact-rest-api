# Contact-Rest-Api

Contact Management rest API project for learning built using various concepts.
Learned concepts are follows 
- Never applied paging and sorting repository before , its good learning 
  - Sort can be list of various columns ordering (descending/ascending) (https://bezkoder.com/spring-boot-pagination-sorting-example/)
  - Offset - Page number
  - size of each page 
  - Pageable interface or PageRequest.of(offset,size,sort) to create pageable object and receive Page&lt;T&gt;
- Previously used HAL - Hypertext Appliaction language (Hypermedia) but felt its too much of links - navgational links
- OAuth Resource Server 
- JWT Authorisation and its converters
- Annotation related to security to obtain principle object from current security contect , AuthenticationPrinciple to get jwt.
- Need to use power of Spring expression language with function calling.
- Need to understand postAuthorize and preAuthorize usage - roles given by client scope or by realm.(Used Keycloak for OAuth)

Open questions
- How to access swagger url while JWT authetentication enabled ? Tried swagger-url with ant matchers to permit all but it affected other urls.
    - Bad idea to access the swagger url is , used modify http header chrome browser plugin and added manually generated oauth token to all request.
- Even if i found way to allow swagger url alone separately , how to protect it in production?

