---
### gPRC Client    

---

**(1) V1 Version**
* ```main()``` 메소드를 통한 클라이언트 동작 (웹 환경 아님) 
* Library   
  * ```io.grpc:grpc-netty```
  * ```io.grpc:grpc-protobuf```
  * ```io.grpc:grpc-stub```
* Installation
  * ```./gradle build```
  * ````main()```` 메서드 실행
---    
**(2) V2 Version**
* WEB Server 구현
* Library
  * ````grpc-client-spring-boot-starter````
  * ```grpc-spring-boot-starter```
  * ```mybatis-spring-boot-starter```
* Installation
  * ````./gradlew clean bootRun ````   
* Database
  * H2 Embedded Database
---