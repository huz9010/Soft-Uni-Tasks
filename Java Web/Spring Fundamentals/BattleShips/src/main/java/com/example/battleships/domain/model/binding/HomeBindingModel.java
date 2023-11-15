package com.example.battleships.domain.model.binding;

import jakarta.validation.constraints.NotNull;

public class HomeBindingModel {

    @NotNull
    private Long attackerShipId;

    private Long defenderShipId;

    public HomeBindingModel() {
    }

    public Long getAttackerShipId() {
        return attackerShipId;
    }

    public void setAttackerShipId(Long attackerShipId) {
        this.attackerShipId = attackerShipId;
    }

    public Long getDefenderShipId() {
        return defenderShipId;
    }

    public void setDefenderShipId(Long defenderShipId) {
        this.defenderShipId = defenderShipId;
    }
}
