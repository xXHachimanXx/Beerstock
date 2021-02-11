package com.digitalinnovationone.beerstock.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BeerType {
    LAGER("Lager"),
    HALZBIER("Malzbier"),
    WITBIER("Witbier"),
    WEISS("Weiss"),
    ALE("Ale"),
    IPA("Ipa"),
    STOUT("Stout");

    private final String description;
}
