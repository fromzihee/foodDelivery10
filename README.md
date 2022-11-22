## Model
www.msaez.io/#/storming/BlMX5BCHc0YEJeI3cq9YQSZVG8U2/d7c18adf3fb7549c6c46553769ae6994
![image](https://user-images.githubusercontent.com/78025432/203244048-30fd32e1-9738-421a-9ed3-3abc03766716.png)

![image](https://user-images.githubusercontent.com/487999/79708354-29074a80-82fa-11ea-80df-0db3962fb453.png)

# 예제 - 음식배달

본 예제는 MSA/DDD/Event Storming/EDA 를 포괄하는 분석/설계/구현/운영 전단계를 커버하도록 구성한 예제입니다.
이는 클라우드 네이티브 애플리케이션의 개발에 요구되는 체크포인트들을 통과하기 위한 예시 답안을 포함합니다.

# 체크포인트
1. Saga (Pub / Sub)
2. CQRS
3. Compensation / Correlation
4. Request / Response
5. Circuit Breaker
6. Gateway / Ingress

# 서비스 시나리오

배달의 민족 커버하기 - https://1sung.tistory.com/106

기능적 요구사항
1. 고객이 메뉴를 선택하여 주문한다
1. 고객이 결제한다
1. 주문이 되면 주문 내역이 입점상점주인에게 전달된다
1. 상점주인이 확인하여 요리해서 배달 출발한다
1. 고객이 주문을 취소할 수 있다
1. 주문이 취소되면 배달이 취소된다
1. 고객이 주문상태를 중간중간 조회한다
1. 주문상태가 바뀔 때 마다 카톡으로 알림을 보낸다

## Saga(Pub/Sub)
1. 기능추가: store에서 쿠폰이 발행이 되면 customer 카카오로 알림이 간다.
![image](https://user-images.githubusercontent.com/78025432/203253093-83aad525-cbbe-46f2-b1b4-5449a051299f.png)

![image](https://user-images.githubusercontent.com/78025432/203253414-08464303-703f-44b2-b5d4-3218c2db67c7.png)

![image](https://user-images.githubusercontent.com/78025432/203254832-b6a840d7-f7cf-408d-8e4f-67df36399b1b.png)

## Saga(Pub/Sub)
2. 기능수정: store에서 음식이 완료가 되면 customer 카카오로 알림이 간다.
![image](https://user-images.githubusercontent.com/78025432/203257023-9dd291d7-c929-444f-bf2e-027bbaa16da5.png)

![image](https://user-images.githubusercontent.com/78025432/203258184-aa0fb037-ec1b-4244-ac03-d46900cb7424.png)

![image](https://user-images.githubusercontent.com/78025432/203257470-87e14c15-d1cd-4416-89a6-a8865e942bee.png)

## CQRS
1. 거절되었을 때
![image](https://user-images.githubusercontent.com/78025432/203259054-e0d29356-303e-442c-996a-0e0776ef63c0.png)
![image](https://user-images.githubusercontent.com/78025432/203259203-bed55b24-165c-4737-a9de-0d864be777c8.png)
![image](https://user-images.githubusercontent.com/78025432/203259288-4205aca4-2dc3-49d1-8bc6-36e8b528f530.png)

## Gateway / Ingress
![image](https://user-images.githubusercontent.com/78025432/203259707-c551e7b5-9ad2-41b1-8ba1-aa97acabf2e0.png)

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- front
- store
- customer
- delivery


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- front
```
 http :8088/orders id="id" foodid="foodid" amount="amount" customerid="customerid" option="option" address="address" sts="sts" 
 http :8088/payments id="id" orderid="orderid" amount="amount" 
```
- store
```
 http :8088/orderManges id="id" foodid="foodid" customerid="customerid" orderid="orderid" sts="sts" count="count" 
```
- customer
```
 http :8088/notificationLogs id="id" customerid="customerid" message="message" 
```
- delivery
```
 http :8088/deliveries id="id" orderid="orderid" deliverymanid="deliverymanid" address="address" sts="sts" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

