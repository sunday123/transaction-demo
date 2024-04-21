package com.ij34.transaction.tcc.a.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

@LocalTCC
public interface PlaceAction {

    @TwoPhaseBusinessAction(name = "prepare", commitMethod = "confirm", rollbackMethod = "cancel" ,useTCCFence = true)
    public boolean prepare(BusinessActionContext actionContext, @BusinessActionContextParameter(paramName = "bNo") String bNo, @BusinessActionContextParameter(paramName = "orderNo") String orderNo);

    public boolean confirm(BusinessActionContext actionContext);

    public boolean cancel(BusinessActionContext actionContext);

}