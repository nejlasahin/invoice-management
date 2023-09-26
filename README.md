# Invoice Management Project

## Used Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- OpenAPI documentation
- Lombok
- H2 database

## Install & Run With Maven

*$PORT: 8080*

```ssh

git clone https://github.com/nejlasahin/invoice-management.git

$ cd spring-shortened-url
$ mvn clean install
$ java -jar target/*.jar

```

## Swagger UI will be run on this url

`http://localhost:${PORT}/swagger-ui.html`

## API Endpoints

![endpoints](./docs/open_api.png)

## Postman Collections

You can access the postman collection [here.](https://github.com/nejlasahin/invoice-management/blob/master/docs/Invoice%20Management.postman_collection.json)

## Curl Commands

### [USER] login
```ssh

curl --location --request POST 'http://localhost:8080/api/v1/users/login' \
--header 'accept: */*' \
--header 'Content-Type: application/json' \
--data-raw '{
  "email": "johndoe@invoice.com",
  "password": "456789"
}'

```

### [PRODUCT] create
```ssh

curl --location --request POST 'http://localhost:8080/api/v1/products/create' \
--header 'accept: */*' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huZG9lQGludm9pY2UuY29tIiwiaWF0IjoxNjk1NTkxOTExLCJleHAiOjE2OTU1OTI1MTV9.UCUexb8NPr2-ZN3EM5u9jZeANobpnoNgWG2Ne1fBoi03UG6Z6hXWhIrPFkTr6gY3tWNOSsEhvjT9rR6ITS0LXw' \
--header 'Content-Type: application/json' \
--data-raw '{
  "productName": "TR007"
}'

```

### [PRODUCT] all
```ssh

curl --location --request GET 'http://localhost:8080/api/v1/products/all' \
--header 'accept: */*' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huZG9lQGludm9pY2UuY29tIiwiaWF0IjoxNjk1NTkxOTExLCJleHAiOjE2OTU1OTI1MTV9.UCUexb8NPr2-ZN3EM5u9jZeANobpnoNgWG2Ne1fBoi03UG6Z6hXWhIrPFkTr6gY3tWNOSsEhvjT9rR6ITS0LXw'

```

### [BILL] create
```ssh

curl --location --request POST 'http://localhost:8080/api/v1/bills/create' \
--header 'accept: */*' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huZG9lQGludm9pY2UuY29tIiwiaWF0IjoxNjk1NTkxOTExLCJleHAiOjE2OTU1OTI1MTV9.UCUexb8NPr2-ZN3EM5u9jZeANobpnoNgWG2Ne1fBoi03UG6Z6hXWhIrPFkTr6gY3tWNOSsEhvjT9rR6ITS0LXw' \
--header 'Content-Type: application/json' \
--data-raw '{
  "productId": 2,
  "billAmount": 10
}'

```

### [BILL] all approved
```ssh

curl --location --request GET 'http://localhost:8080/api/v1/bills/all/APPROVED' \
--header 'accept: */*' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huZG9lQGludm9pY2UuY29tIiwiaWF0IjoxNjk1NTkxOTExLCJleHAiOjE2OTU1OTI1MTV9.UCUexb8NPr2-ZN3EM5u9jZeANobpnoNgWG2Ne1fBoi03UG6Z6hXWhIrPFkTr6gY3tWNOSsEhvjT9rR6ITS0LXw'

```


### [BILL] all not approved
```ssh

curl --location --request GET 'http://localhost:8080/api/v1/bills/all/APPROVED' \
--header 'accept: */*' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huZG9lQGludm9pY2UuY29tIiwiaWF0IjoxNjk1NTkxOTExLCJleHAiOjE2OTU1OTI1MTV9.UCUexb8NPr2-ZN3EM5u9jZeANobpnoNgWG2Ne1fBoi03UG6Z6hXWhIrPFkTr6gY3tWNOSsEhvjT9rR6ITS0LXw'

```

## MIT License

Copyright (c) 2023 Nejla Şahin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
