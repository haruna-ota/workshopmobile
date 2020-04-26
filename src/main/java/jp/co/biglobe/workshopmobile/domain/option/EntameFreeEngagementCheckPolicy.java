package jp.co.biglobe.workshopmobile.domain.option;

import jp.co.biglobe.workshopmobile.domain.plan.Plan;

public class EntameFreeEngagementCheckPolicy {
    //エンタメの申込制限
    public static boolean isEntameFreeOk(Plan plan) {
        if (!plan.equals(Plan._1ギガ)) {
            return true;
        } else {
            throw new RuntimeException("エンタメフリーオプションを申し込めないプランです");
        }
    }
}
