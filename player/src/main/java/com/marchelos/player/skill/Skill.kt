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

    fun name(): SkillName

    fun description(): SkillDescription

    fun id(): SkillId
}

data class SkillAttributes(
    val id: SkillId,
    val name: SkillName,
    val description: SkillDescription,
    var level: SkillLevel,
)

sealed interface UpgradeSkillStatus {
    data object Success : UpgradeSkillStatus
    data object Failure : UpgradeSkillStatus
}