package com.seaweed.identifier.user

import jakarta.persistence.*
import org.hibernate.annotations.DynamicUpdate
import org.springframework.security.crypto.password.PasswordEncoder

@Entity
@DynamicUpdate
@Table(name="USER")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var seq : Long? = null,
    var name : String? = null,
    @Column(unique = true)
    var id : String? = null,
    var password : String? = null,
) {
    override fun toString() : String{
        return """
            {
                seq = ${this.seq},
                name = ${this.name},
                id = ${this.id},
                password = ${this.password},
            }
        """.trimIndent()
    }
    fun encodePassword(passwordEncoder: PasswordEncoder) {
        this.password = passwordEncoder.encode(this.password)
    }
}
