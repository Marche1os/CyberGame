package com.marchelos.player.hero

import com.marchelos.economy.Money
import com.marchelos.player.skill.Skill
import com.marchelos.player.skill.SkillAttributes
import com.marchelos.player.skill.SkillDescription
import com.marchelos.player.skill.SkillId
import com.marchelos.player.skill.SkillImpl
import com.marchelos.player.skill.SkillLevel
import com.marchelos.player.skill.SkillName
import java.math.BigDecimal

class HeroImpl(
    private val attributes: HeroAttributes,
) : Hero {
    override val attrs: HeroAttributes
        get() = attributes

    override fun learnSkill(skill: Skill) {
        require(!attributes.skills.contains(skill))

        attributes.skills.add(skill)
    }

    override fun currentMoney(): Money {
        TODO("Not yet implemented")
    }

    override fun getSkillBy(skillId: String): Skill = attributes.skills.find { it.id().value == skillId }!!

    companion object Factory {
        private var hero: HeroImpl? = null

        fun create(): HeroImpl {
            if (hero != null) {
                return hero!!
            }

            hero = HeroImpl(
                HeroAttributes(
                    Money(BigDecimal.ZERO),
                    mutableSetOf(
                        SkillImpl(
                            SkillAttributes(
                                SkillId("ReduceTimeSkill"),
                                SkillName("Таймер"),
                                SkillDescription("Навык увеличивает время на взлом"),
                                SkillLevel(10)
                            )
                        )
                    ),
                    Points(10),
                )
            )

            return hero as HeroImpl
        }
    }
}