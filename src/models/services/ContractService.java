package models.services;

import models.entities.Contract;
import models.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {

        // basicQuota : valor da parcela
        double basicQuota = contract.getTotalValue() / months;

        for (int i=1; i<=months;i++)  {
            // dueDate : vencimento da parcela
            LocalDate dueDate = contract.getDate().plusMonths(i);
            double interest = onlinePaymentService.interest(basicQuota, i) ;     // interest : juros
            double fee = onlinePaymentService.paymentFee(interest);  // fee : taxa
            double quota = basicQuota + interest + fee;
            contract.getInstallments().add(new Installment(dueDate, quota));
        }
//        contract.getInstallments().add(new Installment(LocalDate.of(2018, 7, 25), 206.04));
//        contract.getInstallments().add(new Installment(LocalDate.of(2018, 8, 25), 208.08));
//        contract = new Contract();
//        LocalDate date;
    }
}
