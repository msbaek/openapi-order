* [OpenAPI/Swagger UI & Codegen with Spring Boot](https://medium.com/swlh/openapi-swagger-ui-codegen-with-spring-boot-1afb1c0a570e)
* [YAML 구조](https://swagger.io/docs/specification/basic-structure/)
* [OpenAPI Specification](https://swagger.io/specification/)
* [Swagger Editor](https://editor.swagger.io/)

Controller를 제공해야 local editor에서 보임 ???
아니면 No operations defined in spec!
override를 하지 않고 implements만 해도 editor에선 보임

mvn clean install해야 local editor에서 제대로 보임

https://petstore3.swagger.io/

https://petstore3.swagger.io/api/v3/openapi.json

https://github.com/OAI/OpenAPI-Specification/blob/main/examples/v3.0/petstore.yaml

https://github.com/swagger-api/swagger-petstore/blob/master/src/main/resources/openapi.yaml
- 이 파일을 이용하면 n개의 controller를 만들 수 있음

https://editor.swagger.io/

```shell
mvn clean compile
```
하면 generate됨