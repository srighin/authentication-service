# authentication-service
The service will authenticate and authorize user to access resources

Curl command to register User:
```
{
    "firstName": "FirstName",
    "lastName": "LastName",
    "username": "userName",
    "email": "anyemailId@gmail.com",
    "phoneNumber": "9000 0000",
    "password": "password"
}
```

Before Accessing the resources. User Need to provide Username and Password to authenticate to the system.

```aidl
UserName: userName
Password: password
```


