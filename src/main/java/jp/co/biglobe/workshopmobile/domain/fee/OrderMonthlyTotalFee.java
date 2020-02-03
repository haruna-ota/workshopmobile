package jp.co.biglobe.workshopmobile.domain.fee;

import jp.co.biglobe.workshopmobile.domain.engagement.Engagement;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class OrderMonthlyTotalFee {
    @Getter
    private static PlanMonthlyFee planMonthlyFee;
    @Getter
    private static OptionMonthlyFee optionMonthlyFee;

    //月額の合計料金を計算する
    public static int calc(Engagement engagement) {
        planMonthlyFee = engagement.getPlanMonthlyFee(engagement.getPlan());
        optionMonthlyFee = engagement.getOptionMonthlyFee(engagement.getOption());
        return planMonthlyFee.getMonthlyFee().getValue() + optionMonthlyFee.getMonthlyFee().getValue();
    }

}
