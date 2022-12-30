# MSA 기반 Agile 성과 분석 시스템 

# 서비스 개요
개요 머라쓰지 이게 첫마디가 중요한디

# Service Link
### Deployment Link(Not publish) : https://www.tukoreamyway.shop

### Alpha Test Link : http://223.255.205.62:30123


# 아키텍처 다이어그램
<img width="1113" alt="image" src="https://user-images.githubusercontent.com/55674648/209564860-d1cacb42-1f3d-4606-bddd-0cf55ea45f7f.png">

#### k8s Ingress nginx 안쓰는 이유
- NHN-Paasta 에서 단일 Namesapce만 지원 : ingress Controller apply 불가 ~~나도 쓰고싶어...EKS 갈아타?~~
<img width="441" alt="image" src="https://user-images.githubusercontent.com/55674648/209565047-4c4e3406-6308-4565-8235-cdcf4449925d.png">

- ingress 기능을 대체하기 위해 Forward Proxy Server 및 Gateway 구현
# CI/CD FLOW
<img width="637" alt="image" src="https://user-images.githubusercontent.com/55674648/209564873-00f677c5-6c14-4f4a-bb88-5b4458f65043.png">

