package com.projectmanager.timer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.projectmanager.dao.PaymentDetailsDao;
import com.projectmanager.dao.TaxInvoiceDetailsDao;
import com.projectmanager.entity.PaymentDetails;
import com.projectmanager.entity.TaxInvoiceDetails;
import com.projectmanager.util.EmailUtils;
import com.projectmanager.util.Principal;

public class PaymentReminder {
	@Autowired
	TaxInvoiceDetailsDao taxInvoiceDetailsDao;

	@Autowired
	PaymentDetailsDao paymentDetailsDao;

	@Autowired
	Principal invoiceGenerator;

	@Autowired
	EmailUtils emailUtils;

	/*@Scheduled(cron = "* * 9 * * ?")*/
	public void sendReminder() {
		ArrayList<PaymentDetails> pendingpaymentDetailsList = paymentDetailsDao.getPendingPayentDetails();

		for (PaymentDetails pendingPaymentDetails : pendingpaymentDetailsList) {
			TaxInvoiceDetails taxInvoiceDetails = taxInvoiceDetailsDao
					.getTaxIvoiceData("taxInvoiceNo", "").get(0);

			taxInvoiceDetails.setRate(pendingPaymentDetails.getPendingAmount());
			/*invoiceGenerator.createInvoice(taxInvoiceDetails);*/

/*			emailUtils.sendMessageWithAttachment("",taxInvoiceDetails.getEmailAddress(),
					taxInvoiceDetails.getTaxInvoiceNo(), true, taxInvoiceDetails.getInvoiceNo());*/

			try {
				FileUtils.forceDelete(new File("/TaxInvoice.pdf"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private final String TAX_INVOICE_ATTACHMENT_NAME = "TaxInvoice.pdf";
}