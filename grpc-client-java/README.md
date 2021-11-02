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
* 요구사항 
  * 주문(Order) 시스템 구현
  * 주문 Database Access (주문 데이터 생성, 조회)
  * External Service Access (상품 정보 조회)
* Library
  * ````grpc-client-spring-boot-starter````
  * ```grpc-spring-boot-starter```
  * ```mybatis-spring-boot-starter```
* Installation
  * ````./gradlew clean bootRun ````   
* Database
  * H2 Embedded Database

---