package com.github.hronom.test.spring.webapp.pojos;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel("Status")
public class Status {
    @ApiModelProperty(value = "the id of the item", required = true)
    private boolean status = false;

    public void setStatus(boolean statusArg) {
        status = statusArg;
    }

    public boolean getStatus() {
        return status;
    }
}
