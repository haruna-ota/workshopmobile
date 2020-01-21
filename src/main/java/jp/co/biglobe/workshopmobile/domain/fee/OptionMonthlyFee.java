package jp.co.biglobe.workshopmobile.domain.fee;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * オプション月額料金
 */
@AllArgsConstructor
public enum OptionMonthlyFee {
    エンタメフリー(new MonthlyFee(1200)),
    なし(new MonthlyFee(0));

    @Getter
    private final MonthlyFee monthlyFee;
}
