package com.marchelos.player

class SkillImpl(
    private val attributes: SkillAttributes,
) : Skill {
    override val attrs: SkillAttributes
        get() = attributes

    override fun upgradeSkill(): UpgradeSkillStatus {
        val currentLevel = attrs.level
        if (currentLevel.value < SkillLevel.MAX_LEVEL) {
            attrs.level = currentLevel.increaseLevel()
            return UpgradeSkillStatus.Success
        }

        return UpgradeSkillStatus.Failure
    }

    override fun currentLevel(): SkillLevel = attrs.level

    override fun name(): SkillName = attrs.name

    override fun description(): SkillDescription = attrs.description

    override fun id(): SkillId = attrs.id
}