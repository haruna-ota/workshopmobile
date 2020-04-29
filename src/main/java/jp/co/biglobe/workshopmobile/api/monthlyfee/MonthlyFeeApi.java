package jp.co.biglobe.workshopmobile.api.monthlyfee;

import jp.co.biglobe.workshopmobile.domain.fee.MonthlyFee;
import jp.co.biglobe.workshopmobile.domain.fee.EngagementMonthlyTotalFee;
import jp.co.biglobe.workshopmobile.domain.option.EntameFreeEngagementCheckPolicy;
import jp.co.biglobe.workshopmobile.domain.option.Option;
import jp.co.biglobe.workshopmobile.domain.engagement.Engagement;
import jp.co.biglobe.workshopmobile.domain.plan.Plan;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class MonthlyFeeApi {

    @RequestMapping(value = "/monthly-fee", method = RequestMethod.GET)
    public Map invoke(
            Request request
    ) {
        //プラン
        Plan plan = null;
        try {
            if (request.getPlan().equals(Request.PlanForm.g1)) {
                plan = Plan._1ギガ;
            } else if (request.getPlan().equals(Request.PlanForm.g3)) {
                plan = Plan._3ギガ;
            } else if (request.getPlan().equals(Request.PlanForm.g30)) {
                plan = Plan._30ギガ;
            }
        } catch (Exception e) {
            throw new RuntimeException("許容していないプランコードです");
        }

        //オプション
        Option option = request.isEntame_free() ? Option.エンタメフリー : Option.オプションなし;

        
        //契約
        //エンタメPolicyに対して、プランをもとにエンタメ申し込み可否をきいてから契約つくる
        if(option == Option.エンタメフリー){
            EntameFreeEngagementCheckPolicy.isEntameFreeOk(plan);
        }
        Engagement engagement = new Engagement(plan, option);

        //月額料金
        EngagementMonthlyTotalFee engagementMonthlyTotalFee = new EngagementMonthlyTotalFee(engagement);

        Map<String, Object> res = new HashMap<>();
        res.put("monthly_fee", engagementMonthlyTotalFee.calc().getValue() /* TODO 月額料金を返す */);
        return res;
    }
}
