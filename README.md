# authentication-service
The service will authenticate and authorize user to access resources

Curl command to register User:

```
BaseUrl: http://localhost:8080/api/auth/signup

Request Body:

{
    "firstName": "firstName",
    "lastName": "LastName",
    "username": "user",
    "email": "firstName.lastName@gmail.com",
    "phoneNumber": "99000000",
    "password": "password",
    "roles": ["ROLE_ADMIN"]
}

Response:

{
    "message": "User registered successfully!"
}
```

Sign In request and response details

```aidl
BaseUrl: http://localhost:8080/api/auth/signin

Request Body: 

{
    "username": "user",
    "password": "password"
}

Response Body:

{
    "id": "622e383cfbb7fe780734ada2",
    "username": "user",
    "email": "firstName.lastName@gmail.com",
    "roles": [
        "ROLE_USER"
    ],
    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjQ3MTk2NzMyLCJleHAiOjE2NDcyODMxMzJ9.sVGkpv4upM3bHhF6EdX9fKPmwP7R-cmlqK-MJ0kq61MIRptGyOOQH0Be9Nwcf9EXiNPJnZV459zvRM3eX0OmGw",
    "tokenType": "Bearer"
}
```




