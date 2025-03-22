package beyondMedicine.com.backend.domains.prescription.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

// 병원 테이블
@Entity
// 나중에 병원 기준으로 병원 도메인이 새로 생기거나 entity명이 중복 될 경우가 생기면 entity 이름이 변경 될 수 있음.
// 도메인 별로 infrastructure를 의존 하지 않고
// entity도 완전 나누는것이 목적이기 때문에 도메인 별로 hospitalEntity를 쓸 일이 있다면 도메인 별로 entity를 생성 하는 단점이 존재.
// 하지만 필요한 컬럼 데이터만 생성하여 쓰도록 개발하면 연관관계 조회 시 쓸데 없는 컬럼 조회를 줄일 수 있음.
@Table(name = "hospital")
class HospitalDomainEntity {
    /**
     * 병원 id
     */
    @Id
    @Column(name = "id")
    var id: Long? = null

    /**
     * 병원 이름
     */
    @Column(name = "hospital_name")
    var hospitalName: String? = null
}