package com.ovia.model.award;

import com.ovia.model.JsonModelObject;

import java.util.ArrayList;
import java.util.List;

public class Awards extends JsonModelObject {
    private List<Award> awardList;

    public List<Award> getAwardList() {
        if(awardList == null) {
            awardList = new ArrayList<>();
        }
        return awardList;
    }

    public void setAwardList(List<Award> awardList) {
        this.awardList = awardList;
    }
}
