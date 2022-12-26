# MSA 기반 Agile 성과 분석 시스템 

# 서비스 개요

# 아키텍처 다이어그램

#### k8s Ingress nginx 안쓰는 이유
- NHN-Paasta 에서 단일 Namesapce만 지원 : ingress Controller apply 불가 ~~나도 쓰고싶어...EKS 갈아타?~~
- ingress 기능을 대체하기 위해 Forward Proxy Server 및 Gateway 구현
# CI/CD FLOW

