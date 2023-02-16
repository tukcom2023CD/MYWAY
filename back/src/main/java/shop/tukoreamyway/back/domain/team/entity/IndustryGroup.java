package shop.tukoreamyway.back.domain.team.entity;

import lombok.Getter;

@Getter
public enum IndustryGroup {
    IT("IT"),
    AGRICULTURE("농업"),
    MINE("광업"),
    MANUFACTURING("제조업"),
    HEAVY_INDUSTRY("중공업"),
    RENEWABLE_ENERGY("신재생 에너지"),
    ENVIRONMENT("환경"),
    ERECTION("건설"),
    SALE("판매"),
    FORTUNE("운수"),
    LODGING("숙박"),
    PUBLISHING("출판"),
    BROADCAST("방송통신"),
    FINANCE("금융"),
    REAL_ESTATE("부동산"),
    BUSINESS_SUPPORT("사업지원"),
    ADMINISTRATION("행정"),
    EDUCATION("교육"),
    HEALTH_WELFARE("보건복지"),
    ART_SPORTS("예술-스포츠"),
    ETC("기타");

    private final String name;

    IndustryGroup(String name) {
        this.name = name;
    }
}