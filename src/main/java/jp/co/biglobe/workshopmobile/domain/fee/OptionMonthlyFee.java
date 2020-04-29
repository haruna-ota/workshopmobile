package jp.co.biglobe.workshopmobile.domain.fee;

import jp.co.biglobe.workshopmobile.domain.option.Option;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * オプション月額料金
 */
@AllArgsConstructor
public class OptionMonthlyFee {
    @Getter
    private final MonthlyFee monthlyFee;

    public static OptionMonthlyFee create(Option option){
        if(option.equals(Option.エンタメフリー)){
            return new OptionMonthlyFee(new MonthlyFee(1200));
        }else {
            return new OptionMonthlyFee(new MonthlyFee(0));
        }
    }
}
