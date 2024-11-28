# Hexagonal Architecture(헥사고날 아키텍처)

헥사고날 아키턱처를 이해하기 위해 간단히 `Book Store` 서비스를 구성하여 보았습니다.

헥사고날 아키텍처는 애플리케이션의 비즈니스 로직을 중심으로 외부 스시템과의 의존성을 분리하는 소프트웨어 설계 방식입니다.

핵심 개념은 비즈니스로직, 포트, 어댑터 3가지 입니다.

1. 비즈니스 로직(Application Core)
    - 도메인 로직과 애플리케이션 규칙이 위치합니다.
    - 외부 시스템과 독립적이어야 합니다.
    - 내부 로직은 포트와 어뎁터를 통해 외부와 상호 작용합니다.
2. 포트(Ports)
    - 애플리케이션 내부와 외부를 연결하는 인터페이스 입니다.
    - 입력 포트(Inbound Port): 외부에서 애플리케이션을 호출하는 지점입니다.
    - 출력 포트(Output Port): 애플리케이션이 외부 시스템을 호출하는 지점입니다.
3. 어댑터(Adapters)
   - 포트를 구현하는 외부와의 실제 통신을 담당합니다.
   - 포트의 정의에 따라 동작하며, 외부 시스템(DB, 메시지 브로커)과 통신합니다.
   - 입력 어댑터(Inbound Adapter): 입력 포트를 구현하여 HTTP API, CLI, 메시지 큐 등을 통해 요청을 수신합니다.
   - 출력 어댑터(Outbound Adpter): 출력 포트를 구현하여 DB, 외부 API, 파일 시스템 등을 호출합니다.

자세한 내용을 아래 참고 자료를 보시면 됩니다.

![image](https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Hexagonal_Architecture.svg/626px-Hexagonal_Architecture.svg.png)

모듈 구조는 아래와 같습니다.

```shell
bookstore/
├── domain/           # 엔티티와 도메인 서비스
├── application/      # 유스케이스를 구현하고 도메인 레이어를 조합
├── infrastructure/   # 포트를 구현하여 왜부 시스템과 상호 작업
└── presentation/     # REST API 등의 사용자 인터페이스 제공
```

---

[Hexagonal Architecture](9https://en.wikipedia.org/wiki/Hexagonal_architecture_(software))
[헥사고날 아키텍처](https://velog.io/@p0tat0_chip/3.-%ED%8C%A8%ED%82%A4%EC%A7%80-%EA%B5%AC%EC%A1%B0)
