package com.hoangtien.VnPay.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Setter
public class PaymentRequestDto {
    private String orderType;
    private Long amount;
    private String bankCode;
}
