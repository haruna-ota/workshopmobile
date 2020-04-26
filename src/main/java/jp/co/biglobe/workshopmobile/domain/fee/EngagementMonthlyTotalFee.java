package jp.co.biglobe.workshopmobile.domain.fee;

import jp.co.biglobe.workshopmobile.domain.engagement.Engagement;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class EngagementMonthlyTotalFee {
    @Getter
    private static PlanMonthlyFee planMonthlyFee;
    @Getter
    private static OptionMonthlyFee optionMonthlyFee;

    //月額の合計料金を計算する
    public static MonthlyFee calc(Engagement engagement) {
        planMonthlyFee = engagement.getPlanMonthlyFee();
        optionMonthlyFee = engagement.getOptionMonthlyFee();
        return new MonthlyFee(planMonthlyFee.getMonthlyFee().getValue() + optionMonthlyFee.getMonthlyFee().getValue());
    }

}
