# PROJETO INTEGRADOR 2022

## POST
`/users`  <br/>
- Criar novo usuario

**Body**
```
}
	"username": "USER",
	"email": "EMAIL",
	"password": "PASSWORD"
}
```
**Status Code: 201 Created ✔️**
## DELETE
`/users/{id}`  <br/>
- Deletar usuario por id

**Header**
```
Authorization: {TOKEN}
```
**Status Code: 204 No Content ✔️**<br/>
**Status Code: 403 Unauthorized ❌**

## GET
`/users`  <br/>
- Listar usuarios

**Header**
```
Authorization: {TOKEN}
```
**Status Code: 200 OK ✔️**<br/>
**Status Code: 403 Unauthorized ❌**

`/users/{id}`  <br/>
- Listar usuario por id

**Header**
```
Authorization: {TOKEN}
```
**Status Code: 200 OK ✔️**<br/>
**Status Code: 403 Unauthorized ❌**

## PUT
`/users/{id}`  <br/>
- Alterar dados da conta por id
- É obrigatorio passar a senha atual pra realizar qualquer tipo desta requisição
- Campos que podem ser alterados: "user", "email"
- Para alterar senha é necessario passar dois campos com mesmo valor: "password", "confirmPassword"

**Body**
```
}
  "username": "NOVO USER",
  "actualPassword": "SENHA ATUAL"
}
```
**Header**
```
Authorization: {TOKEN}
```
**Status Code: 200 OK ✔️**<br/>
**Status Code: 403 Unauthorized ❌**



