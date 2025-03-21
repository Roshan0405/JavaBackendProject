package com.project.marprojectmodule.service;


import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentGatewayImplementation implements PaymentService {

    @Override
    public String makePayment(String orderId, long amount) throws StripeException {

        // 1. Create PriceCreateParam Object
        // INR, amount, orderId

        Stripe.apiKey = "sk_test_51R45zoRPGxoJP9ViZkO8Wcb5Qji6BAYvsDleh0PZ36QJSlWkHoPqyGduxZlnTnx1duqhlkZMMou9RajtR06j4S2l00vd6l47Jq";

        PriceCreateParams params = PriceCreateParams.builder()
                        .setCurrency("INR")
                        .setUnitAmount(amount)
                        .setProductData(PriceCreateParams.ProductData.builder().setName(orderId).build())
                        .build();

        Price price = Price.create(params);

//       Create the Payment Link

        PaymentLinkCreateParams linkparams = PaymentLinkCreateParams.builder()
                .addLineItem(PaymentLinkCreateParams.LineItem.builder()
                        .setPrice(price.getId())
                        .setQuantity(1L)
                        .build()
                )
                .setAfterCompletion(
                        PaymentLinkCreateParams.AfterCompletion.builder()
                                .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                .setRedirect(
                                        PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                .setUrl("https://probz.ai")
                                                .build()
                                )
                                .build()
                )
                .build();

        PaymentLink paymentLink = PaymentLink.create(linkparams);

        return paymentLink.getUrl();
    }
}
