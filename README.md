## **<center>grpc-java</center>**


https://img.shields.io/appveyor/ci/danday74/shelljs-exec/master.svg?style=flat-square&label=build


#### **Introduce**  

---
gRPC Java 관련 예제로 Client와 Server의 프로젝트를 분리하여 작성하였다. 각 프로젝트 내에는 V1, V2 버전이 존재하는 데 V1 에는 웹 환경이 아닌 grpc-java API만을 통해 개발된 코드이고 V2는 스프링 부트를 활용하여 웹 환경으로 개발하였다.

---

#### **gRPC 이란?**   

---
gRPC는 구글에서 마이크로서버스에 사용하던 단일 범용 RPC 인프라 Stubby에서 시작하였다. Stubby 다음 버전을 계획하면서 외부에 오픈하기로 결정하였다. 높은 생산성과 유지보수, 다양한 언어와 플랫폼 지원, 높은 메시지 압축률과 성능 등의 특징을 가지고 있는 오픈된 범용 RPC 프레임 워크 이다.    

---  

#### **중요 개념들?**   

---

* Stub
* HTTP/2
* Protocol Buffers
* proto 파일

---
#### **References**    
---
* [gRPC Java Reference](https://grpc.io/docs/languages/java/)   
* [Spring Camp 2017, 오명운 님](https://www.slideshare.net/hanmomhanda/spring-camp-2017-g-rpc-grpc-75314444)   
* [grpc-spring-boot](https://yidongnan.github.io/grpc-spring-boot-starter/en/)     
* [gRPC 설명자료](https://meetup.toast.com/posts/261)
---