package com.awsweb.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;



@Getter
@MappedSuperclass  // JPA Entity 클래스들이 basetimeentity 을 상속할 경우 필드를 createDate modifiedDate도 칼럼으로 인식할도록 함.
@EntityListeners(AuditingEntityListener.class)  // BaseTimeEntity클래스에 Auditing 기능을 포함시킴
public class BaseTimeEntity {

    @CreatedDate  // Entity가 생성되어 저장될 때 시간이 자동 저장됨.
    private LocalDateTime createDate;

    @LastModifiedDate // 조회한 Entity 값을 변경할 때 시간이 자동 저장됨.
    private LocalDateTime modifiedDate;

}
