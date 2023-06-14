# restapi
Developer Test REST API

Sebelum running project ini pastikan nama database sudah ada di local atau di server

Create first

Create DB (sesuai dengan application.yml):
```
CREATE DATABASE developer_test;
```

Untuk Pengujian API, terlampir Postman di dalam project

API Sign Up

data admin, contoh:
```
URL : http://localhost:8060/auth/signup
Body :
{
"username": "admin",
"password": "password",
"is_admin": true
}
```
data user, contoh:
```
URL : http://localhost:8060/auth/signup
Body :
{
"username": "user",
"password": "password",
"is_admin": false
}
```

API Sign In

```
URL : http://localhost:8060/auth/signin
Body :
{
    "username": "admin",
    "password": "password"
}
```

API List Job With Auth
```
URL : http://localhost:8060/api/v1/job
Headers : Authorization:Bearer {{token dari response signin}}
```

API Detail Job With Auth
```
URL : http://localhost:8060/api/v1/job/{id}
Headers : Authorization:Bearer {{token dari response signin}}
```