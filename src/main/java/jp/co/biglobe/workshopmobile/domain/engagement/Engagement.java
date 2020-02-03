package jp.co.biglobe.workshopmobile.domain.engagement;

import jp.co.biglobe.workshopmobile.domain.fee.OptionMonthlyFee;
import jp.co.biglobe.workshopmobile.domain.fee.PlanMonthlyFee;
import jp.co.biglobe.workshopmobile.domain.option.Option;
import jp.co.biglobe.workshopmobile.domain.plan.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Engagement {
    @Getter
    Plan plan;
    @Getter
    Option option;

    //エンタメの申込制限
    public boolean isEntameFreeOk(Plan plan) {
        if (!plan.equals(Plan._1ギガ)) {
            return true;
        } else {
            throw new RuntimeException("エンタメフリーオプションを申し込めないプランです");
        }
    }

    //プランの料金
    public PlanMonthlyFee getPlanMonthlyFee(Plan plan) {
        if (plan.equals(Plan._1ギガ)) {
            return PlanMonthlyFee._1ギガ;
        } else if (plan.equals(Plan._3ギガ)) {
            return PlanMonthlyFee._3ギガ;
        } else if (plan.equals(Plan._30ギガ)) {
            return PlanMonthlyFee._30ギガ;
        } else {
            throw new RuntimeException("存在しないプラン料金です");
        }
    }

    //オプションの料金
    public OptionMonthlyFee getOptionMonthlyFee(Option option) {
        return option.equals(Option.エンタメフリー) && isEntameFreeOk(plan) ? OptionMonthlyFee.エンタメフリー : OptionMonthlyFee.なし;
    }

}
