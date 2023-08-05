# micronote project

# last added features
1.Spring Security with Jwt Authentication<br>
2.Dto and its Converters<br>
3.Custom Exception<br>
4.Checkstyle - check if convenient to coding standard<br>
5.Pagination - to list users and notes<br><br>

This project is about taking notes. There is two type objects named user and note.
I have tried to write an API which has relaitons between objects. I decided to write an app that i need one.
I have experienced RestAPI development, how to work with relationships between entities(one to many...), logic of DTOs and converters, Exception Handling. 

## API Reference

```http
  GET  localhost:8081/api/v1/user/{id}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Long` | **Required**.|


```http
  POST  localhost:8081/api/v1/user
```
| Parameter | Type (request body)     | Description                |
| :-------- | :------- | :------------------------- |
| `body` | `User` | **Required**.|

```http
  PUT localhost:8081/api/v1/user
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `body`      | `User` | **Required**.|

```http
  body: User
  {
  "id" : 2,
  "username" : "",
  "password" : ""
  }
```

```http
  DELETE localhost:8081/api/v1/user/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**.|

## Lessons Learned

- Experience in Dto Logic and how to write dto converter 
- Relations between objects
- Exception Handling

## Tech Stack

**Server:** Java 11, Spring Boot

**Client:** React - not added yet.

**Tools:** Idea, Postman.





## 🔗 Links
[![portfolio](https://img.shields.io/badge/omeraran_cv-000?style=for-the-badge&logo=&logoColor=white)](https://omeraran.github.io/) 

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/omeraran)

## Authors

- [@omeraran](https://www.github.com/omeraran)


## Badges
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)

![omeraran](https://github.com/OmerAran/micronote/blob/main/Screenshot%202023-02-05%20at%2016.05.34.png)


