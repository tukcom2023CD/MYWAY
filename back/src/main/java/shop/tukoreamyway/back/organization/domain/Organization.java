package shop.tukoreamyway.back.organization.domain;

import shop.tukoreamyway.back.global.Basetime;
import shop.tukoreamyway.back.member.domain.MemberId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Organization {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private MemberId owner;
    private IndustryGroup industryGroup;
    private Basetime basetime;
}
