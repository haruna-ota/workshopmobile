package jp.co.biglobe.workshopmobile.domain.fee;

import jp.co.biglobe.workshopmobile.domain.engagement.Engagement;
import lombok.Getter;
public class EngagementMonthlyTotalFee {
    @Getter
    private PlanMonthlyFee planMonthlyFee;
    @Getter
    private OptionMonthlyFee optionMonthlyFee;

    //コンストラクタ
    public EngagementMonthlyTotalFee(Engagement engagement) {
        planMonthlyFee = PlanMonthlyFee.create(engagement.getPlan());
        optionMonthlyFee = OptionMonthlyFee.create(engagement.getOption());

    }
    //月額の合計料金を計算する
    public MonthlyFee calc() {
        return new MonthlyFee(planMonthlyFee.getMonthlyFee().getValue() + optionMonthlyFee.getMonthlyFee().getValue());
    }

}
