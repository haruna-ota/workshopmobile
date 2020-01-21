package jp.co.biglobe.workshopmobile.domain.order;

import jp.co.biglobe.workshopmobile.domain.fee.OptionMonthlyFee;
import jp.co.biglobe.workshopmobile.domain.fee.PlanMonthlyFee;
import jp.co.biglobe.workshopmobile.domain.option.Option;
import jp.co.biglobe.workshopmobile.domain.plan.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Order {
    @Getter
    Plan plan;
    @Getter
    Option option;

    //エンタメの申込制限
    public boolean isEntameFreeOk(Plan plan) {
        return !plan.equals(Plan._1ギガ);
    }

    //プランの料金
    public PlanMonthlyFee getPlanMonthlyFee(Plan plan) {
        if (plan.equals(Plan._1ギガ)) {
            return PlanMonthlyFee._1ギガ;
        } else if (plan.equals(Plan._3ギガ)) {
            return PlanMonthlyFee._3ギガ;
        } else {
            return PlanMonthlyFee._30ギガ;
        }
    }

    //オプションの料金
    public OptionMonthlyFee getOptionMonthlyFee(Option option) {
        return option.equals(Option.エンタメフリー) && isEntameFreeOk(plan) ? OptionMonthlyFee.エンタメフリー : OptionMonthlyFee.なし;
    }

}
