package jp.co.biglobe.workshopmobile.domain.fee;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * オプション月額料金
 */
@AllArgsConstructor
public enum PlanMonthlyFee {
    _1ギガ(new MonthlyFee(1000)),
    _3ギガ(new MonthlyFee(2000)),
    _30ギガ(new MonthlyFee(6000));

    @Getter
    private final MonthlyFee monthlyFee;
}
