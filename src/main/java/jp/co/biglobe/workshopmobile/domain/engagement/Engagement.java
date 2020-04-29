package jp.co.biglobe.workshopmobile.domain.engagement;

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
}
