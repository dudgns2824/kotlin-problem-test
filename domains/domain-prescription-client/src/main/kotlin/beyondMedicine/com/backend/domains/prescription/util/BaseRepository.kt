package beyondMedicine.com.backend.domains.prescription.util

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired


abstract class BaseRepository {
    @Autowired
    lateinit var queryFactory: JPAQueryFactory

    @Autowired
    lateinit var entityManager: EntityManager
}