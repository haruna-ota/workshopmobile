package jp.co.biglobe.workshopmobile.domain.fee;

import jp.co.biglobe.workshopmobile.domain.plan.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * プラン月額料金
 */
@AllArgsConstructor
public class PlanMonthlyFee {
    @Getter
    private final MonthlyFee monthlyFee;

    public static PlanMonthlyFee create(Plan plan){
        if (plan.equals(Plan._1ギガ)) {
            return new PlanMonthlyFee(new MonthlyFee(1000));
        } else if (plan.equals(Plan._3ギガ)) {
            return new PlanMonthlyFee(new MonthlyFee(2000));
        } else if (plan.equals(Plan._30ギガ)) {
            return new PlanMonthlyFee(new MonthlyFee(6000));
        } else {
            throw new RuntimeException("存在しないプラン料金です");
        }
    }
}
