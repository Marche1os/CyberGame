package com.marchelos.player.skill

/**
 * Навык
 */
interface Skill {

    // Атрибуты
    val attrs: SkillAttributes

    // Команды

    /**
     * Постусловие: Если текущий уровень не максимальный, то статус обновлен. И возвращен соответствующий статус [UpgradeSkillStatus]
     * [UpgradeSkillStatus.Success] - навык улучшен
     * [UpgradeSkillStatus.Failure] - Уровень навыка максимален и дальнейшее улучшение невозможно
     */
    fun upgradeSkill(): UpgradeSkillStatus

    // Запросы

    fun currentLevel(): SkillLevel

    fun name(): String

    fun description(): SkillDescription

    fun id(): SkillId
}

data class SkillAttributes(
    val id: SkillId,
    val name: SkillName,
    val description: SkillDescription,
    var level: SkillLevel,
    var status: Status = Status.NOT_APPLIED,
)

sealed interface Status {
    data object APPLIED : Status
    data object NOT_APPLIED : Status
}

sealed interface UpgradeSkillStatus {
    data object Success : UpgradeSkillStatus
    data object Failure : UpgradeSkillStatus
}